package metaprocessor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes({ "metaprocessor.annotations.PrintMe" })
public class PrintMeAnnotationProcessor extends AbstractProcessor {

	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment env) {
		Messager messager = processingEnv.getMessager();
		for (TypeElement te : annotations) {
			for (Element e : env.getElementsAnnotatedWith(te)) {
				messager.printMessage(Diagnostic.Kind.NOTE,
						"Printing: " + e.toString());
			}
		}
		return true;
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

}

package project.onlinecompiler.util;

import java.io.File;
import java.io.IOException;

public class TestCaseCompiler extends Compiler {

	public String compile(String className, String location) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("cmd.exe /c javac -cp " + super.junitJarFile + " " + className + ".java", null,
				new File(location));
		return super.getErrorMessage(process);
	}

}

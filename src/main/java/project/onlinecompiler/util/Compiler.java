package project.onlinecompiler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;

public abstract class Compiler {

	@Value("${junitJarFile}")
	protected String junitJarFile;

	public abstract String compile(String className, String location) throws IOException;

	public String getErrorMessage(Process process) throws IOException {
		String line;
		StringBuffer message = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		while ((line = br.readLine()) != null) {
			message.append(line.trim());
			message.append("\n");
		}

		return message.toString();
	}

}

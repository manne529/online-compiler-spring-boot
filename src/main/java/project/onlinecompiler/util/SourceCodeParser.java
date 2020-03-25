package project.onlinecompiler.util;

import org.springframework.stereotype.Component;

import project.onlinecompiler.exceptions.ClassKeyWordMissingException;

@Component
public class SourceCodeParser {

	public String data;

	public SourceCodeParser() {
	}

	public SourceCodeParser(String data) {
		this.data = data;
		System.out.println(data);
	}

	public String getClassName() throws ClassKeyWordMissingException {
		int index = data.indexOf("public class");
		int flowerBracketIndex;
		String filename = null;

		if (index < 0) {
			index = data.indexOf("class");
			if (index < 0) {
				throw new ClassKeyWordMissingException();
			}
			flowerBracketIndex = data.indexOf("{", index + 6);
			filename = data.substring(index + 6, flowerBracketIndex).trim();
		} else {
			flowerBracketIndex = data.indexOf("{", index + 13);
			filename = data.substring(index + 13, flowerBracketIndex).trim();
		}
		return filename;
	}

}

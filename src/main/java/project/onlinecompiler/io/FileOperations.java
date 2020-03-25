package project.onlinecompiler.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import project.onlinecompiler.exceptions.ClassKeyWordMissingException;
import project.onlinecompiler.util.SourceCodeParser;

public class FileOperations {

	private String fileContent;
	private String directory;
	private String filename;
	private String extension;

	private SourceCodeParser sourceCodeParser;

	public FileOperations() {
	}

	public FileOperations(String fileContent, String path, String filename, String extension) throws IOException {
		this.directory = path + "/" + filename;
		this.filename = filename;
		this.extension = extension;
		this.fileContent = fileContent;
	}

	public void save() throws IOException {

		File directory = new File(this.directory);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/" + filename + extension));
		writer.write(fileContent);
		writer.flush();
		writer.close();
	}

	public void renameWithClassName() throws IOException, ClassKeyWordMissingException {
		sourceCodeParser = new SourceCodeParser(fileContent);
		String className = sourceCodeParser.getClassName();
		Path source = Paths.get(directory, filename + extension);
		Files.move(source, source.resolveSibling(className + extension));
	}

}

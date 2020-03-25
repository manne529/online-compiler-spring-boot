package project.onlinecompiler.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import project.onlinecompiler.exceptions.ClassKeyWordMissingException;
import project.onlinecompiler.util.SourceCodeParser;

@Component
public class FileOperations {

	private String fileContent;
	private String path;
	private String filename;
	private String extension;

	private SourceCodeParser sourceCodeParser;

	public FileOperations() {
	}

	public FileOperations(InputStream inputStream, String path, String filename, String extension) throws IOException {
		this.path = path;
		this.filename = filename;
		this.extension = extension;
		byte[] fileBytes = new byte[inputStream.available()];
		inputStream.read(fileBytes);
		fileContent = new String(fileBytes);
		inputStream.close();
	}

	public void save() throws IOException {

		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + filename + extension));
		writer.write(fileContent);
		writer.flush();
		writer.close();
	}

	public void renameWithClassName() throws IOException, ClassKeyWordMissingException {
		sourceCodeParser = new SourceCodeParser(fileContent);
		String className = sourceCodeParser.getClassName();
		Path source = Paths.get(path, filename + extension);
		Files.move(source, source.resolveSibling(className + extension));
	}

}

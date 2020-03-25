package project.onlinecompiler.exceptions;

public class ClassKeyWordMissingException extends Exception {

	@Override
	public String getMessage() {
		return "class keyword is missing";
	}
}

package org.javaguru.mentor.lesson_18.lessoncode;

public class AccessDeniedException extends Exception {

	private String invalidSecurityKey;

	public AccessDeniedException(String message, String invalidSecurityKey) {
		super(message);
		this.invalidSecurityKey = invalidSecurityKey;
	}

	public String getInvalidSecurityKey() {
		return invalidSecurityKey;
	}
}

package org.javaguru.mentor.lesson_18.lessoncode;

public class AccessDeniedUncheckedException extends RuntimeException {

	private String invalidSecurityKey;

	public AccessDeniedUncheckedException(String message, String invalidSecurityKey) {
		super(message);
		this.invalidSecurityKey = invalidSecurityKey;
	}

	public String getInvalidSecurityKey() {
		return invalidSecurityKey;
	}
}
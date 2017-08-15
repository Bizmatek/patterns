package com.epam.pavel_loginov.patterns.patterns.builder;

import com.epam.pavel_loginov.patterns.business_objects.Letter;

public class LetterWriter {
	private LetterBuilder letterBuilder;

	public void constructLetter() {

		letterBuilder.createLetter();
		letterBuilder.buildAddress();
		letterBuilder.buildSubject();
		letterBuilder.buildText();
	}

	public void setLetterBuilder(LetterBuilder builder) {
		letterBuilder = builder;
	}

	public Letter getLetter() {
		return letterBuilder.getLetter();
	}
}

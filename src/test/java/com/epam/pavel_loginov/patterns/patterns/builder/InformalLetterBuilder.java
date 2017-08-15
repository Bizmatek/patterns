package com.epam.pavel_loginov.patterns.patterns.builder;

import java.util.Date;
import com.epam.pavel_loginov.patterns.business_objects.Letter;
import com.epam.pavel_loginov.patterns.tools.FileReader;

public class InformalLetterBuilder extends LetterBuilder {
	public InformalLetterBuilder() {

		property = FileReader.getProperty("src/test/resources/InformalLetter.properties");
	}

	public void buildAddress() {

		letter.setAddress(property.getProperty("to"));
	}

	public void buildSubject() {
		letter.setSubject(property.getProperty("subj") + new Date().getTime());
	}

	public void buildText() {
		letter.setText(property.getProperty("text"));
	}

	public void createLetter() {

		this.letter = new Letter();
	}

	public void build() {
		createLetter();
		buildAddress();
		buildSubject();
		buildText();
	}

}

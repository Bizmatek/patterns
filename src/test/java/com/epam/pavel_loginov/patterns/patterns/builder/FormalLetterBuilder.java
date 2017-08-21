package com.epam.pavel_loginov.patterns.patterns.builder;

import java.util.Date;

import com.epam.pavel_loginov.patterns.business_objects.Letter;
import com.epam.pavel_loginov.patterns.tools.FileReader;
/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 * Description: Class which builds formal letter
 */
public class FormalLetterBuilder extends LetterBuilder {
	public FormalLetterBuilder() {
		property = FileReader.getProperty("src/test/resources/FormalLetter.properties");

	}

	protected void buildAddress() {

		letter.setAddress(property.getProperty("to"));
	}

	protected void buildSubject() {
		letter.setSubject(property.getProperty("subj") + new Date().getTime());
	}

	protected void buildText() {
		letter.setText(property.getProperty("text"));
	}

	protected void createLetter() {

		this.letter = new Letter();
	}

	public void build() {
		createLetter();
		buildAddress();
		buildSubject();
		buildText();
	}
}

package com.epam.pavel_loginov.patterns.patterns.builder;

import java.io.FileInputStream;
import java.util.Properties;

import com.epam.pavel_loginov.patterns.business_objects.Letter;

public abstract class LetterBuilder {
	protected Letter letter;

	protected Properties property;
	protected FileInputStream fis;

	public Letter getLetter() {
		return this.letter;
	}

	public abstract void createLetter();

	public abstract void buildAddress();

	public abstract void buildSubject();

	public abstract void buildText();

	public abstract void build();

}

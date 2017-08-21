package com.epam.pavel_loginov.patterns.patterns.builder;

import java.io.FileInputStream;
import java.util.Properties;

import com.epam.pavel_loginov.patterns.business_objects.Letter;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 * Description: Abstract class for letters building.
 */

public abstract class LetterBuilder {
	protected Letter letter;

	protected Properties property;
	protected FileInputStream fis;

	public Letter getLetter() {
		return this.letter;
	}

	protected abstract void createLetter();

	protected abstract void buildAddress();

	protected abstract void buildSubject();

	protected abstract void buildText();

	public abstract void build();

}

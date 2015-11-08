package com.ggl.hangman.model;

public class PhraseFactory implements IPhraseFactory{

	public IPhrase createPhrase(String category) {
		if(category.equals("Movie"))
			return new MoviePhrase();
		else if(category.equals("Book"))
			return new BookPhrase();
		return null;
	}
}

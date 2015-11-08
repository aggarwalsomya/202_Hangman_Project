package com.ggl.hangman.model;

public class PhraseFactory implements IPhraseFactory{

	public IPhrase createPhrase(String category) {
		if(category.equals(Menu.MOVIE_CATEGORY))
			return new MoviePhrase();
		else if(category.equals(Menu.BOOK_CATEGORY))
			return new BookPhrase();
		return null;
	}
}

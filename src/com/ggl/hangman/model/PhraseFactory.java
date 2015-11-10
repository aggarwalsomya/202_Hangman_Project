package com.ggl.hangman.model;

public class PhraseFactory implements IPhraseFactory{

	public IPhrase createPhrase(String category) {
		if(category.equals(HangmanConstants.MOVIE_CATEGORY))
			return new MoviePhrase();
		else if(category.equals(HangmanConstants.BOOK_CATEGORY))
			return new BookPhrase();
		return null;
	}
}

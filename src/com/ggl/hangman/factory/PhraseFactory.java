/*Factory here is created based on the book or movie category chosen by the user.*/
package com.ggl.hangman.factory;

import com.ggl.hangman.common.BookPhrase;
import com.ggl.hangman.common.HangmanConstants;
import com.ggl.hangman.common.MoviePhrase;

public class PhraseFactory implements IPhraseFactory{

	public IPhrase createPhrase(String category) {
		if(category.equals(HangmanConstants.MOVIE_CATEGORY))
			return new MoviePhrase();
		else if(category.equals(HangmanConstants.BOOK_CATEGORY))
			return new BookPhrase();
		return null;
	}
}

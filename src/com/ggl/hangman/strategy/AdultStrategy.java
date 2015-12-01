/*Adult strategy is picked up when a user enters his age between 20-99 years.
 * Phrases will be shown as per the age and the category chosen previously.*/
package com.ggl.hangman.strategy;

import java.util.ArrayList;
import java.util.List;

import com.ggl.hangman.factory.IPhrase;

public class AdultStrategy implements IAgeStrategy {
	@Override
	public List<String> getList(IPhrase phrase) {
		List<String> phrases = new ArrayList<String>();
		
		System.out.println("AdultStrategy : " + phrase.getClass().getName());
		if(phrase.getClass().getName().contains("MoviePhrase")) {
	        phrases.add("Terminator");
	        phrases.add("Big Daddy");
	        phrases.add("Legally Blonde");
		} else {
			phrases.add("Harry Potter");
			phrases.add("Da Vinci Code");
			phrases.add("Angels and Demons");	
		}
		return phrases;
	}
}

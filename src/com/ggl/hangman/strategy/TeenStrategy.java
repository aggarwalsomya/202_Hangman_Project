/*Teen strategy is picked up when a user enters his age between 13-19 years.
 * Phrases will be shown as per the age and the category chosen previously.*/
package com.ggl.hangman.strategy;

import java.util.ArrayList;
import java.util.List;

import com.ggl.hangman.factory.IPhrase;

public class TeenStrategy implements IAgeStrategy {
	@Override
	public List<String> getList(IPhrase phrase) {
		List<String> phrases = new ArrayList<String>();
		
		System.out.println("TeenStrategy : " + phrase.getClass().getName());
		if(phrase.getClass().getName().contains("MoviePhrase")) {
	        phrases.add("Harry Potter and Deathly Hallows");
	        phrases.add("Tintin");
	        phrases.add("Lord of Rings");
		} else {
			phrases.add("Harry Potter and philosophers stone");
			phrases.add("Goosebumps");
			phrases.add("Sweet Valley twins");	
		}
		return phrases;
	}
}

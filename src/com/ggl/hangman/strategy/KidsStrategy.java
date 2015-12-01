/*Kids strategy is picked up when a user enters his age between 3-12 years.
 * Phrases will be shown as per the age and the category chosen previously.*/
package com.ggl.hangman.strategy;

import java.util.ArrayList;
import java.util.List;

import com.ggl.hangman.factory.IPhrase;

public class KidsStrategy implements IAgeStrategy {
	@Override
	public List<String> getList(IPhrase phrase) {
		List<String> phrases = new ArrayList<String>();
		
		System.out.println("KidsStrategy : " + phrase.getClass().getName());
		if(phrase.getClass().getName().contains("MoviePhrase")) {
	        phrases.add("Frozen");
	        phrases.add("Inside Out");
	        phrases.add("Rapenzul");
		} else {
			phrases.add("A cat in the hat");
			phrases.add("Hare and tortoise");
			phrases.add("Jack and beanstalk");	
		}
		return phrases;
	}
}

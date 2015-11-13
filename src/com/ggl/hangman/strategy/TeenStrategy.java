package com.ggl.hangman.strategy;

import java.util.ArrayList;
import java.util.List;

import com.ggl.hangman.model.IPhrase;

public class TeenStrategy implements AgeStrategy {
	@Override
	public List<String> getList(IPhrase phrase) {
		List<String> phrases = new ArrayList<String>();
		
		System.out.println("KidsStrategy : " + phrase.getClass().getName());
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

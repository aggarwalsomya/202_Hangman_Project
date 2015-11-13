package com.ggl.hangman.strategy;

import java.util.List;

import com.ggl.hangman.model.IPhrase;

public class Context {
	private AgeStrategy strategy;

	public Context(AgeStrategy strategy){
		this.strategy = strategy;
	}

	public List<String> executeStrategy(IPhrase phrase){
		return strategy.getList(phrase);
	}
}

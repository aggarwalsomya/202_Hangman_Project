package com.ggl.hangman.strategy;

import java.util.List;

import com.ggl.hangman.factory.IPhrase;

public class Context {
	private IAgeStrategy strategy;

	public Context(IAgeStrategy strategy){
		this.strategy = strategy;
	}

	public List<String> executeStrategy(IPhrase phrase){
		return strategy.getList(phrase);
	}
}

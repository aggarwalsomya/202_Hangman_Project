package com.ggl.hangman.strategy;

import java.util.List;

import com.ggl.hangman.factory.IPhrase;

public interface IAgeStrategy {
	List<String> getList(IPhrase phrase);
}

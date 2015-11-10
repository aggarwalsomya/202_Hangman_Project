package com.ggl.hangman.strategy;

import java.util.List;

import com.ggl.hangman.model.IPhrase;

public interface AgeStrategy {
	List<String> getList(String ageCategory, IPhrase phrase);
}

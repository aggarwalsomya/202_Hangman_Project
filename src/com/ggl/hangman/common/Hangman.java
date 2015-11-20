package com.ggl.hangman.common;

import java.util.List;

import javax.swing.SwingUtilities;

import com.ggl.hangman.factory.IPhraseFactory;
import com.ggl.hangman.strategy.AdultStrategy;
import com.ggl.hangman.strategy.IAgeStrategy;
import com.ggl.hangman.strategy.KidsStrategy;
import com.ggl.hangman.strategy.TeenStrategy;

//Here Hangman is a thread. new Hangman wherever done will create a new thread and call its run method
public class Hangman implements Runnable {

	private String category;
	private IPhraseFactory phraseFactory_;
	private String ageCategory;
	
    public Hangman(String ctgry, IPhraseFactory inFactory, String ageCategory) {
		this.category = ctgry;
		this.phraseFactory_ = inFactory;
		this.ageCategory = ageCategory;
		
		
	}

	@Override
    public void run() {
        new HangmanFrame(new HangmanModel(this.phraseFactory_, this.category, this.ageCategory));
    }
	
	
}
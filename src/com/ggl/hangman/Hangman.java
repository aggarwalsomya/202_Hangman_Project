package com.ggl.hangman;

import javax.swing.SwingUtilities;
 

import com.ggl.hangman.model.HangmanModel;
import com.ggl.hangman.model.IPhraseFactory;
import com.ggl.hangman.view.HangmanFrame;

//Here Hangman is a thread. new Hangman wherever done will create a new thread and call its run method
public class Hangman implements Runnable {

	private String category;
	private IPhraseFactory phraseFactory_;
    public Hangman(String ctgry, IPhraseFactory inFactory) {
		this.category = ctgry;
		this.phraseFactory_ = inFactory;
	}

	@Override
    public void run() {
        new HangmanFrame(new HangmanModel(this.phraseFactory_, this.category));
    }
}
package com.ggl.hangman.common;
import com.ggl.hangman.factory.IPhraseFactory;

//Here Hangman is a thread. new Hangman wherever done will create a new thread and call its run method
public class Hangman implements Runnable {

	/*Category represents the book or movie category*/
	private String category;
	private IPhraseFactory phraseFactory_;
	/*Age is from the 5-12, 13-19, 20-99*/
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
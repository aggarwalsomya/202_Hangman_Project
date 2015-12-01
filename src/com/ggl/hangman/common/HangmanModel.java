package com.ggl.hangman.common;
 
import java.util.ArrayList;
import java.util.List;

import com.ggl.hangman.factory.IPhrase;
import com.ggl.hangman.factory.IPhraseFactory;
import com.ggl.hangman.observer.IObserver;
import com.ggl.hangman.strategy.AdultStrategy;
import com.ggl.hangman.strategy.IAgeStrategy;
import com.ggl.hangman.strategy.Context;
import com.ggl.hangman.strategy.KidsStrategy;
import com.ggl.hangman.strategy.TeenStrategy;

public class HangmanModel implements Subject{
 
	//max number of guesses that can go wrong before game ends.
    private int             maximumWrongGuesses;
    
    //current number of guesses
    private int             numberOfGuesses;
    
    //number of wrong guesses
    private int             wrongGuesses;
 
    //stores the list of letters which are left to be guessed.
    private List<Character>   unguessedLetters;
 
    private IPhrase          phrase;
 
    private String          currentPhrase;
    private String          hiddenPhrase;
    
    //List of observers.
    private  List<IObserver> observer = new ArrayList<IObserver>(); 
    
    IPhraseFactory phraseFactory_;
 
    public HangmanModel(IPhraseFactory inFactory, String category, String ageCategory) {
    	this.phraseFactory_ = inFactory;
    	this.phrase = phraseFactory_.createPhrase(category);
    	System.out.println("Object returned : " + this.phrase.getClass().getName());
        init(ageCategory);
	}
    
	public void init(String ageCategory) {
        this.numberOfGuesses = 0;
        this.wrongGuesses = 0;
        this.maximumWrongGuesses = HangmanPanel.maximumWrongGuesses;
        this.unguessedLetters = resetLettersGuessed();
        
        getPhraseList(ageCategory);
        
        this.currentPhrase = phrase.getPhrase();
        this.hiddenPhrase = phrase.getHiddenPhrase();
        
    }
	
	private void getPhraseList(String ageCategory) {
		if(ageCategory.equals(HangmanConstants.KIDS_AGE_CATEGORY)){
			Context context = new Context(new KidsStrategy());		
			List<String> phrases = context.executeStrategy(this.phrase);			
			phrase.setPhrases(phrases);
			System.out.println("Phrases retuned : " + phrases);
		} 
		
		else if(ageCategory.equals(HangmanConstants.TEEN_AGE_CATEGORY)){
			Context context = new Context(new TeenStrategy());
			List<String> phrases = context.executeStrategy(this.phrase);
			phrase.setPhrases(phrases);
			System.out.println("Phrases retuned : " + phrases);
		} 
		
		else if(ageCategory.equals(HangmanConstants.ADULT_AGE_CATEGORY)){
			Context context = new Context(new AdultStrategy());
			List<String> phrases = context.executeStrategy(this.phrase);
			phrase.setPhrases(phrases);
			System.out.println("Phrases retuned : " + phrases);
		}
	}

    private List<Character> resetLettersGuessed() {
        List<Character> unguessedLetters = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            Character c = (char) (i + 'A');
            unguessedLetters.add(c);
        }
        return unguessedLetters;
    }
 
    public boolean isPossibleLetter(String letter) {
        String u = letter.toUpperCase();
        Character c = u.charAt(0);
        return unguessedLetters.contains(c);
    }
 
    public void guessLetter(String letter) {
        String l = letter.toLowerCase();
        String u = letter.toUpperCase();
 
        StringBuilder builder = new StringBuilder();
        boolean incorrectGuess = true;
        for (int i = 0; i < currentPhrase.length(); i++) {
            String s = currentPhrase.substring(i, i + 1);
            if (l.equals(s.toLowerCase())) {
                builder.append(s);
                incorrectGuess = false;
            } else {
                builder.append(hiddenPhrase.charAt(i));
            }
        }
 
        numberOfGuesses++;
 
        if (incorrectGuess) {
            wrongGuesses++;
            notifyObserver();
        }
 
        Character c = u.charAt(0);
        unguessedLetters.remove(c);
 
        hiddenPhrase = builder.toString();
    }
 
    public boolean isDead() {
        return wrongGuesses >= maximumWrongGuesses;
    }
 
    public boolean isSolved() {
        boolean isSolved = true;
 
        for (int i = 0; isSolved && i < hiddenPhrase.length(); i++) {
            char c = hiddenPhrase.charAt(i);
            if (c == '_') {
                isSolved = false;
            }
        }
 
        return isSolved;
    }
 
    public String getUnguessedLetters() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unguessedLetters.size(); i++) {
            builder.append(unguessedLetters.get(i));
            if (i < (unguessedLetters.size() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 
    public String getNumberOfGuesses() {
        return Integer.toString(numberOfGuesses);
    }
 
    public List<String> getHiddenPhrase() {
        List<String> lines = new ArrayList<String>();
 
        int size = 12;
        String s = hiddenPhrase;
 
        while (s.length() > size) {
            int pos = 0;
            while (pos >= 0 && pos < size) {
                pos = s.indexOf(" ", pos + 1);
            }
            if (pos >= 0) {
                String t = s.substring(0, pos);
                lines.add(expandHiddenPhrase(t));
                s = s.substring(pos + 1);
            } else {
                break;
            }
        }
 
        lines.add(expandHiddenPhrase(s));
 
        return lines;
    }
 
    private String expandHiddenPhrase(String phrase) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            builder.append(phrase.charAt(i));
            if (i < (phrase.length() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 
    public int getWrongGuesses() {
        return wrongGuesses;
    }
 
    public String getCurrentPhrase() {
        return currentPhrase;
    }

	@Override
	/*It attaches the observer*/
	public void attach(IObserver obj) {
		// TODO Auto-generated method stub
		System.out.println("hello attach observer");

		observer.add(obj);
		
	}

	@Override
	/*Detaches the observer*/
	public void detach(IObserver obj) {
		// TODO Auto-generated method stub
		observer.remove(obj);

	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(IObserver obj : observer){
			System.out.println("hello notify observer");
			obj.update();
		}
		
	}
 
}
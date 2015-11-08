package com.ggl.hangman;
 
import javax.swing.SwingUtilities;
 

import com.ggl.hangman.model.HangmanModel;
import com.ggl.hangman.view.HangmanFrame;
 
public class Hangman implements Runnable {
 
	private String category;
	
	/*public Hangman(String s) {
		category = "Movie";
	}*/
	
    public Hangman(String ctgry) {
		category = ctgry;
	}

	@Override
    public void run() {
        new HangmanFrame(new HangmanModel(this.category));
    }
     
/*    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Hangman());
    }
 */
}
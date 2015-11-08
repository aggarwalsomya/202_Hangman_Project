package com.ggl.hangman.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.ggl.hangman.Hangman;

public class optionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		// don't bind observer with logic. 
		// It should send a command for some event and then controller should define the logic.
//		sendCommand("OPTION_SELECTED", e.getActionCommand());
		
		//create a static factory for the time being
		IPhraseFactory f = new PhraseFactory();

		if(e.getActionCommand().equals("Book")) {
			SwingUtilities.invokeLater(new Hangman("Book", f));
		}else if (e.getActionCommand().equals("Movie")) {
			SwingUtilities.invokeLater(new Hangman("Movie", f));
		}
	}
}

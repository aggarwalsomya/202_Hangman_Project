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
		if(e.getActionCommand().equals("Book")) {
			SwingUtilities.invokeLater(new Hangman("Book"));
		}else if (e.getActionCommand().equals("Movie")) {
			SwingUtilities.invokeLater(new Hangman("Movie"));
		}
		
	}
	
	

}

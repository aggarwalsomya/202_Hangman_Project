package com.ggl.hangman.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.ggl.hangman.Hangman;
import com.ggl.hangman.command.BookClickedCommand;
import com.ggl.hangman.command.ICategoryCommand;
import com.ggl.hangman.command.IMenuInvoker;
import com.ggl.hangman.command.IMenuReceiver;
import com.ggl.hangman.command.MenuCategoryInvoker;
import com.ggl.hangman.command.MovieClickedCommand;
import com.ggl.hangman.view.HangmanFrame;

import javax.swing.JButton;

public class AgeSelection extends JFrame implements Runnable{

	private JPanel contentPane;

	
	@Override
    public void run() {
		new AgeFrame(contentPane);
	}

	/**
	 * Create the frame.
	 * @param phraseCategory 
	 * @param f 
	 */
	public AgeSelection(String phraseCategory, IPhraseFactory f) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton kidsAgeButton = new JButton(HangmanConstants.KIDS_AGE_CATEGORY);
		kidsAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(phraseCategory, f, HangmanConstants.KIDS_AGE_CATEGORY));
				
			}
		});
		kidsAgeButton.setBounds(16, 19, 117, 29);
		contentPane.add(kidsAgeButton);
		
		JButton teenAgeButton = new JButton(HangmanConstants.TEEN_AGE_CATEGORY);
		teenAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(phraseCategory, f, HangmanConstants.TEEN_AGE_CATEGORY));
				
			}
		});
		teenAgeButton.setBounds(16, 68, 117, 29);
		contentPane.add(teenAgeButton);
		
		JButton adultAgeButton = new JButton(HangmanConstants.ADULT_AGE_CATEGORY);
		adultAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(HangmanConstants.MOVIE_CATEGORY, f, HangmanConstants.ADULT_AGE_CATEGORY));
				
			}
		});
		adultAgeButton.setBounds(16, 105, 117, 29);
		contentPane.add(adultAgeButton);
	}

}

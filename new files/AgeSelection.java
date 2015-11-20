package com.ggl.hangman.strategy;

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
import com.ggl.hangman.model.HangmanConstants;
import com.ggl.hangman.model.IPhraseFactory;
import com.ggl.hangman.view.HangmanFrame;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

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
		setBounds(100, 100, 708, 454);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton kidsAgeButton = new JButton(HangmanConstants.KIDS_AGE_CATEGORY);
		kidsAgeButton.setBackground(Color.ORANGE);
		kidsAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(phraseCategory, f, HangmanConstants.KIDS_AGE_CATEGORY));
				
			}
		});
		kidsAgeButton.setBounds(88, 19, 117, 29);
		contentPane.add(kidsAgeButton);
		
		JButton teenAgeButton = new JButton(HangmanConstants.TEEN_AGE_CATEGORY);
		teenAgeButton.setBackground(Color.ORANGE);
		teenAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(phraseCategory, f, HangmanConstants.TEEN_AGE_CATEGORY));
				
			}
		});
		teenAgeButton.setBounds(237, 19, 117, 29);
		contentPane.add(teenAgeButton);
		
		JButton adultAgeButton = new JButton(HangmanConstants.ADULT_AGE_CATEGORY);
		adultAgeButton.setBackground(Color.ORANGE);
		adultAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(HangmanConstants.MOVIE_CATEGORY, f, HangmanConstants.ADULT_AGE_CATEGORY));
				
			}
		});
		adultAgeButton.setBounds(400, 19, 117, 29);
		contentPane.add(adultAgeButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\love\\workspace\\202_Hangman_Project\\src\\Images\\AgeSelection.jpg"));
		lblNewLabel.setBounds(10, 146, 682, 324);
		contentPane.add(lblNewLabel);
		
		JLabel lblPickYourAge = new JLabel("PICK YOUR AGE CATEGORY");
		lblPickYourAge.setForeground(Color.WHITE);
		lblPickYourAge.setBackground(Color.ORANGE);
		lblPickYourAge.setBounds(257, 79, 178, 29);
		contentPane.add(lblPickYourAge);
	}
}

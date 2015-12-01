package com.ggl.hangman.strategy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import com.ggl.hangman.common.Hangman;
import com.ggl.hangman.common.HangmanConstants;
import com.ggl.hangman.factory.IPhraseFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
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
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 365);
		setSize(new Dimension(714, 496));

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
		kidsAgeButton.setBounds(115, 172, 117, 29);
		contentPane.add(kidsAgeButton);
		
		JButton teenAgeButton = new JButton(HangmanConstants.TEEN_AGE_CATEGORY);
		teenAgeButton.setBackground(Color.ORANGE);
		teenAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(phraseCategory, f, HangmanConstants.TEEN_AGE_CATEGORY));
				
			}
		});
		teenAgeButton.setBounds(115, 212, 117, 29);
		contentPane.add(teenAgeButton);
		
		JButton adultAgeButton = new JButton(HangmanConstants.ADULT_AGE_CATEGORY);
		adultAgeButton.setBackground(Color.ORANGE);
		adultAgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Hangman(HangmanConstants.MOVIE_CATEGORY, f, HangmanConstants.ADULT_AGE_CATEGORY));
				
			}
		});
		adultAgeButton.setBounds(115, 252, 117, 29);
		contentPane.add(adultAgeButton);
		
		
		JLabel lblPickYourAge = new JLabel("PICK YOUR AGE CATEGORY");
		lblPickYourAge.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPickYourAge.setForeground(Color.WHITE);
		lblPickYourAge.setBackground(Color.ORANGE);
		lblPickYourAge.setBounds(103, 34, 324, 29);
		contentPane.add(lblPickYourAge);
		
		String dir2 = null;
		dir2=System.getProperty("user.dir");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(dir2+"\\src\\Images\\AgeSelection (2).jpg"));
		lblNewLabel.setBounds(0, -129, 724, 930);
		contentPane.add(lblNewLabel);
	}
}

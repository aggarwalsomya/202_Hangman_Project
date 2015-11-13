package com.ggl.hangman.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import com.ggl.hangman.strategy.AgeSelection;

import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private optionListener listen;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Somya--Start
		//Creating the factory object here.
		//Future extension: Can apply a strategy to choose a factory too.
		IPhraseFactory f = new PhraseFactory();

		//Creating the object of the Command and setting its receiver to do the option.
		ICategoryCommand bookClicked = new BookClickedCommand();
		bookClicked.setReceiver(new IMenuReceiver() {
			
			@Override
			public void doAction() {
				SwingUtilities.invokeLater(new AgeSelection(HangmanConstants.BOOK_CATEGORY,f));
				//SwingUtilities.invokeLater(new Hangman(HangmanConstants.BOOK_CATEGORY, f, ""));		
			}
		});
		
		ICategoryCommand movieClicked = new MovieClickedCommand();
		movieClicked.setReceiver(new IMenuReceiver() {
			
			@Override
			public void doAction() {
				SwingUtilities.invokeLater(new AgeSelection(HangmanConstants.MOVIE_CATEGORY,f));
				//SwingUtilities.invokeLater(new Hangman(MOVIE_CATEGORY, f));	
			}
		});
		
		IMenuInvoker menuInvoker_ = new MenuCategoryInvoker();
		menuInvoker_.setCommand(HangmanConstants.BOOK_CATEGORY, bookClicked);
		menuInvoker_.setCommand(HangmanConstants.MOVIE_CATEGORY, movieClicked);
		//Somya--end
		
		
		listen = new optionListener(menuInvoker_);
		JButton bookButton = new JButton(HangmanConstants.BOOK_CATEGORY);
		bookButton.addActionListener(listen);
		bookButton.setBounds(16, 19, 117, 29);
		contentPane.add(bookButton);
		
		JButton movieButton = new JButton(HangmanConstants.MOVIE_CATEGORY);
		movieButton.addActionListener(listen);
		movieButton.setBounds(16, 68, 117, 29);
		contentPane.add(movieButton);
	}

}

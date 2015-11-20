package com.ggl.hangman.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.ImageIcon;

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
		setBounds(80, 100, 50, 300);
		setSize(new Dimension(1000,800));
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
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
		bookButton.setBackground(Color.ORANGE);
		bookButton.addActionListener(listen);
		bookButton.setBounds(404, 77, 221, 29);
		contentPane.add(bookButton);
		
		JButton movieButton = new JButton(HangmanConstants.MOVIE_CATEGORY);
		movieButton.setBackground(Color.ORANGE);
		movieButton.addActionListener(listen);
		movieButton.setBounds(404, 139, 221, 29);
		contentPane.add(movieButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to hangman");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(452, 11, 183, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\love\\workspace\\202_Hangman_Project\\src\\Images\\Hangman2.jpg"));
		lblNewLabel_1.setBounds(0, 179, 561, 269);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblChooseTheFollowing = new JLabel("Choose The following Category");
		lblChooseTheFollowing.setForeground(Color.WHITE);
		lblChooseTheFollowing.setBackground(Color.WHITE);
		lblChooseTheFollowing.setBounds(419, 44, 183, 29);
		contentPane.add(lblChooseTheFollowing);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\love\\workspace\\202_Hangman_Project\\src\\Images\\fun.jpg"));
		lblNewLabel_3.setBounds(30, 437, 499, 304);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\love\\workspace\\202_Hangman_Project\\src\\Images\\funny-kid.jpg"));
		lblNewLabel_4.setBounds(513, 179, 488, 536);
		contentPane.add(lblNewLabel_4);
	}

}

package com.ggl.hangman.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.ggl.hangman.command.BookClickedCommand;
import com.ggl.hangman.command.ICategoryCommand;
import com.ggl.hangman.command.IMenuInvoker;
import com.ggl.hangman.command.IMenuReceiver;
import com.ggl.hangman.command.MenuCategoryInvoker;
import com.ggl.hangman.command.MovieClickedCommand;
import com.ggl.hangman.factory.IPhraseFactory;
import com.ggl.hangman.factory.PhraseFactory;
import com.ggl.hangman.observer.OptionListener;
import com.ggl.hangman.strategy.AgeSelection;

import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;
	private OptionListener listen;
	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 365);
		setSize(new Dimension(600,400));
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
			}
		});
		
		ICategoryCommand movieClicked = new MovieClickedCommand();
		movieClicked.setReceiver(new IMenuReceiver() {
			
			@Override
			public void doAction() {
				SwingUtilities.invokeLater(new AgeSelection(HangmanConstants.MOVIE_CATEGORY,f));
			}
		});
		
		IMenuInvoker menuInvoker_ = new MenuCategoryInvoker();
		menuInvoker_.setCommand(HangmanConstants.BOOK_CATEGORY, bookClicked);
		menuInvoker_.setCommand(HangmanConstants.MOVIE_CATEGORY, movieClicked);
		//Somya--end
		
		
		listen = new OptionListener(menuInvoker_);
		JButton bookButton = new JButton(HangmanConstants.BOOK_CATEGORY);
		bookButton.setBackground(Color.ORANGE);
		bookButton.addActionListener(listen);
		bookButton.setBounds(51, 98, 221, 29);
		contentPane.add(bookButton);
		
		JButton movieButton = new JButton(HangmanConstants.MOVIE_CATEGORY);
		movieButton.setBackground(Color.ORANGE);
		movieButton.addActionListener(listen);
		movieButton.setBounds(51, 154, 221, 29);
		contentPane.add(movieButton);
		
		JLabel lblNewLabel = new JLabel("Welcome to hangman");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(41, 11, 358, 22);
		contentPane.add(lblNewLabel);
		
		String dir = null;
		dir=System.getProperty("user.dir");
		
		JLabel lblChooseTheFollowing = new JLabel("Choose The following Category");
		lblChooseTheFollowing.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblChooseTheFollowing.setForeground(Color.WHITE);
		lblChooseTheFollowing.setBackground(Color.WHITE);
		lblChooseTheFollowing.setBounds(10, 44, 371, 29);
		contentPane.add(lblChooseTheFollowing);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(dir+"\\src\\Images\\starts.jpg"));
		lblNewLabel_1.setBounds(0, 11, 371, 339);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(dir+"\\src\\Images\\hangman.gif"));
		lblNewLabel_2.setBounds(467, 263, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(dir+"\\src\\Images\\\\hangman.gif"));
		lblNewLabel_3.setBounds(381, 0, 193, 350);
		contentPane.add(lblNewLabel_3);
	}
}

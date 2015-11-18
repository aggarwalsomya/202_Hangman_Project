package com.ggl.hangman.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.UUID;

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


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GenerateCaptcha extends JFrame implements ICaptchaGen, ActionListener{
	
	private JPanel contentPane;
	public JLabel gamename = new JLabel("HANGMAN..");
	public JLabel tagline = new JLabel("Save the World!");
	private optionListener listen;
	public StringBuffer captchaStringBuffer = new StringBuffer();
	public StringBuilder captchaString = new StringBuilder(7);
	public String captcha = "Generate Captcha";
	JTextField captchaText = new JTextField(10);
	//JButton captchaButton=new JButton(captcha);
	JTextField inputCaptcha = new JTextField(10);
	JButton authenticateButton=new JButton("I am a human!");
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZaeioupvnhgdsbxztrk";
	static Random rnd = new Random();
	

	@Override
	public String generate() {
		// TODO Auto-generated method stub
		
		for( int i = 0; i < 7; i++ ) 
		      captchaString.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return captchaString.toString();
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateCaptcha frame = new GenerateCaptcha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GenerateCaptcha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Hangman");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font font = new Font("SansSerif", Font.BOLD, 15);
		Font font2=new Font("SansSerif",Font.BOLD,12);
		gamename.setFont(font);
		gamename.setBounds(165, 25, 180, 25);
		tagline.setFont(font2);
		tagline.setBounds(220, 42, 180, 25);
		
		contentPane.add(captchaText);
		
		this.add(gamename);
		this.add(tagline);
		
		captchaText.setText(generate());
		contentPane.add(inputCaptcha);
		contentPane.add(authenticateButton);
		captchaText.setBounds(170,85,70,25);
		authenticateButton.setBounds(135, 170, 140, 25);
		inputCaptcha.setBounds(170,125,70,25);
		
		authenticateButton.addActionListener(this);
		

	}
	
	public void actionPerformed(ActionEvent e)
	
	{
		
			authenticate();
	
	}
	

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void authenticate() {
		// TODO Auto-generated method stub
		
		
		String str=inputCaptcha.getText();
		if(str.compareTo(captchaText.getText())==0)
		{
			Menu m = new Menu();
			m.setVisible(true);
		}
		}
	}

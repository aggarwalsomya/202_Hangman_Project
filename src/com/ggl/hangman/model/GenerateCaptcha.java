package com.ggl.hangman.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.UUID;

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


import javax.swing.JButton;
import javax.swing.JTextField;

public class GenerateCaptcha extends JFrame implements ICaptchaGen, ActionListener{
	
	private JPanel contentPane;
	private optionListener listen;
	public StringBuffer captchaStringBuffer = new StringBuffer();
	public StringBuilder captchaString = new StringBuilder(7);
	public String captcha = "Generate Captcha";
	JTextField captchaText = new JTextField(10);
	JButton captchaButton=new JButton(captcha);
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
		
		
		//ICategoryCommand generateCaptchaClicked = new generateCaptchaCommand();
		
		
		//IMenuInvoker menuInvoker_ = new MenuCategoryInvoker();
		//menuInvoker_.setCommand(captcha, cmd);
		
		//captchaButton.addActionListener(listen);
		//captchaButton.setBounds(25,60,110,30);
		
		contentPane.add(captchaButton);
		captchaButton.setBounds(135,45,140,25);
		contentPane.add(captchaText);
		contentPane.add(inputCaptcha);
		contentPane.add(authenticateButton);
		captchaText.setBounds(170,85,70,25);
		authenticateButton.setBounds(135, 170, 140, 25);
		inputCaptcha.setBounds(170,125,70,25);
		
		authenticateButton.setActionCommand("2");
		captchaButton.setActionCommand("1");
		authenticateButton.addActionListener(this);
		captchaButton.addActionListener(this);
		
		

	}
	
	public void actionPerformed(ActionEvent e)
	{
		int action = Integer.parseInt(e.getActionCommand());
		switch(action)
		{
		case 1:
		String captchaString = generate();
		captchaText.setText(captchaString);
		captchaText.setEditable(false);
		break;
		case 2:
			authenticate();
		default:
			break;
		}
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
	
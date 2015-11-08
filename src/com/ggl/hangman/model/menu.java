package com.ggl.hangman.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class menu extends JFrame {

	private JPanel contentPane;
	private optionListener listen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listen = new optionListener();
		JButton bookButton = new JButton("Book");
		bookButton.addActionListener(listen);
		bookButton.setBounds(16, 19, 117, 29);
		contentPane.add(bookButton);
		
		JButton movieButton = new JButton("Movie");
		movieButton.addActionListener(listen);
		movieButton.setBounds(16, 68, 117, 29);
		contentPane.add(movieButton);
	}

}

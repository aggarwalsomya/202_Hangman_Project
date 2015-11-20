package com.ggl.hangman.common;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionChoice extends JFrame {

	private JPanel contentPane;
	private ActionListener newListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionChoice frame = new SelectionChoice();
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
	public SelectionChoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BookButton = new JButton("Book");
		BookButton.addActionListener(newListener);
		BookButton.setBounds(10, 23, 89, 23);
		contentPane.add(BookButton);
		
		JButton movieButton = new JButton("Movie");
		movieButton.addActionListener(newListener); 
		movieButton.setBounds(10, 65, 89, 23);
		contentPane.add(movieButton);
	//	newListener.actionPerformed(ActionEvent e) {
		//	
	//	};
	}
}

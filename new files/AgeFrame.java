package com.ggl.hangman.strategy;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
 

import com.ggl.hangman.model.HangmanModel;
import java.awt.Color;
 
public class AgeFrame {
 
    public AgeFrame(JPanel contentPane) {
    	JFrame frame = new JFrame();
    	frame.getContentPane().setBackground(Color.BLACK);
    	
        frame.setSize(700, 600);
        frame.getContentPane().add(contentPane);
		frame.setVisible(true);
    }
 
	
}
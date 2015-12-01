package com.ggl.hangman.strategy;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
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
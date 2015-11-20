package com.ggl.hangman.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.ggl.hangman.command.IMenuInvoker;

public class OptionListener implements ActionListener {

	IMenuInvoker menuInvoker_;
	public OptionListener(IMenuInvoker menuInvoker) {
		this.menuInvoker_ = menuInvoker;
	}
	
	//Here option listener is decoupled from the end observers which will do the action
	//end observers will be the part of the command pattern.
	//They are book and Movie in our case.
	//Option listener simply calls the invoker to do the next action.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		menuInvoker_.invoke(e.getActionCommand());
	}
}

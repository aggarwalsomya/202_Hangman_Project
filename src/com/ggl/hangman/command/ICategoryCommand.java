package com.ggl.hangman.command;

public interface ICategoryCommand {
	public void execute();
	public void setReceiver(IMenuReceiver rcv);
}

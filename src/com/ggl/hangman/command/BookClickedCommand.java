package com.ggl.hangman.command;

public class BookClickedCommand implements ICategoryCommand  {
	
	IMenuReceiver receiver_ = null;

	@Override
	public void execute() {
		if (receiver_ != null) {
			receiver_.doAction();
		}
	}

	@Override
	public void setReceiver(IMenuReceiver rcv) {
		this.receiver_ = rcv;
	}
}

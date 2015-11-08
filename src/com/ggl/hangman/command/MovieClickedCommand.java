package com.ggl.hangman.command;

public class MovieClickedCommand implements ICategoryCommand  {

	IMenuReceiver menuRec_ = null;
	@Override
	public void execute() {
		if(menuRec_ != null) {
			menuRec_.doAction();
		}
	}

	@Override
	public void setReceiver(IMenuReceiver rcv) {
		this.menuRec_ = rcv;
	}

}

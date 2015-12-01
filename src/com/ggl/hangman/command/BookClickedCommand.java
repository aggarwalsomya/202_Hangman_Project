package com.ggl.hangman.command;

/*This command will be invoked when the user chooses the Book Category from the Menu Panel*/
public class BookClickedCommand implements ICategoryCommand  {
	
	IMenuReceiver receiver_ = null;

	/*When the execute method is called for then the receiver's action is called*/
	@Override
	public void execute() {
		if (receiver_ != null) {
			receiver_.doAction();
		}
	}

	@Override
	/*This method set the receivers for this command.*/
	public void setReceiver(IMenuReceiver rcv) {
		this.receiver_ = rcv;
	}
}

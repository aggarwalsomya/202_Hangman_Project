package com.ggl.hangman.command;

/*This command will be invoked when the user chooses the Movie Category from the Menu Panel*/
public class MovieClickedCommand implements ICategoryCommand  {

	IMenuReceiver menuRec_ = null;
	
	/*When the execute method is called for then the receiver's action is called*/
	@Override
	public void execute() {
		if(menuRec_ != null) {
			menuRec_.doAction();
		}
	}

	/*This method set the receivers for this command.*/
	@Override
	public void setReceiver(IMenuReceiver rcv) {
		this.menuRec_ = rcv;
	}

}

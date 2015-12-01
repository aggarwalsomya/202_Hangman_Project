/*Interface for the Menu Receiver*/
package com.ggl.hangman.command;

public interface IMenuReceiver {
	/*If this receiver is associated with a command which is invoked, then this method is executed for the receiver*/
	public void doAction();
}

/*Interface for the Menu (Invoker of the command design pattern)*/
package com.ggl.hangman.command;

public interface IMenuInvoker {
	void invoke(String categoryName);
	void setCommand(String categoryName, ICategoryCommand cmd);

}

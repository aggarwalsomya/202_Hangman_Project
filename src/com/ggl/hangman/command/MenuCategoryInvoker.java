package com.ggl.hangman.command;

import java.util.HashMap;
import java.util.Map;

public class MenuCategoryInvoker implements IMenuInvoker{

	/*This map will store the mapping of the category name to its command.*/
	Map<String, ICategoryCommand> nameToCommandMap = new HashMap<>();
	@Override
	/*If the category exists then it invokes the command mapped to it*/
	public void invoke(String categoryName) {
		if(nameToCommandMap.containsKey(categoryName)){
			ICategoryCommand obj = nameToCommandMap.get(categoryName);
			obj.execute();
		}
	}

	@Override
	public void setCommand(String categoryName, ICategoryCommand cmd) {
		nameToCommandMap.put(categoryName, cmd);
	}

}

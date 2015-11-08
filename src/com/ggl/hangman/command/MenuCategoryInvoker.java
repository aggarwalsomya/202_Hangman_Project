package com.ggl.hangman.command;

import java.util.HashMap;
import java.util.Map;

public class MenuCategoryInvoker implements IMenuInvoker{

	Map<String, ICategoryCommand> nameToCommandMap = new HashMap<>();
	@Override
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

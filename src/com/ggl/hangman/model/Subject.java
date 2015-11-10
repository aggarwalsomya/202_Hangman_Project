package com.ggl.hangman.model;

import com.ggl.hangman.view.Observer;

public interface Subject {
	//hangman model is implementing Subject interface
public void attach(Observer obj );
public void detach(Observer obj);
public void notifyObserver();

}

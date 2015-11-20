package com.ggl.hangman.model;

import com.ggl.hangman.view.IObserver;

public interface Subject {
	//hangman model is implementing Subject interface
public void attach(IObserver obj );
public void detach(IObserver obj);
public void notifyObserver();

}

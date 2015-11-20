package com.ggl.hangman.common;

import com.ggl.hangman.observer.IObserver;

public interface Subject {
	//hangman model is implementing Subject interface
public void attach(IObserver obj );
public void detach(IObserver obj);
public void notifyObserver();

}

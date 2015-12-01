package com.ggl.hangman.common;

import com.ggl.hangman.observer.IObserver;

public interface Subject {

//hangman model is implementing Subject interface
//Part of observer pattern where the observers can be attached/ detached and notified.
public void attach(IObserver obj );
public void detach(IObserver obj);
public void notifyObserver();

}

/*Interface class for abstract factory class*/
package com.ggl.hangman.factory;

public interface IPhraseFactory {
	public IPhrase createPhrase(String category);
}

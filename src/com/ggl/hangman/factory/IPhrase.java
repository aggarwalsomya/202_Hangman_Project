package com.ggl.hangman.factory;

import java.util.List;

public interface IPhrase {
	    public String getPhrase() ;
	    public String getHiddenPhrase();
	    public void setPhrases(List<String> phrases);
}

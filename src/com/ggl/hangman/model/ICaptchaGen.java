package com.ggl.hangman.model;

public interface ICaptchaGen
{
	public String generate();
	public void display();
	public void authenticate();
}
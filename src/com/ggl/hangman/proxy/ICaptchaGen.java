package com.ggl.hangman.proxy;

public interface ICaptchaGen
{
	public String generate();
	public void display();
	public void authenticate();
}
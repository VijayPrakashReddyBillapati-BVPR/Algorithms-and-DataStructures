package com.datastructures.exception;

public class MyStackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String s;
	public MyStackException(String s) {
		this.s= s;
	}

	@Override
	public String toString() {
		return "MyStackException "+s;
	}
	

}

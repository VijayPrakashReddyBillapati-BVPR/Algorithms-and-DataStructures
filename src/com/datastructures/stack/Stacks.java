package com.datastructures.stack;

public interface Stacks<T> {
	static final int MAXCAPACITY = 5;
	public boolean push(T value);
	public T pop();
	public int size();
	public T peek();
	public boolean isEmpty();
	public boolean isFull();

}

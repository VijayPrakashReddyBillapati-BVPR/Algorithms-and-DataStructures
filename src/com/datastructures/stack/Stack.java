package com.datastructures.stack;

public class Stack<T> implements Stacks<T> {

	public static int CAPACITY = MAXCAPACITY;
	public static int TOP = -1;
	T[] stack;

	@SuppressWarnings("unchecked")
	public Stack() {
		stack = (T[]) new Object[MAXCAPACITY];
	}

	@Override
	public boolean push(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value can't be null");
		}
		if(TOP >= CAPACITY*3/4)
		{
			reSize(CAPACITY*2);
		}

		stack[++TOP] = value;

		return true;
	}

	@Override
	public T pop() {
		if (TOP == -1) {
			System.out.println("can't remove from empty stack");
		}

		T value = stack[TOP];
		stack[TOP--] = null;

		if (CAPACITY / 4 > TOP) {
			reSize(CAPACITY / 2);
		}

		return value;
	}

	@SuppressWarnings("unchecked")
	private void reSize(int size) {
		CAPACITY = size;
		T[] helper = stack;
		stack = (T[]) new Object[size];
		for(int i=0;i<=TOP;i++)
		{
			stack[i] = helper[i];
		}
		helper = null;

	}

	@Override
	public int size() {

		return TOP;
	}

	@Override
	public T peek() {

		return stack[TOP];
	}

	@Override
	public boolean isEmpty() {

		return TOP < 0;
	}

	@Override
	public boolean isFull() {

		return TOP == CAPACITY;
	}

}

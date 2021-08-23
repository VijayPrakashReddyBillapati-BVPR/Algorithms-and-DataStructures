package com.datastructures.queue;

public interface Queues<T> {
	public static final int MAX = 5;
	
	public T enqueue(T key);
	public T dequeue();
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	public T peek();
	public String printQueue();

}

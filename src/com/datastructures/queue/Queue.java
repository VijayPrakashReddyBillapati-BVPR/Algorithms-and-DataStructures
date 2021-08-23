package com.datastructures.queue;

public class Queue<T> implements Queues<T> {
	public static int LAST;
	public static int FIRST;
	public static int INDEX;
	public static int SIZE=MAX;
	T[] queue;
	
	
	
	@SuppressWarnings("unchecked")
	public Queue() {
		queue = (T[]) new Object[SIZE];
		LAST=0; FIRST=0; INDEX = 0;
	}
	
	
	
	@Override
	public T enqueue(T key) {
		
		if (key == null)
			throw new NullPointerException("key must not be null");
        if(FIRST >= SIZE*3/4 )
        	reSize(SIZE*2);
		
		queue[FIRST++] = key;
		INDEX++;
		return key;
	}
	
	@Override
	public T dequeue() {
		if (INDEX == 0)
			throw new NullPointerException("empty queue");
		
		T last = queue[LAST];
		queue[LAST++] = null;
		INDEX--;
		if(INDEX< SIZE/4 && SIZE>MAX)
			reSize(SIZE/2);
		
		
		return last;
	}
	
	
	@SuppressWarnings("unchecked")
	private void reSize(int newSize) {

		T[] helper = (T[]) new Object[newSize];
		int pointer=0;
		for(int i=LAST; i< FIRST;i++)
		{
				helper[pointer]=queue[i];
				pointer++;
		}
		
		queue = helper;
		SIZE = queue.length;
		LAST=0;
		FIRST=pointer;
		INDEX=pointer;
		helper=null;
		
		
	}
	
//	private void reOrder() {
//		
//		@SuppressWarnings("unchecked")
//		T[] helper = (T[]) new Object[SIZE];
//		int pointer=0;
//		for(int i=LAST; i< FIRST;i++)
//		{
//				helper[pointer]=queue[i];
//				pointer++;
//		}
//		queue = helper;
//		LAST=0;
//		FIRST=pointer;
//		INDEX=pointer-1;
//		helper=null;
//		
//		
//	}
	
	@Override
	public int size() {
		
		return SIZE;
	}
	
	
	@Override
	public boolean isFull() {
		
		return INDEX==SIZE;
	}
	
	
	@Override
	public boolean isEmpty() {
		
		return INDEX==0;
	}
	
	
	@Override
	public T peek() {

		return queue[LAST];
	}
	
	
	@Override
	public String printQueue() {
		System.out.println("last "+LAST+" first "+FIRST+" Index "+INDEX);
		String print = "";
		for(int i=0; i<queue.length;i++)
		{
			print = print+" -> "+queue[i];
		}
		return print;
	}	
}

package com.datastructures.queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queues<Integer> queue = new Queue<Integer>();

		for(int i=0; i<10;i++)
		{
			queue.enqueue(i*2);
		}
		
		System.out.println(" before DEQUEUE"+queue.peek());
		System.out.println(" before DEQUEUE"+queue.size());
		
		for(int i=0; i<10;i++)
		{
			queue.dequeue();
		}
		
		System.out.println(queue.printQueue() );
		System.out.println(queue.peek());
		System.out.println(queue.size());
	}

}

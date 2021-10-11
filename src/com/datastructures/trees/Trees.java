package com.datastructures.trees;

public interface Trees<Key , Value> {
	public void insert(Key key, Value value);
	public void delete(Key key);
	public boolean search(Key key);
	public int height();

	public void inorder();
	public void postorder();
	public void preorder();
	
	public Value max();
	public Value min();
	public Value kthLargest(int largest);
	public Value kthSmallest(int smallest);

}

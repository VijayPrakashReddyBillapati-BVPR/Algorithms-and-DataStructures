package com.datastructures.trees;

public interface Tree {
	
	public void insert(Integer key);
	public void delete(Integer key);
	public boolean search(Integer key);

	public void inorder();
	public void postorder();
	public void preorder();
}

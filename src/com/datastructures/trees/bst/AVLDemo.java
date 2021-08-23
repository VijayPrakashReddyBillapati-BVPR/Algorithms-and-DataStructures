package com.datastructures.trees.bst;

import com.datastructures.trees.Trees;

public class AVLDemo {

	public static void main(String[] args) {
		Trees<Integer,Integer> tree = new AVLTree<Integer,Integer>();
		tree.insert(10, 10);
		tree.insert(20, 20);
		tree.insert(30, 30);
		tree.insert(40, 40);
		tree.insert(50, 50);
		tree.insert(25, 25);
		
		tree.preorder();
		
		System.out.println(tree.search(20));
		System.out.println(tree.max());
		System.out.println(tree.min());
		
		System.out.println(tree.kthLargest(3));
		System.out.println(tree.kthSmallest(3));
		
		tree.delete(25);
		
		
		tree.preorder();

	}

}

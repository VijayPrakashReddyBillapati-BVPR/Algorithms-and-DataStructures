package com.datastructures.trees.bst;

import com.datastructures.trees.Tree;
import com.datastructures.trees.Trees;

@SuppressWarnings("unused")
public class BSTDemo {

	public static void main(String[] args) {
		
//		Tree bst = new BinarySearchTree();
		
		
		Trees<Integer, Integer> bst = new RedBlackBST<Integer, Integer>();
		bst.insert(45, 45);
		bst.insert(10, 10);
		bst.insert(7, 7);
		bst.insert(12, 12);
		bst.insert(90, 90);
		bst.insert(50, 50);
		System.out.println("Height: "+bst.height());
		System.out.println("MIN: "+bst.min());
		System.out.println("MAX: "+bst.max());
		System.out.println("kth MAX: "+bst.kthLargest(2) );
		System.out.println("kth MIN: "+bst.kthSmallest(2));
		
		

		// insert data into BST
//		bst.insert(45);
//		bst.insert(10);
//		bst.insert(7);
//		bst.insert(12);
//		bst.insert(90);
//		bst.insert(50);

		// print the BST
		System.out.println("The BST Created with input data(Left-root-right):");
		bst.inorder();

		// delete leaf node
		System.out.println("\nThe BST after Delete 12(leaf node):");
		bst.delete(12);
		bst.inorder();
		// delete the node with one child
		System.out.println("\nThe BST after Delete 90 (node with 1 child):");
		bst.delete(90);
		bst.inorder();

		// delete node with two children
		System.out.println("\nThe BST after Delete 45 (Node with two children):");
		bst.delete(45);
		bst.inorder();
		// search a key in the BST
		boolean ret_val = bst.search(50);
		System.out.println("\nKey 50 found in BST:" + ret_val);
		ret_val = bst.search(12);
		System.out.println("\nKey 12 found in BST:" + ret_val);

	}

}

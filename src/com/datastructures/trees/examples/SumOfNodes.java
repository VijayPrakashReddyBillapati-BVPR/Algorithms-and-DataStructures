package com.datastructures.trees.examples;


//  In a binary tree change each node's value(except leaf node) as the sum of left and right subtree's value.
public class SumOfNodes {

	Node root;
	 static int sum=0;

	public SumOfNodes() {
		this.root = null;
	}

	public void insert(Integer key) {
		if (key == null)
			throw new IllegalArgumentException("key can't be empty or null");
		root = insert(key, root);
	}

	private Node insert(Integer key, Node root) {

		if (root == null) {
//			System.out.println(key+" inserted");
			root = new Node(key);
			return root;
		}

		if (root.key < key) {
			root.right = insert(key, root.right);
		} else if (root.key > key) {
			root.left = insert(key, root.left);
		}
		return root;
	}
	
	public void inorder() {
		inorder(root);

	}

	private void inorder(Node root2) {

		if (root2 != null) {
			inorder(root2.left);
			System.out.println(root2.key + " ");
			inorder(root2.right);
		}

	}
	
	
	public int sumOfChildNodes()
	{
		return sumOfChildNodes(root);
	}

	private int sumOfChildNodes(Node node) {
		if(node == null)
			return 0;
		
		int temp = node.key;
		int sum = sumOfChildNodes(node.left) + sumOfChildNodes(node.right);
		
		if(node.right!=null || node.left!=null)
		{
			node.key = sum;
		}
		return sum+temp;
	}
	
	public int sumOfLeafNodes()
	{
		return sumOfLeafNodes(root);
	}

	private int sumOfLeafNodes(Node node) {
		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null)
			sum+= node.key;
		
		sumOfLeafNodes(node.left);
		sumOfLeafNodes(node.right);
		
		return sum;
	}

	public static void main(String[] args) {

		SumOfNodes bst =  new SumOfNodes();

		bst.insert(45);
		bst.insert(10);
		bst.insert(7);
		bst.insert(12);
		bst.insert(50);
		bst.insert(49);
		bst.insert(90);
		bst.inorder();
		bst.sumOfChildNodes();
		System.out.println("\n");
		bst.inorder();
		
		
		System.out.println("sumOfLeafNodes "+bst.sumOfLeafNodes());

	}

	
	
	class Node {
		Integer key;
		Node left;
		Node right;

		public Node(Integer key) {
			super();
			this.key = key;
			left = null;
			right = null;
		}
	}

}

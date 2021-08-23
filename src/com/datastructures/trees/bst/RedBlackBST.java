package com.datastructures.trees.bst;

import com.datastructures.stack.Stack;
import com.datastructures.stack.Stacks;
import com.datastructures.trees.Trees;

public class RedBlackBST<Key extends Comparable<? super Key>, Value> implements Trees<Key, Value> {

	Node root = null;
	public static final boolean RED = true;
	public static final boolean BLACK = false;

	public RedBlackBST() {
		this.root = null;
	}

	@Override
	public void insert(Key key, Value value) {
		root = insert(key, value, root);

	}

	private Node insert(Key key, Value value, Node root) {
		if (key == null)
			throw new IllegalArgumentException("key can't be empty or null");

		if (root == null) {
			root = new Node(key, value, RED);
			return root;
		}
		int comp = root.key.compareTo(key);
		if (comp < 0)
			root.right = insert(key, value, root.right);
		else if (comp > 0)
			root.left = insert(key, value, root.left);
		else if (comp == 0)
			root.value = value;

		if (root.right != null && root.left != null) {
			if (isRed(root.right) && isRed(root.left))
				flipColor(root);
			if (isRed(root.right) && !isRed(root.left))
				root = rotateLeft(root);
			if (isRed(root.left) && isRed(root.left.left))
				root = rotateRight(root);
		}

		return root;
	}

	private Node rotateRight(Node node) {
		Node shift = node.left;
		root.left = shift.right;
		shift.left = root;
		shift.color = root.color;
		root.color = RED;
		return shift;

	}

	private Node rotateLeft(Node node) {
		Node shift = node.right;
		root.right = shift.left;
		shift.left = root;
		shift.color = root.color;
		root.color = RED;

		return shift;
	}

	private void flipColor(Node root2) {
		root2.color = RED;
		root2.right.color = BLACK;
		root2.left.color = BLACK;

	}

	private boolean isRed(Node node) {

		return node.color == RED;
	}

	@Override
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("key can't be empty or null");
		root = delete(key, root);

	}

	private Node delete(Key key, Node root2) {
		
		if(root2==null)
		{
			return root2;
		}

		int comp = root2.key.compareTo(key);

		if (comp < 0) {
			root2.right = delete(key, root2.right);
		} else if (comp > 0) {
			root2.left = delete(key, root2.left);
		} else {
			if (root2.left == null)
				return root2.right;
			if (root2.right == null)
				return root2.left;

			root2.key = minValue(root2.right);
			root2.right = delete(root2.key, root2.right);
		}
		return root2;
	}

	private Key minValue(Node node) {
		if (node.left != null)
			return minValue(node.left);
		return node.key;
	}

	@Override
	public boolean search(Key key) {
		if (key == null)
			throw new IllegalArgumentException("key can't be empty or null");
		Node node = null;
		node = search(key, root);
		if (node == null)
			return false;
		return true;
	}

	private Node search(Key key, Node node) {
		if (node == null || root.key == key)
			return node;
		if (root.key.compareTo(key) < 0)
			return node.right = search(key, node.right);
		return node.left = search(key, node.left);
	}

	@Override
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

	@Override
	public void postorder() {
		postorder(root);

	}

	private void postorder(Node root2) {

		if (root2 != null) {
			inorder(root2.left);
			inorder(root2.right);
			System.out.println(root2.key + " ");
		}

	}

	@Override
	public void preorder() {
		preorder(root);

	}

	private void preorder(Node root2) {

		if (root2 != null) {
			System.out.println(root2.key + " ");
			inorder(root2.left);
			inorder(root2.right);
		}
	}

	class Node {
		Key key;
		Value value;
		boolean color;
		Node right, left;

		public Node(Key key, Value value, boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;
			right = null;
			left = null;
		}
	}

	@Override
	public int height() {

		return height(root);
	}

	private int height(Node root2) {

		if (root2 == null)
			return -1;
		else {
			int lDepth = height(root2.left);
			int rDepth = height(root2.right);
			int depth = Math.max(rDepth, lDepth) + 1;
			return depth;
		}
	}

	@Override
	public Value max() {
		if (root == null)
			throw new IllegalArgumentException("tree must have atleast one node");
		else if (root.right == null)
			return root.value;

		Node node = root;
		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}

	@Override
	public Value min() {
		if (root == null)
			throw new IllegalArgumentException("tree must have atleast one node");
		else if (root.left == null)
			return root.value;
		Node node = root;
		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}

	@Override
	public Value kthLargest(int largest) {
		if (root == null)
			throw new IllegalArgumentException("tree must have atleast one node");

		Node node = root;
		Stacks<Node> stack = new Stack<Node>();

		while(true)
		{
			while (node != null) {
				stack.push(node);
				node = node.right;
			}
			
			node = stack.pop();
			
			if(largest == 1)
				return node.value;
			node = node.left;
			--largest;
		}
	}

	@Override
	public Value kthSmallest(int smallest) {
		
		if (root == null)
			throw new IllegalArgumentException("tree must have atleast one node");

		Node node = root;
		Stacks<Node> stack = new Stack<Node>();

		while(true)
		{
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			
			node = stack.pop();
			
			if(smallest == 1)
				return node.value;
			node = node.right;
			--smallest;
		}
	}

}

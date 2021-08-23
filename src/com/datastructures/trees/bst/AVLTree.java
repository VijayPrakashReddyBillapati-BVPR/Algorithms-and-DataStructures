package com.datastructures.trees.bst;

import com.datastructures.stack.Stack;
import com.datastructures.trees.Trees;

public class AVLTree<Key extends Comparable<Key>, Value> implements Trees<Key, Value> {

	Node root;

	public AVLTree() {
		this.root = null;
	}

	@Override
	public void insert(Key key, Value value) {
		if (key == null)
			throw new IllegalArgumentException("Key can't null");
		root = insert(key, value, root);

	}

	private Node insert(Key key, Value value, Node node) {

		if (node == null)
			return new Node(key, value);
		Integer compare = key.compareTo(node.key);

		if (compare < 0)
			node.left = insert(key, value, node.left);
		else if (compare > 0)
			node.right = insert(key, value, node.right);
		else
			node.value = value;

		node.height = Math.max(height(node.right), height(node.left));

		int balance = getBalance(node);

		if (balance > 1 && key.compareTo(node.left.key) < 0)
			return rightRotate(node);
		else if (balance < -1 && key.compareTo(node.right.key) > 0)
			return leftRotate(node);
		else if (balance > 1 && key.compareTo(node.left.key) > 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		} else if (balance < -1 && key.compareTo(node.right.key) < 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	private int getBalance(Node node) {

		return height(node.left) - height(node.right);
	}

	public Node rightRotate(Node node) {
		Node left = node.left;
		node.left = left.right;
		left.right = node;

		left.height = Math.max(height(left.right), height(left.left));
		node.height = Math.max(height(node.right), height(node.left));

		return left;

	}

	public Node leftRotate(Node node) {
		Node right = node.right;
		node.right = right.left;
		right.left = node;

		right.height = Math.max(height(right.right), height(right.left));
		node.height = Math.max(height(node.right), height(node.left));

		return right;
	}

	@Override
	public void delete(Key key) {

		if (key == null)
			throw new IllegalArgumentException();
		root = delete(key, root);

	}

	private Node delete(Key key, Node node) {
		if (node == null)
			return node;

		Integer compare = key.compareTo(node.key);
		if (compare > 0)
			node.right = delete(key, node.right);
		else if (compare < 0)
			node.left = delete(key, node.left);
		else {

			if (node.right == null)
				return node.left;
			else if (node.left == null)
				return node.right;
			else {
				node.key = minValue(node.right);
				node.right = delete(node.key, node.right);
			}
		}

		return node;
	}

	private Key minValue(Node node) {

		Node minNode = node;
		while (minNode.left != null) {
			minNode = minNode.left;
		}
		return minNode.key;
	}

	@Override
	public boolean search(Key key) {

		if (key == null)
			throw new IllegalArgumentException("key can't be null");

		Node node = search(key, root);

		if (node == null)
			return false;

		return true;
	}

	private Node search(Key key, Node node) {

		if (node == null || node.key == key)
			return node;

		Integer compare = key.compareTo(node.key);
		if (compare < 0)
			return node.left = search(key, node.left);

		return node.right = search(key, node.right);
	}

	@Override
	public int height() {

		return depth(root);
	}

	private int depth(Node node) {
		if (node == null)
			return 0;
		else {
			Integer rDepth = depth(node.right);
			Integer lDepth = depth(node.left);
			int depth = Math.max(rDepth, lDepth);
			return depth;
		}

	}

	private int height(Node node) {
		if (node == null)
			return 1;

		return node.height + 1;
	}

	@Override
	public void inorder() {
		inOrder(root);

	}

	private void inOrder(AVLTree<Key, Value>.Node node) {
		if (node != null) {
			preOrder(node.left);
			System.out.print(node.key + " ");
			preOrder(node.right);
		}

	}

	@Override
	public void postorder() {
		postOrder(root);

	}

	private void postOrder(AVLTree<Key, Value>.Node node) {
		if (node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.print(node.key + " ");
		}

	}

	@Override
	public void preorder() {
		preOrder(root);

	}

	private void preOrder(Node node) {

		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}

	}

	@Override
	public Value max() {

		Node node = root;

		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}

	@Override
	public Value min() {
		Node node = root;

		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}

	@Override
	public Value kthLargest(int largest) {

		Node node = root;
		Stack<Node> stack = new Stack<Node>();

		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.right;
			}

			node = stack.pop();
			if (largest == 1) {
				return node.value;
			}
			node = node.left;
			--largest;
		}

	}

	@Override
	public Value kthSmallest(int smallest) {

		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();

			if (smallest == 1)
				return node.value;

			node = node.right;
			--smallest;
		}
	}

	class Node {
		Key key;
		Value value;
		Node left, right;
		Integer height;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.height = 1;
		}

	}

}

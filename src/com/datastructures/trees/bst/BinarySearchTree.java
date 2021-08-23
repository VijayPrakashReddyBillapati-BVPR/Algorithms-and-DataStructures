package com.datastructures.trees.bst;

import com.datastructures.trees.Tree;

public class BinarySearchTree implements Tree {

	Node root;

	public BinarySearchTree() {
		super();
		root = null;
	}

	@Override
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

	@Override
	public void delete(Integer key) {
		if (key == null)
			throw new IllegalArgumentException("key can't be empty or null");
		root = delete(key, root);
	}

	private Node delete(Integer key, Node root) {

		if (root == null)
			return root;
		if (root.key < key) {
			root.right = delete(key, root.right);
		} else if (root.key > key) {
			root.left = delete(key, root.left);
		} else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			root.key = minValue(root.right);
			root.right = delete(root.key, root.right);
		}
		return root;
	}

	private Integer minValue(Node node) {

		if (node.left != null)
			return minValue(node.left);

		return node.key;
	}

	@Override
	public boolean search(Integer key) {
		if (key == null)
			throw new IllegalArgumentException("key can't be empty or null");

		Node node = null;
		node = search(key, root);
		if (node == null)
			return false;

		return true;
	}

	private Node search(Integer key, Node node) {

		if (node == null || root.key == key)
			return node;

		if (node.key < key)
			node.right = search(key, node.right);

		return node.left = search(key, node.left);
	}

	@Override
	public void inorder() {
		inorder(root);

	}

	private void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.key + " ");
			inorder(node.right);
		}

	}

	@Override
	public void postorder() {
		postorder(root);

	}

	private void postorder(Node node) {
		if (node != null) {
			inorder(node.left);
			inorder(node.right);
			System.out.println(node.key + " ");
		}

	}

	@Override
	public void preorder() {
		preorder(root);

	}

	private void preorder(Node node) {
		if (node != null) {
			System.out.println(node.key + " ");
			inorder(node.left);
			inorder(node.right);
		}

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

package com.java.oracle.ds.trees;

public class Node {
	
	int data;
	Node left;
	Node right;
	
	
	public Node(int data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}
	
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	

}

package com.java.oracle.ds.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	Node root;
	
	public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
        tree_level.root.left.right.left = new Node(8);
        tree_level.root.left.right.right = new Node(9);
        tree_level.root.right.left = new Node(6);
        tree_level.root.right.right = new Node(7);
        tree_level.root.right.right.left = new Node(10);
        tree_level.root.right.right.right = new Node(11);
        
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrderWithQueue();
        
        System.out.println("In order traversal of binary tree is - ");
        tree_level.printInOrderTraversalWithStack();

        System.out.println("Pre order traversal of binary tree is - ");
        tree_level.printPreOrderTraversalWithStack();
        
        System.out.println("Post order traversal of binary tree is - ");
        tree_level.printPostOrderTraversalWithStack();
    }
	
	void printLevelOrderWithQueue() {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			Node tempNode = queue.poll();
			
			System.out.print(tempNode.data+ " ");
			
			if (tempNode.left != null) 
				queue.add(tempNode.left);
			
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
		System.out.println();
	}
	
	
	void printInOrderTraversalWithStack() {
		
		if (root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		
		//first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		
		while(stack.size() > 0) {
			node = stack.pop();
			System.out.print(node.data + " ");
			
			if (node.right != null) {
				
				node = node.right;
				
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			
		}
		
	}
	
	
	void printPreOrderTraversalWithStack() {
		
		if (root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while (stack.empty() == false) {
			Node tempNode = stack.pop();
			System.out.print(tempNode.data + " ");
			
			if (tempNode.right != null) {
				stack.push(tempNode.right);			
			}
			
			if (tempNode.left != null) {
				stack.push(tempNode.left);
			}
		}
		
	}
	
	
	
	void printPostOrderTraversalWithStack() {
		
		if (root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node prev = null;
		
		
		while (!stack.isEmpty()) {
			Node current = stack.peek();
			
			if (prev == null || prev.left == current || prev.right == current) {
				
				if (current.left != null) 
					stack.push(current.left);
				else if (current.right != null)
					stack.push(current.right);
				else {
					stack.pop();
					System.out.print(current.data+ " ");
				}
				
			}
			else if (current.left == prev) 
            {
                if (current.right != null)
                    stack.push(current.right);
                else
                {
                    stack.pop();
					System.out.print(current.data+ " ");
                }
                  
                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } 
            else if (current.right == prev) 
            {
                stack.pop();
				System.out.print(current.data+ " ");
            }
  
            prev = current;
			
		}
		
		
	}
	
	
	
}

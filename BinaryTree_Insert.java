

//Java program to insert element in binary tree 
import java.util.LinkedList; 
import java.util.Queue;
import java.util.Scanner; 
public class BinaryTree_Insert { 
	
	// A binary tree node has key, pointer to 
	//left child and a pointer to right child 
	static class Node { 
		int key; 
		Node left, right; 
		
		// constructor 
		Node(int key){ 
			this.key = key; 
			left = null; 
			right = null; 
		} 
	} 
	static Node root; 
	static Node temp = root; 
	
	/* Inorder traversal of a binary tree*/
	static void inorder(Node temp) 
	{ 
		if (temp == null) 
			return; 
	
		inorder(temp.left); 
		System.out.print(temp.key+" "); 
		inorder(temp.right); 
	} 
	
	// insert element in binary tree 
	static void insert(Node temp, int key) 
	{ 
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(temp); 
	
		// Do level order traversal until find an empty Node 
		while (!q.isEmpty()) { 
			temp = q.peek(); 
			q.remove(); 
	
			if (temp.left == null) { 
				temp.left = new Node(key); 
				break; 
			} else
				q.add(temp.left); 
	
			if (temp.right == null) { 
				temp.right = new Node(key); 
				break; 
			} else
				q.add(temp.right); 
		} 
	} 
	
	// Main Method
	public static void main(String args[]) 
	{ 
		
	
		Scanner in = new Scanner(System.in);
		
		root = new Node(2); 
		root.left = new Node(3); 
		root.left.left = new Node(5); 
		root.right = new Node(6); 
		root.right.left = new Node(9); 
		 
	
		System.out.print(" Tree before insertion:"); 
		inorder(root); 
		
		System.out.print( "\n Please Enter elemnet: "); 
		int key = in.nextInt(); 
		insert(root, key); 
	
		System.out.print("\n Tree after insertion:"); 
		inorder(root); 
	} 
} 


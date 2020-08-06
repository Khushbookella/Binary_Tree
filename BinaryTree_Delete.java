//Java program to delete element in binary tree 
public class BinaryTree_Delete {

	// A binary tree node has key, pointer to 
	//left child and a pointer to right child 
	static class Node 
		{ 
			int key; 
			Node left, right; 

			Node(int key){ 
				this.key = key; 
				left = null; 
				right = null; 
			} 
		} 

		// Root of BST 
		static Node root; 
		static Node temp = root; 

		// Constructor 
		BinaryTree_Delete() 
		{ 
			root = null; 
		} 

		// This method mainly calls deleteRec() 
		void deleteKey(int key) 
		{ 
			root = deleteRec(root, key); 
		} 

		/* A recursive function to delete key */
		Node deleteRec(Node root, int key) 
		{ 
			/* Base Case: If the tree is empty */
			if (root == null) return root; 

			/* Otherwise, recur down the tree */
			if (key < root.key) 
				root.left = deleteRec(root.left, key); 
			else if (key > root.key) 
				root.right = deleteRec(root.right, key); 

			// if key is same as root's key, then This is the node 
			// to be deleted 
			else
			{ 
				// node with only one child or no child 
				if (root.left == null) 
					return root.right; 
				else if (root.right == null) 
					return root.left; 

				// node with two children: Get the inorder successor (smallest 
				// in the right subtree) 
				root.key = minValue(root.right); 

				// Delete the inorder successor 
				root.right = deleteRec(root.right, root.key); 
			} 

			return root; 
		} 

		int minValue(Node root) 
		{ 
			int minv = root.key; 
			while (root.left != null) 
			{ 
				minv = root.left.key; 
				root = root.left; 
			} 
			return minv; 
		} 

		
		
		// This method mainly calls InorderRec() 
		void inorder() 
		{ 
			inorderRec(root); 
		} 

		// A utility function to do inorder traversal of BST 
		void inorderRec(Node root) 
		{ 
			if (root != null) 
			{ 
				inorderRec(root.left); 
				System.out.print(root.key + " "); 
				inorderRec(root.right); 
			} 
		} 

		// Main Method 
		public static void main(String[] args) 
		{ 
			BinaryTree_Delete tree = new BinaryTree_Delete(); 
			
			root = new Node(2); 
			root.left = new Node(3); 
			root.left.left = new Node(5); 
			root.right = new Node(6); 
			root.right.left = new Node(9); 
			root.right.right = new Node(8); 
			
			System.out.println("Inorder traversal of the given tree"); 
			tree.inorder(); 

			System.out.println("\nDelete 8"); 
			tree.deleteKey(8); 
			System.out.println("Inorder traversal of the modified tree"); 
			tree.inorder(); 

			System.out.println("\nDelete 6"); 
			tree.deleteKey(6); 
			System.out.println("Inorder traversal of the modified tree"); 
			tree.inorder(); 

			System.out.println("\nDelete 9"); 
			tree.deleteKey(9); 
			System.out.println("Inorder traversal of the modified tree"); 
			tree.inorder(); 
	 
	} 
}
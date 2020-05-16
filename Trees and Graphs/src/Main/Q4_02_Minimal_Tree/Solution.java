package src.Main.Q4_02_Minimal_Tree;

import src.Main.CommonMethods.TreeNode;

//Given a sorted array with unique integer elements, write an algorithm to create a binary search tree with minimal height
public class Solution {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
		root.print();
	}

}

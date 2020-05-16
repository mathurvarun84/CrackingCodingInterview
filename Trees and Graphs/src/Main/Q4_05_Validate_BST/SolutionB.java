package src.Main.Q4_05_Validate_BST;

import src.Main.CommonMethods.CommonMethods;
import src.Main.CommonMethods.TreeNode;

public class SolutionB {
	public static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) ||
			!checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
		
	public static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	public static boolean checkBSTAlternate(TreeNode n) {
		return checkBSTAlternate(n, new IntWrapper(0), new IntWrapper(0));
	}		

	public static boolean checkBSTAlternate(TreeNode n, IntWrapper min, IntWrapper max) {
		/* An alternate, less clean approach. This is not provided in the book, but is used to test the other method. */
		if (n.left == null) {
			min.data = n.data;
		} else {
			IntWrapper leftMin = new IntWrapper(0);
			IntWrapper leftMax = new IntWrapper(0);
			if (!checkBSTAlternate(n.left, leftMin, leftMax)) {
				return false;
			}
			if (leftMax.data > n.data) {
				return false;
			}
			min.data = leftMin.data;
		}
		if (n.right == null) {
			max.data = n.data;
		} else {
			IntWrapper rightMin = new IntWrapper(0);
			IntWrapper rightMax = new IntWrapper(0);
			if (!checkBSTAlternate(n.right, rightMin, rightMax)) {
				return false;
			}
			if (rightMin.data <= n.data) {
				return false;
			}
			max.data = rightMax.data;
		}
		return true;
	}

	/* Create a tree that may or may not be a BST */
	public static TreeNode createTestTree() {
		/* Create a random BST */
		TreeNode head = CommonMethods.randomBST(10, -10, 10);
		
		/* Insert an element into the BST and potentially ruin the BST property */
		TreeNode node = head;
		do {
			int n = CommonMethods.randomIntInRange(-10, 10);
			int rand = CommonMethods.randomIntInRange(0, 5);
			if (rand == 0) {
				node.data = n;
			} else if (rand == 1) {
				node = node.left;
			} else if (rand == 2) {
				node = node.right;
			} else if (rand == 3 || rand == 4) {
				break;
			}
		} while (node != null);	
		
		return head;
	}
	
	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = {-1, 3, 5, 6, 10, 13, 15, 100};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBst = checkBST(node);
		System.out.println(isBst);

		//Negative case
		 array = new int[]{-1, 7, 5, 6, 10, 13, 15, 100};
		node = TreeNode.createMinimalBST(array);
		//node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		isBst = checkBST(node);
		System.out.println(isBst);


		array = new int[]{-1, 3, 4, 6, 5, 8, 2, 100};
		node = TreeNode.createMinimalBST(array);
		//node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		isBst = checkBST(node);
		System.out.println(isBst);
		/* More elaborate test -- creates 10 trees (some BST, some not) and compares the outputs of various methods. */
		/*for (int i = 0; i < 10; i++) {
			TreeNode head = createTestTree();
			
			// Compare results 
			boolean isBst1 = checkBST(head);
			boolean isBst2 = checkBSTAlternate(head);
			
			if (isBst1 != isBst2) {
				System.out.println("*********************** ERROR *******************");
				head.print();
				break;
			} else {
				System.out.println(isBst1 + " | " + isBst2);
				head.print();
			}
		}*/
	}
}

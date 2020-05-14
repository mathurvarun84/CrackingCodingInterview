package src.Main.Q2_03_Delete_Middle_Node;


import src.Main.Common.CommonMethods;
import src.Main.Common.LinkedListNode;

//Implement an algorithm to delete a node in the middle (i. e. any node but the first and the last node not necessarily at the middle
//of a singly linked list,given only access to that node.
public class Solution {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = CommonMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}

}

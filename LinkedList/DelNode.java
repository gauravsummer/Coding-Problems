package linkedList;

import java.util.Stack;

public class DelNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode newHead = deleteNode(node1);
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
	public static ListNode deleteNode(ListNode n1) {
		ListNode prev = null, curr = n1, next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}
	
}

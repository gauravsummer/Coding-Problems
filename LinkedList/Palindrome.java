package linkedList;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(3);
		ListNode node8 = new ListNode(2);
		ListNode node9 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		System.out.println(isPalin(node1));
	}
	public static boolean isPalin(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast != null) {
			slow = slow.next;
		}
		fast = head;
		slow = reverse(slow);
		while(slow != null) {
			if(slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}

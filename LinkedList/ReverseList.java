package linkedList;

public class ReverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode root = node1;
		System.out.println("Before: ");
		while(root!=null) {
			System.out.println(root.val);
			root = root.next;
		}
		reverse(root);
		System.out.println("After");
		while(root!=null) {
			System.out.println(root.val);
			root = root.next;
		}
	}
	public static void reverse(ListNode root) {
		
	}
}

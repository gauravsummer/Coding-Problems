package linkedList;

public class RemoveElement {

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
		ListNode root = removeElementsRecur(node1, 2);
		while(root!=null) {
			System.out.println(root.val);
			root = root.next;
		}
	}
	public static ListNode removeElements(ListNode head, int val) {
		while(head != null && head.val == val) 
			head = head.next;
		ListNode curr = head;
		while(curr != null && curr.next != null) {
        	if(curr.next.val == val)
        		curr.next = curr.next.next;
        	else
        		curr = curr.next;
        }
		return head;
    }
	public static ListNode removeElementsRecur(ListNode head, int val) {
		if (head == null) return null;
	     head.next = removeElementsRecur(head.next, val);
	     return head.val == val ? head.next : head;
	}
	 
}

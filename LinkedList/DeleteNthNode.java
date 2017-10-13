package linkedList;

public class DeleteNthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode root = deleteNode(node1,2);
		//deleteNode(node1,2);
		while(root!=null) {
			System.out.println(root.val);
			root = root.next;
		}
	}
	public static ListNode deleteNode(ListNode head, int n) {
		while(head != null && head.val == n)
			head = head.next;
		ListNode curr = head;
		while(curr != null && curr.next != null){
			if(curr.next.val == n)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return head;
	}
}

package Implementation;

import java.awt.List;

class Link {
	public int data1;
	public double data2;
	public Link next;
	public Link(int data1, double data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	public void printLink() {
		System.out.print("{"+data1+", "+data2+"}, ");
	}
}

class LinkedList {
	private Link head;
	private Link tail;
	public LinkedList() {
		head = null;
		tail = null;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void insertHead(int d1, double d2) {
		Link link = new Link(d1, d2);
		link.next = head;
		head = link;
	}
	public void insertTail(int d1, double d2) {
		Link link = new Link(d1, d2);
		if(head == null) {
			link.next = head;
			head = link;
			tail = link;
		}
		else {
			tail.next = link;
			tail = link;
			link.next = null;
		}
		
	}
	public Link delete() {
		Link temp = head;
		head = head.next;
		return temp;
	}
	public void printList() {
		Link curr = head;
		System.out.println("List: ");
		while(curr != null) {
			curr.printLink();
			curr = curr.next;
		}
		System.out.println();
	}
}

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList newList = new LinkedList();
		newList.insertTail(1, 1.0);
		newList.insertTail(2, 2.0);
		newList.insertTail(3, 3.0);
		newList.insertTail(4, 4.0);
		newList.insertTail(5, 5.0);
		newList.printList();
		while(!newList.isEmpty()) {
			Link deleted = newList.delete();
			System.out.print("deleted: ");
			deleted.printLink();
			System.out.println();
		}
		newList.printList();
	}

}

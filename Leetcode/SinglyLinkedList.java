package common;

import java.util.HashSet;

class Link {
	public String bookName;
	public int millionSold;
	
	public Link next;
	
	public Link(String bookName, int millionSold) {
		this.bookName = bookName;
		this.millionSold = millionSold;
	}
	
	public void display() {
		System.out.println(bookName +": "+millionSold);
	}
	
	public String toString() {
		return bookName;
	}
	
}

class LinkedList {
	public Link head;
	LinkedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return(head == null);
	}
	
	public void insertHead(String bookName, int millionSold) {
		Link temp = new Link(bookName, millionSold);
		temp.next = head;
		head = temp;
	}
	
	public Link removeHead() {
		Link temp = head;
		if(!isEmpty())
			head = head.next;
		else {
			System.out.println("empty list");
		}
		return temp;
	}
	
	public void display() {
		Link temp = head;
		while(temp != null) {
			temp.display();
			System.out.println("Next Link "+temp.next);
			temp = temp.next;
			System.out.println();
		}
	}
	
	public Link findLink(String bookName) {
		Link temp = head;
		if(!isEmpty()) {
			while(temp.bookName != bookName) {
				if(temp.next == null) {
					return null;
				}
				else {
					temp = temp.next;
				}
			}
		}
		else {
			System.out.println("Empty list");
		}
		return temp;
	}
	
	public Link removeLink(String bookName) {
		Link currLink = head;
		Link prevLink = head;
		while(currLink.bookName != bookName) {
			if(currLink.next == null) {
				return null;
			}
			else {
				prevLink = currLink;
				currLink = currLink.next;
			}
		}
		if(currLink == head) {
			head = head.next;
		}
		else {
			prevLink.next = currLink.next;
			
		}
		return currLink;
	}
	
	public void removeDuplicate() {
		HashSet<String> set = new HashSet<String>();
		Link previous = null;
		Link current = head;
		while(current != null) {
			if(set.contains(current.bookName)) {
				previous.next = current.next;
			}
			else {
				set.add(current.bookName);
				previous = current;
			}
			current = current.next;
		}
	}
	
	public void removeDuplicateNSq() {
		Link current = head;
		while(current.next != null) {
			Link j = current;
			while(j.next!=null) {
				if(j.next.bookName == current.bookName) {
					j.next = j.next.next;
				}
				else {
					j = j.next;
				}
			}
			current = current.next;
		}	
	}
	
	public void nthToLastOuter(int k) {
		if(k < 1)
			System.out.println("Should be more than 0");
		nthToLast(head, k);
	}
	
	public int nthToLast(Link head, int k) {
		if(head == null)
			return 0;
		int i = nthToLast(head.next, k) + 1;
		if(i == k)
			System.out.println(head.bookName);
		return i;
	}
	
	public void nthToLastIter(int k) {
		if(k < 1) {
			System.out.println("enter more than 0");
		}
		else {
			Link p1 = head;
			Link p2 = head;
			for(int i=0; i<k-1; i++) {
				if(p1 == null)
					System.out.println("not enough length");
				else
					p1 = p1.next;
			}
			if(p1 == null)
				System.out.println("not enough length");
			else {
				while(p1.next != null) {
					p1 = p1.next;
					p2 = p2.next;
				}
				System.out.println(p2.bookName);
			}
		}
	}
	public void del() {
		Link n = head.next.next;
		delNode(n);
	}
	public void delNode(Link n) {
		if(n == null || n.next == null)
			System.out.println("Cannot delete");
		String book = n.bookName;
		Link next = n.next;
		n.bookName = next.bookName;
		n.millionSold = next.millionSold;
		n.next = next.next;
		System.out.println("deleted book: "+book);
	}
}

public class SinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList newList = new LinkedList();
		newList.insertHead("abc", 100);
		newList.insertHead("ccac", 110);
		newList.insertHead("abc", 120);
		newList.insertHead("adsdec", 130);
		newList.insertHead("abc", 150);
		//newList.removeHead();
		//newList.removeHead();
		//newList.removeLink("ccac");
		//newList.removeDuplicate();
		//newList.display();
		//newList.removeDuplicateNSq();
		//newList.nthToLastOuter(0);
		newList.del();
		newList.display();
		//newList.nthToLastIter(6);
		
	}
}

package common;
class Node {
	private Node left;
	private Node right;
	private Node parent;
	private int value;
	public Node(Node left, Node right, int value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public int getValue() {
		return value;
	}
	
	public Node findNode(Node root, int value) {
		while(root != null) {
			if(root.getValue() == value) {
				return root;
			}
			else if(root.getValue() < value) {
				root = root.getRight();
			}
			else {
				root = root.getLeft();
			}
		}
		return root;
	}
	
	public int getHeight(Node n) {
		if(n == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(n.getLeft()), getHeight(n.getRight()));
	}
	
	public void printValue(Node n) {
		System.out.println(n.getValue());
	}
	
	public void preOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		printValue(root);
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}
	
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		inOrderTraversal(root.getLeft());
		printValue(root);
		inOrderTraversal(root.getRight());
	}
	
	public void postOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		printValue(root);
	}
	
	public void preOrderTraversalIter(Node root) {
		NodeStack stack = new NodeStack();
		stack.push(root);
		//while(stack.size() > 0) {
			Node curr = stack.pop();
			printValue(curr);
			Node n = curr.getRight();
			if(n != null) {
				stack.push(n);
			}
			n = curr.getLeft();
			if(n != null) {
				stack.push(n);
			}
		//}
	}
	
	public Node lowestCommonAncestor(Node root, int value1, int value2) {
		while(root != null) {
			int value = root.getValue();
			if(value > value1) {
				root = root.getLeft();
			}
			else if(value < value1 && value < value2) {
				root = root.getRight();
			}
			else {
				return root;
			}
		}
		return null;
	}
	
	public Node rotateRight() {
		Node newRoot = left;
		left = newRoot.right;
		newRoot.right = this;
		return newRoot;
	}
}

class NodeStack {
	public void push(Node n) {
		
	}
	//public Node pop() {
		
	//}
}
public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n5 = new Node(null,null,3);
		Node n4 = new Node(n5,null,1);
		Node n3 = new Node(null,null,5);
		Node n2 = new Node(n4,null,2);
		Node n1 = new Node(n2,n3,4);
		System.out.println(isBalanced(n1));
		System.out.println(n1.getHeight(n4));
		
	}

	public static int checkHeight(Node root) {
		if(root == null)
			return 0;
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1)
			return -1;
		int heightDiff = Math.abs(leftHeight-rightHeight);
		if(heightDiff > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean checkBST(Node n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean checkBST(Node n, int min, int max) {
		if(n == null)
			return true	;
		if(n.getValue() <= min || n.getValue() > max) {
			return false;
		}
		if(!checkBST(n.getLeft(), min, n.getValue()) || !checkBST(n.getRight(),n.getValue(), max)) {
			return false;
		}
		return true;
	}
	public static boolean isBalanced(Node root) {
		if(checkHeight(root) == -1)
			return false;
		else
			return true;
	}
}

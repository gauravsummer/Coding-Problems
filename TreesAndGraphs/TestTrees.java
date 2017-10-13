package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestTrees {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(15);
		TreeNode treeNode11 = new TreeNode(10);
		TreeNode treeNode12 = new TreeNode(20);
		TreeNode treeNode13 = new TreeNode(1);
		TreeNode treeNode14 = new TreeNode(11);
		TreeNode treeNode15 = new TreeNode(18);
		TreeNode treeNode16 = new TreeNode(101);
		TreeNode treeNode17 = new TreeNode(16);
		TreeNode treeNode18 = new TreeNode(19);
		treeNode1.left = treeNode11;
		treeNode1.right = treeNode12;
		treeNode11.left = treeNode13;
		treeNode11.right = treeNode14;
		treeNode12.left = treeNode15;
		treeNode12.right = treeNode16;
		treeNode15.left = treeNode17;
		treeNode15.right = treeNode18;
		System.out.println(balanced(treeNode15));
	}
	public static TreeNode balanced(TreeNode root) {
		if(root == null)
			return null;
		if(root.right != null)
			return leftMost(root.right);
		TreeNode p = root.parent;
		while(p != null && root != p.left){
			root = p;
			p = p.parent;
		}
		return p;
	}
	public static TreeNode leftMost(TreeNode node) {
		if(node == null)
			return null;
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
}	

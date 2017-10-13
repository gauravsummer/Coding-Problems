package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(100);
		TreeNode treeNode11 = new TreeNode(10);
		TreeNode treeNode12 = new TreeNode(110);
		TreeNode treeNode13 = new TreeNode(1110);
		TreeNode treeNode14 = new TreeNode(11);
		TreeNode treeNode15 = new TreeNode(1);
		TreeNode treeNode16 = new TreeNode(101);
		TreeNode treeNode17 = new TreeNode(1011);
		TreeNode treeNode18 = new TreeNode(111);
		treeNode1.left = treeNode11;
		treeNode1.right = treeNode12;
		treeNode11.left = treeNode13;
		treeNode11.right = treeNode14;
		treeNode13.left = treeNode15;
		treeNode13.right = treeNode16;
		treeNode15.left = treeNode17;
		treeNode17.right = treeNode18;
		System.out.println(invertBFS(treeNode1).val);
	}
	public static TreeNode invertDFS(TreeNode root) {
		if(root == null) 
			return null;
		TreeNode tmp = root.left;
		root.left = invertDFS(root.right);
		root.right = invertDFS(tmp);
		return root;
	}
	public static TreeNode invertBFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(! queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if(node.left != null) {
				invertBFS(node.left);
			}
			if(node.right != null) {
				invertBFS(node.right);
			}
		}
		return root;
	}

}

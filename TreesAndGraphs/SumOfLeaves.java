package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeaves {

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
		treeNode14.left = treeNode18;
		System.out.println(leftsumIter(treeNode1));
	}
	public static int leftsum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int ans = 0;
		if(root.left != null) {
			if(root.left.left == null && root.left.right == null)
				ans += root.left.val;
			else
				ans += leftsum(root.left);
		}
		ans += leftsum(root.right);
		return ans;
	}

	public static int leftsumIter(TreeNode root) {
		if(root == null)
			return 0;
		int ans = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left != null && node.left.left == null && node.left.right == null)
					ans += node.left.val;
			if(node.left != null){
					queue.add(node.left);
				}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		return ans;
	}
}

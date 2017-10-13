package TreesAndGraphs;

import java.util.HashMap;

public class TestTree {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode9 = new TreeNode(9);
		TreeNode treeNode10 = new TreeNode(10);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;
		treeNode7.left = treeNode8;
		treeNode7.right = treeNode9;
		System.out.println(check(treeNode1, 10));
	}
	
	public static int check(TreeNode root, int x) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return check(root, 0, x, map);
	}
	public static int check(TreeNode root, int curr, int tar, HashMap<Integer, Integer> map) {
		if(root == null)
			return 0;
		curr = curr + root.val;
		int res = map.getOrDefault(curr - tar, 0);
		map.put(curr, map.getOrDefault(curr, 0)+1);
		res += check(root.left, curr, tar, map) + check(root.right, curr, tar, map);
		map.put(curr, map.get(curr)-1);
		return res;
	}
}

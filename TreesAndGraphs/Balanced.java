package TreesAndGraphs;

public class Balanced {

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
		System.out.println(isBalanced(treeNode1));
	}
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		return height(root) != -1;
	}
	public static int height(TreeNode root) {
		if(root == null)
			return 0;
		int left = height(root.left);
		if(left == -1)
			return -1;
		int right = height(root.right);
		if(right == -1)
			return -1;
		if(Math.abs(left - right) > 1)
			return -1;
		else
			return Math.max(left, right) + 1;
	}
}

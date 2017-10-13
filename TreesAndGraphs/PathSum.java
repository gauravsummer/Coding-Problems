package TreesAndGraphs;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode11 = new TreeNode(2);
		TreeNode treeNode12 = new TreeNode(4);
		TreeNode treeNode13 = new TreeNode(8);
		TreeNode treeNode14 = new TreeNode(6);
		TreeNode treeNode15 = new TreeNode(4);
		TreeNode treeNode16 = new TreeNode(4);
		TreeNode treeNode17 = new TreeNode(4);
		TreeNode treeNode18 = new TreeNode(4);
		treeNode1.left = treeNode11;
		treeNode1.right = treeNode12;
		treeNode11.left = treeNode13;
		treeNode11.right = treeNode14;
		treeNode13.left = treeNode15;
		treeNode13.right = treeNode16;
		treeNode15.left = treeNode17;
		treeNode17.right = treeNode18;
		System.out.println(hasPathSum(treeNode1, 8));
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null)
			return (sum - root.val) == 0;
		return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right, sum-root.val);
	}
}

package TreesAndGraphs;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(100);
		TreeNode treeNode2 = new TreeNode(100);
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
		treeNode2.left = treeNode11;
		treeNode2.right = treeNode12;
		treeNode11.left = treeNode13;
		treeNode11.right = treeNode14;
		treeNode13.left = treeNode15;
		treeNode13.right = treeNode16;
		treeNode15.left = treeNode17;
		treeNode14.left = treeNode18;
		System.out.println(same(treeNode1, treeNode2));
	}
	public static boolean same(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.val == q.val)
			return same(p.left, q.left) && same(p.right, q.right);
		return false;
	}
}

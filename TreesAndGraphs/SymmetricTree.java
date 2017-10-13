package TreesAndGraphs;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode11 = new TreeNode(2);
		TreeNode treeNode12 = new TreeNode(2);
		TreeNode treeNode13 = new TreeNode(3);
		TreeNode treeNode14 = new TreeNode(4);
		TreeNode treeNode15 = new TreeNode(4);
		TreeNode treeNode16 = new TreeNode(3);
		treeNode1.left = treeNode11;
		treeNode1.right = treeNode12;
		treeNode11.left = treeNode13;
		treeNode11.right = treeNode14;
		treeNode12.left = treeNode15;
		treeNode12.right = treeNode16;
		
		System.out.println(Symmetric(treeNode1));
	}
	public static boolean Symmetric(TreeNode root) {
		if(root  ==  null)
			return true;
		return isMirror(root.left, root.right);
	}
	public static boolean isMirror(TreeNode l, TreeNode r) {
		if(l == null && r == null)
			return true;
		if(l == null || r == null)
			return false;
		return (l.val == r.val) && isMirror(l.left, r.right) && isMirror(l.right, r.left);
	}
}

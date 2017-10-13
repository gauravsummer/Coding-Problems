package TreesAndGraphs;

public class CommonAncestor {
	static class Result{
		TreeNode node;
		boolean isAnc;
		public Result(TreeNode node, boolean isAnc) {
			this.node = node;
			this.isAnc = isAnc;
		}
	}
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
		System.out.println(common(treeNode1, treeNode13, treeNode15).val);
	}
	public static TreeNode common(TreeNode root, TreeNode a, TreeNode b) {
		Result r = commonAnc(root, a, b);
		if(r.node!= null && r.isAnc) {
			return r.node;
		}
		return null;
	}
	public static Result commonAnc(TreeNode root, TreeNode a, TreeNode b) {
		if(root == null) {
			return new Result(null, false);
		}
		if(root == a && root == b) {
			return new Result(root, true);
		}
		Result rl = commonAnc(root.left, a, b);
		if(rl.isAnc) {
			return rl;
		}
		Result rr = commonAnc(root.right, a, b);
		if(rr.isAnc)
			return rr;
		if(rl.node != null && rr.node != null) {
			return new Result(root, true);
		}
		else if(root == a || root == b) {
			boolean anc = rl.node != null || rr.node != null;
			return new Result(root, anc);
		}
		else {
			return new Result(rl.node != null ? rl.node: rr.node, false);
		}
		
	}
}

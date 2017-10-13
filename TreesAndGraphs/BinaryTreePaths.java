package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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
		List<String> lis = binaryTreePaths(treeNode1);
		for(String s : lis)
			System.out.println(s);
	}
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList();
        if(root != null)
        	search(root, "",out);
        return out;
    }
	public static void search(TreeNode root, String path, List<String> answer) {
		if(root.left == null && root.right == null)
			answer.add(path + root.val);
		if(root.left != null)
			search(root.left, path+root.val+"->", answer);
		if(root.right != null)
			search(root.right, path+root.val+"->", answer);
	}
}

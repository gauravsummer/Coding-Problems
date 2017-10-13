package TreesAndGraphs;

public class CreateMinimalBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,5,6,7,8,13,14,16,18};
		CreateMinimalBST bst = new CreateMinimalBST();
		TreeNode root = bst.create(arr);
		while(root != null) {
			System.out.println(root.val);
			root = root.left;
		}
	}
	public TreeNode create(int[] arr) {
		return create(arr, 0, arr.length-1);
	}
	public TreeNode create(int[] arr, int start, int end) {
		if(end < start)
			return null;
		int mid = (end + start) / 2;
		TreeNode n = new TreeNode(mid);
		n.left = create(arr,start, mid-1);
		n.right = create(arr,mid+1, end);
		return n;
	}
}

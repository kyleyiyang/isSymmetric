/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        if (root.left!=null && root.right!=null && root.left.val!=root.right.val) return false;
        ArrayList<Integer> arr = new ArrayList<>();
        walk(root,arr);
        //System.out.println(arr);
        for (int i=0;i<arr.size();i++) {
            if (arr.get(i)!=arr.get(arr.size()-i-1)) return false;
        }
        return true;
    }
    public void walk(TreeNode root, ArrayList<Integer> arr) {
        if (root.left==null && root.right!=null) arr.add(-1);
        if (root.left!=null) walk(root.left,arr);
        arr.add(root.val);
        if (root.right!=null) walk(root.right,arr);
        if (root.left!=null && root.right==null) arr.add(-1);
       }
}

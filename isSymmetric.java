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
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1==null && r2==null) return true;
        if (r1==null || r2==null) return false;
        return r1.val==r2.val && isMirror(r1.left,r2.right) && isMirror(r1.right, r2.left);
       }
}

//iterative

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1==null && t2==null) continue;
            if (t1==null || t2==null) return false;
            if (t1.val!=t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t2.left);
            q.add(t1.right);
        }
        return true;
    }
}

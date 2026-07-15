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
    public int rangeSumBST(TreeNode root, int low, int high) {
        /*
            Time Complexity: O(n) worst case, O(h + k) better case
           1. Worst case — O(n): Agar low aur high ka range itna bada hai ki poora tree usmein aa jaata hai (ya tree skewed hai), to tumhe practically har node visit karna padega. Isliye worst case O(n) hai (n = total nodes).
        2. Better/average case — O(h + k): Jab range narrow hai (chhota sa portion of tree), to BST property ki wajah se pruning hoti hai.(jahan tak pahunचने mein sirf pruning ho rahi hai) uski length O(h) hai, aur jo actual range ke andar wale nodes hain unki count k hai — total time ban jaata hai O(h + k).
        
        Space Complexity: O(h)
        Max depth = height of tree = h.
        Balanced BST mein: h = O(log n).
        Skewed BST mein (worst case): h = O(n).
        */
        if (root == null)
            return 0;

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left, low, high);
    }
}
package nov_20_challange.nov15;

import tree.TreeNode;

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        int result = nodeValue(root, low, high);
        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);

        return result;
    }

    private int nodeValue (TreeNode node, int low, int high){
        return node.val >= low && node.val <= high ? node.val : 0;
    }
}

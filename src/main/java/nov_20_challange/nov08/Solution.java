package nov_20_challange.nov08;

import tree.TreeNode;

class Solution {
    public int findTilt(TreeNode root) {
        RecursionValues values = calculate(root);
        return values.getTilt();
    }

    public RecursionValues calculate(TreeNode node) {
        if(node == null){
            return new RecursionValues(0,0);
        }

        RecursionValues left = calculate(node.left);
        RecursionValues right = calculate(node.right);

        int tilt = Math.abs(left.getSubtreeVal() - right.getSubtreeVal());
        int val = node.val + left.getSubtreeVal() + right.getSubtreeVal();
        int generalTilt = tilt + left.getTilt() + right.getTilt();

        return new RecursionValues(generalTilt,val);
    }

    private class RecursionValues {
        private final int tilt;
        private final int subtreeVal;

        private RecursionValues(int tilt, int subtreeVal) {
            this.tilt = tilt;
            this.subtreeVal = subtreeVal;
        }

        public int getTilt() {
            return tilt;
        }

        public int getSubtreeVal() {
            return subtreeVal;
        }
    }
}

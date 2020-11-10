package nov_20_challange.nov09;

import nov_20_challange.TreeNode;

import static java.lang.Math.*;

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return calculate(root).getDifference();
    }

    private RecursiveValues calculate(TreeNode node){
        if(node == null){
            return new RecursiveValues(0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        RecursiveValues left = calculate(node.left);
        RecursiveValues right = calculate(node.right);

        int min = minTriplet(left.min, right.min, node.val);
        int max = maxTriplet(left.max, right.max, node.val);

        int nodeDifference = node.left == null && node.right == null ? 0 : max(abs(node.val - min), abs(node.val - max));
        int difference = maxTriplet(left.difference, right.difference, nodeDifference);

        return new RecursiveValues(difference, min, max);
    }

    private int minTriplet(int a, int b, int c){
        return min(min(a,b),c);
    }

    private int maxTriplet(int a, int b, int c){
        return max(max(a,b),c);
    }

    private class RecursiveValues{
        private final int difference;
        private final int min;
        private final int max;

        public RecursiveValues(int difference, int min, int max) {
            this.difference = difference;
            this.min = min;
            this.max = max;
        }

        public int getDifference() {
            return difference;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }
}

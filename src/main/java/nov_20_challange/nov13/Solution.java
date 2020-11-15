package nov_20_challange.nov13;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Queue<Node> nextLevel = new LinkedList<>();

        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                node.next = queue.peek();
            }
            queue = nextLevel;
            nextLevel = new LinkedList<>();
        }

        return root;
    }



}

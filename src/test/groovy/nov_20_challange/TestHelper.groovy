package nov_20_challange

import tree.TreeNode

class TestHelper {
    @SuppressWarnings('GroovyAssignabilityCheck')
    static ListNode arr2ListNode(List array) {
        if(array.isEmpty()){
            return array
        }

        List reverse = array.reverse()
        ListNode result = new ListNode(reverse[0])
        for (int i = 1; i < reverse.size(); i++) {
            result = new ListNode(reverse[i], result)
        }
        result
    }

    static def listToArray(ListNode head) {
        def list = new ArrayList()
        while(head != null){
            list.add(head.val)
            head = head.next
        }
        list
    }

    static TreeNode arrToTree(List<Integer> arr) {
        Queue<TreeNode> queue = new LinkedList<>()
        def root = new TreeNode(arr.get(0))
        queue.add(root)
        boolean fillLeft = false
        for (int i = 1; i < arr.size(); i++) {
            def value = arr.get(i)
            fillLeft = !fillLeft
            if (value != null) {
                def node = new TreeNode(value)
                def parent = queue.peek()
                if (fillLeft) {
                    parent.left = node
                } else {
                    parent.right = node
                }
                queue.add(node)
            }
            if (!fillLeft) {
                queue.pop()
            }
        }
        root
    }
}

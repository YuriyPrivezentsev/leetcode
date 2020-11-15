package nov_20_challange.nov13

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should test for #inputTree"() {
        expect:
        underTest.connect(arrToTree(inputTree)) != null

        where:
        inputTree             || outputTree
        [1, 2, 3, 4, 5, 6, 7] || [1, null, 2, 3, null, 4, 5, 6, 7, null]
    }

//    List<Integer> treeToArray(Node node){
//
//    }

    static Node arrToTree(List<Integer> arr) {
        Queue<Node> queue = new LinkedList<>()
        def root = new Node(arr.get(0))
        queue.add(root)
        boolean fillLeft = false
        for (int i = 1; i < arr.size(); i++) {
            def value = arr.get(i)
            fillLeft = !fillLeft
            if (value != null) {
                def node = new Node(value)
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

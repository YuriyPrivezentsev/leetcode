package nov_20_challange.nov08

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    def underTest = new Solution()

    @Unroll
    "should produce #result for #input"() {
        expect:
        underTest.findTilt(arrToTree(input)) == result

        where:
        input                         || result
        [1, 2, 3]                     || 1
        [4, 2, 9, 3, 5, null, 7]      || 15
        [21, 7, 14, 1, 1, 2, 2, 3, 3] || 9
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

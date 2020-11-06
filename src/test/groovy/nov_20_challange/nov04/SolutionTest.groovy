package nov_20_challange.nov04

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution2()

    @Unroll
    "Should produce #heads for #edges"() {
        expect:
        underTest.findMinHeightTrees(nodes, edges) == heads

        where:
        nodes | edges                                                                               || heads
        10    | [[0, 1], [0, 2], [0, 3], [2, 4], [0, 5], [5, 6], [6, 7], [2, 8], [7, 9]] as int[][] || [5]
        6     | [[0, 1], [0, 2], [0, 3], [3, 4], [4, 5]] as int[][]                                 || [3]
        4     | [[1, 0], [1, 2], [1, 3]] as int[][]                                                 || [1]
        6     | [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]] as int[][]                                 || [3, 4]
        1     | [] as int[][]                                                                       || [0]
        2     | [[0, 1]] as int[][]                                                                 || [0, 1]
    }
}

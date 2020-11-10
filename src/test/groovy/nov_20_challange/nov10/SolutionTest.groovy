package nov_20_challange.nov10

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "test for #input"() {
        expect:
        underTest.flipAndInvertImage(input as int[][]) == output as int[][]

        where:
        input                                                    || output
        [[1, 1, 0], [1, 0, 1], [0, 0, 0]]                        || [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
        [[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]] || [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
    }
}

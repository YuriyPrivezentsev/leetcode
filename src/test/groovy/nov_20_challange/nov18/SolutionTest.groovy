package nov_20_challange.nov18

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should merge"() {
        expect:
        underTest.merge(input as int[][]) == output as int[][]

        where:
        input                               || output
        [[1, 3], [2, 6], [8, 10], [15, 18]] || [[1, 6], [8, 10], [15, 18]]
        [[1, 4], [4, 5]]                    || [[1, 5]]
    }
}

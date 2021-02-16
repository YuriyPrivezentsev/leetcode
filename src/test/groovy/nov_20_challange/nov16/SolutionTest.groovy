package nov_20_challange.nov16

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should have #length at #input"() {
        expect:
        underTest.longestMountain(input as int[]) == length

        where:
        length || input
        5      || [2, 1, 4, 7, 3, 2, 5]
        0      || [2, 2, 2]
        0      || [3, 2, 1]
        7      || [1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 1]
        6      || [1, 2, 3, 2, 1, 2, 3, 4, 3, 2]
    }

}

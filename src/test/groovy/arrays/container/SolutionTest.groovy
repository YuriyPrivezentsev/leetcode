package arrays.container

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "for #input should be volume #volume"() {
        expect:
        underTest.maxArea(input as int[]) == volume

        where:
        input                       || volume
        [1, 1]                      || 1
        [1, 8, 6, 2, 5, 4, 8, 3, 7] || 49
        [4, 3, 2, 1, 4]             || 16
        [1, 2, 1]                   || 2
    }
}

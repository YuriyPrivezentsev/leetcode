package arrays.two_sum

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    def underTest = new Solution()

    @Unroll
    "for #input and target #target should be #output"() {
        expect:
        underTest.twoSum(input as int[], target) == output as int[]

        where:
        input          | target || output
        [2, 7, 11, 15] | 9      || [0, 1]
        [3, 2, 4]      | 6      || [1, 2]
        [3, 3]         | 6      || [0, 1]
        [-3, 4, 3, 5]  | 2      || [0, 3]
    }
}

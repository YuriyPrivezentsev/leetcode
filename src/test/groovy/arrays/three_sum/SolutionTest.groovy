package arrays.three_sum

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "for array #input expect following triplets #outputs"() {
        when:
        def triplets = underTest.threeSum(input as int[])

        then:

        triplets.size() == ((int[][]) outputs).length

        where:
        input                                     || outputs
        [0, 0, 0]                                 || [[0, 0, 0]]
        [0, 0, 0, 0]                              || [[0, 0, 0]]
        [-1, 0, 1, 2, -1, -4]                     || [[-1, -1, 2], [-1, 0, 1]]
        [-1, 1, -1, 2]                            || [[-1, 1, 2]]
        [1, 2, -2, -1]                            || []
        [0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0] || [[-3, 0, 3], [-1, 0, 1], [0, 0, 0]]
        [-2, 0, 1, 1, 2]                          || [[-2, 0, 2], [-2, 1, 1]]
    }
}

package simple.permutation

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "for #input should produce #output"() {
        expect:
        underTest.buildArray(input as int[]) == output as int[]

        where:
        input || output
        [0, 2, 1, 5, 3, 4] || [0, 1, 2, 4, 5, 3]
        [5, 0, 1, 2, 3, 4] || [4, 5, 0, 1, 2, 3]
        [4, 5, 0, 1, 2, 3] || [4, 5, 0, 1, 2, 3]
    }
}

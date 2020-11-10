package nov_20_challange.nov09

import nov_20_challange.TestHelper
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should have #difference for #tree"() {
        expect:
        underTest.maxAncestorDiff(TestHelper.arrToTree(tree)) == difference

        where:
        tree                                             || difference
        [8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13] || 7
        [1, null, 2, null, 0, 3]                         || 3
    }
}

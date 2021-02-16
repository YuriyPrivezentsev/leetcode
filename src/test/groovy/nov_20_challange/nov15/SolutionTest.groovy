package nov_20_challange.nov15

import nov_20_challange.TestHelper
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should return #result for #tree in range [#low, #high]"() {
        expect:
        underTest.rangeSumBST(TestHelper.arrToTree(tree), low, high) == result

        where:
        tree                                  | low | high || result
        [10, 5, 15, 3, 7, 13, 18, 1, null, 6] | 6   | 10   || 23
    }
}

package nov_20_challange.nov01

import nov_20_challange.TestHelper
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    def underTest = new Solution()

    @Unroll
    "shoud test #result"() {
        expect:
        underTest.getDecimalValue(TestHelper.arr2ListNode(array)) == result
        where:
        array                                         || result
        [1, 0, 1]                                     || 5
        [1, 1, 0]                                     || 6
        [0]                                           || 0
        [1]                                           || 1
        [1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0] || 18880
        [0, 0]                                        || 0
    }
}

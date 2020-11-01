package nov_20_challange.nov01

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    def underTest = new Solution()

    @Unroll
    "shoud test #result"() {
        expect:
        underTest.getDecimalValue(arr2ListNode(array)) == result
        where:
        array                                         || result
        [1, 0, 1]                                     || 5
        [1, 1, 0]                                     || 6
        [0]                                           || 0
        [1]                                           || 1
        [1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0] || 18880
        [0, 0]                                        || 0
    }

    @SuppressWarnings('GroovyAssignabilityCheck')
    static def arr2ListNode(List array) {
        List reverse = array.reverse()
        ListNode result = new ListNode(reverse[0])
        for (int i = 1; i < reverse.size(); i++) {
            result = new ListNode(reverse[i], result)
        }
        result
    }
}

package nov_20_challange.nov02

import nov_20_challange.TestHelper
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should sort #input"() {
        expect:
        TestHelper.listToArray(underTest.insertionSortList(TestHelper.arr2ListNode(input))) == output

        where:
        input            || output
        [4, 2, 1, 3]     || [1, 2, 3, 4]
        [-1, 5, 3, 4, 0] || [-1, 0, 3, 4, 5]
        [1]              || [1]
    }
}

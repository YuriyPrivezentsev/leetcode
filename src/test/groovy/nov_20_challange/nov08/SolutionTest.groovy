package nov_20_challange.nov08

import nov_20_challange.TestHelper
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    def underTest = new Solution()

    @Unroll
    "should produce #result for #input"() {
        expect:
        underTest.findTilt(TestHelper.arrToTree(input)) == result

        where:
        input                         || result
        [1, 2, 3]                     || 1
        [4, 2, 9, 3, 5, null, 7]      || 15
        [21, 7, 14, 1, 1, 2, 2, 3, 3] || 9
    }

}

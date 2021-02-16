package nov_20_challange.nov21

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should return #result for #array and #limit"() {
        expect:
        underTest.atMostNGivenDigitSet(array as String[], limit) == result

        where:
        array                | limit      || result
        ["7"]                | 8          || 1
        ["1", "3", "5", "7"] | 100        || 20
        ["1", "4", "9"]      | 1000000000 || 29523
    }
}

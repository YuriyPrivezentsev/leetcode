package nov_20_challange.nov03

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "For #input magnitude is #power"() {
        expect:
        underTest.maxPower(input) == power

        where:
        input                 || power
        ""                    || 0
        "t"                   || 1
        "cc"                  || 2
        "ecc"                 || 2
        "cce"                 || 2
        "leetcode"            || 2
        "abbcccddddeeeeedcba" || 5
        "triplepillooooow"    || 5
        "hooraaaaaaaaaaay"    || 11
        "tourist"             || 1
    }
}

package nov_20_challange.nov22

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "for #input should have #result unique solutions"() {
        expect:
        underTest.uniqueMorseRepresentations(input as String[]) == result

        where:
        input                        || result
        ["gin", "zen", "gig", "msg"] || 2
    }
}

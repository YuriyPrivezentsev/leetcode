package nov_20_challange.nov05

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should have #cost for #chips"() {
        expect:
        underTest.minCostToMoveChips(chips as int[]) == cost

        where:
        chips           || cost
        [2, 2, 2, 3, 3] || 2
        [1, 1000000000] || 1
    }
}

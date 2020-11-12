package nov_20_challange.nov11

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "#isSquare for #p1, #p2, #p3, #p4"() {
        expect:
        underTest.validSquare(p1 as int[], p2 as int[], p3 as int[], p4 as int[]) == isSquare

        where:
        p1            | p2           | p3            | p4            || isSquare
        [0, 0]        | [1, 1]       | [1, 0]        | [0, 1]        || true
        [1134, -2539] | [492, -1255] | [-792, -1897] | [-150, -3181] || true
        [0, 0]        | [0, 0]       | [0, 0]        | [0, 0]        || false
    }
}

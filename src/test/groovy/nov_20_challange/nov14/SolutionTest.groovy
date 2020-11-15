package nov_20_challange.nov14

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "need #pigs for #buckets with #deathTime minutes death time over #time minutes overall time"() {
        expect:
        underTest.poorPigs(buckets, deathTime, time) == pigs

        where:
        buckets | deathTime | time || pigs
        4       | 15        | 15   || 2
        1000    | 10        | 10   || 10
        1000    | 15        | 60   || 5
    }
}

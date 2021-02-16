package nov_20_challange.nov19

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "should produce #result for #input"() {
        expect:
        underTest.decodeString(input) == result

        where:
        input           || result
        "abc"           || "abc"
        "3[a]"          || "aaa"
        "10[b]"         || "bbbbbbbbbb"
        "3[a]2[bc]"     || "aaabcbc"
        "3[a2[c]]"      || "accaccacc"
        "2[abc]3[cd]ef" || "abcabccdcdcdef"
        "abc3[cd]xyz"   || "abccdcdcdxyz"
    }
}

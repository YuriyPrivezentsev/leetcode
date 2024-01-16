package arrays.duplicates_easy

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    @Unroll
    "for #input the unique elements are #expected of length #length"() {
        when:
        int[] testData = input
        int result = underTest.removeDuplicates(testData)

        then:
        result == length

        and:
        for (int i = 0; i < length; i++) {
            testData[i] == expected[i]
        }

        where:
        input                          || expected        | length
        [1, 2]                         || [1, 2]          | 2
        []                             || []              | 0
        [1]                            || [1]             | 1
        [1, 1]                         || [1]             | 1
        [1, 2, 2, 3, 4, 4, 6, 6, 6, 6] || [1, 2, 3, 4, 6] | 5
    }
}

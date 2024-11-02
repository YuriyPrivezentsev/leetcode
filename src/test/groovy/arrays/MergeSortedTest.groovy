package arrays

import spock.lang.Specification
import spock.lang.Unroll

class MergeSortedTest extends Specification {
    def underTest = new MergeSorted()

    @Unroll
    "for arrays #num1 and #num2 should return #result"() {
        given:
        int[] input = num1 as int[]

        when:
        underTest.merge(input, num1Length, num2 as int[], num2Length);
        then:
        Arrays.equals(input, result as int[])
        where:
        num1               | num1Length | num2      | num2Length || result
        [4, 5, 6, 0, 0, 0] | 3          | [1, 2, 3] | 3          || [1, 2, 3, 4, 5, 6]
        [1, 2, 3, 0, 0, 0] | 3          | [2, 5, 6] | 3          || [1, 2, 2, 3, 5, 6]
        [1]                | 1          | []        | 0          || [1]
        [0]                | 0          | [1]       | 1          || [1]
        [2, 2, 0, 0, 0]    | 2          | [2, 2, 2] | 3          || [2, 2, 2, 2, 2]
        [2, 0]             | 1          | [1]       | 1          || [1, 2]

    }
}

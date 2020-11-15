package nov_20_challange.nov12

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution()

    //FIXME: make sane test
    @Unroll
    @Ignore
    "test for #input"() {

        when:
        def unique = new HashSet<>(underTest.permuteUnique(input as int[]))
        def expected = arrToSet(result as int[][])


        then:
        unique == expected

        where:
        input     || result
        [1]       || [[1]]
        [1, 0]    || [[1, 0], [0, 1]]
        [1, 1, 2] || [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    static Set<List<Integer>> arrToSet(int[][] arr) {
        List result = [] as List
        for (int i = 0; i < arr.length; i++) {
            int[] subArr = arr[i]
            List sublist = [] as List
            for (int j = 0; j < subArr.length; j++) {
                sublist.add(subArr[j])
            }
            result.add(subArr)
        }
        result
    }
}

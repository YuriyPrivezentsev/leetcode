package nov_20_challange.nov07

import nov_20_challange.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    def underTest = new Solution();

    @Unroll
    "should add #num1+#num2=#result"() {
        expect:
        listToNum(underTest.addTwoNumbers(numToListNode(num1), numToListNode(num2))) == result

        where:
        num1     | num2      || result
        12       | 24        || 36
        12       | 124       || 136
        123      | 24        || 147
        123      | 28        || 151
        153      | 64        || 217
        157      | 44        || 201
        99       | 1         || 100
        99       | 99        || 198
        70448506 | 993197895 || 1063646401
    }

    static ListNode numToListNode(int num) {
        ListNode result = null
        while (num % 10 > 0 || num / 10 > 0) {
            result = new ListNode(num % 10, result)
            num /= 10;
        }
        result
    }

    static int listToNum(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 10 + head.val
            head = head.next
        }
        return result
    }
}

package nov_20_challange.nov07;

import nov_20_challange.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static int arrayLength(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int length1 = arrayLength(l1);
        int length2 = arrayLength(l2);
        int lengthDiff;
        if (length2 > length1) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
            lengthDiff = length2 - length1;
        } else {
            lengthDiff = length1 - length2;
        }

        ListNode iterator = new ListNode(0);
        ListNode result = iterator;

        List<Integer> increments = new ArrayList<>();
        int counter = 0;
        while (l1 != null) {
            int secondNum;
            if (lengthDiff > 0) {
                secondNum = 0;
            } else {
                secondNum = l2.val;
                l2 = l2.next;
            }

            int sumResult = l1.val + secondNum;
            if (sumResult >= 10) {
                sumResult %= 10;
                increments.add(counter);
                counter = -1;
            }

            iterator.next = new ListNode(sumResult);
            iterator = iterator.next;
            l1 = l1.next;
            lengthDiff--;
            counter++;
        }

        while (!increments.isEmpty()) {
            List<Integer> newIncrements = new ArrayList<>();
            iterator = result;
            counter = 0;
            for (Integer increment : increments) {
                while (increment > 0) {
                    increment--;
                    counter++;
                    iterator = iterator.next;
                }
                int sum = iterator.val + 1;
                if (sum >= 10) {
                    newIncrements.add(--counter);
                    counter = 0;
                    sum %= 10;
                }
                iterator.val = sum;
                iterator = iterator.next;
                counter++;
            }
            increments = newIncrements;
        }

        return result.val != 0 ? result : result.next;
    }

}

package nov_20_challange.nov01;

import nov_20_challange.ListNode;

class Solution {
    public int getDecimalValue(ListNode head) {
        int buffer = 0;
        while(head != null){
            buffer = 2 * buffer + head.val;
            head = head.next;
        }
        return buffer;
    }
}
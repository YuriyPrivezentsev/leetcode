package nov_20_challange.nov02;

import nov_20_challange.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode iterator = head.next;
        ListNode result = head;
        result.next = null;
        while (iterator != null){
            ListNode element = iterator;
            iterator = element.next;
            element.next = null;

            result = insertElement(result,element);
        }
        return result;
    }

    private static ListNode insertElement(ListNode head, ListNode element){
        if(isLess(element, head)){
            element.next = head;
            return element;
        }
        ListNode originalHead = head;
        ListNode next = head.next;
        while(next != null){
            if(isLess(element,next)){
                head.next = element;
                element.next = next;
                return originalHead;
            }
            head = next;
            next = head.next;
        }
        head.next = element;
        return originalHead;
    }

    private static boolean isLess(ListNode left, ListNode right){
        return left.val < right.val;
    }
}

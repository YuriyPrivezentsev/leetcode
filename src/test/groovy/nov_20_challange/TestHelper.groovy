package nov_20_challange

class TestHelper {
    @SuppressWarnings('GroovyAssignabilityCheck')
    static ListNode arr2ListNode(List array) {
        if(array.isEmpty()){
            return array
        }

        List reverse = array.reverse()
        ListNode result = new ListNode(reverse[0])
        for (int i = 1; i < reverse.size(); i++) {
            result = new ListNode(reverse[i], result)
        }
        result
    }

    static def listToArray(ListNode head) {
        def list = new ArrayList()
        while(head != null){
            list.add(head.val)
            head = head.next
        }
        list
    }
}

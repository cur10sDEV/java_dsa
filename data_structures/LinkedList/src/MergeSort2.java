public class MergeSort2 {
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sort(head);
        ListNode right = sort(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode currHead = null;

        if (list1 != null && list2 != null) {
            // first calculate the head of the new sorted list
            if (list1.val < list2.val) {
                currHead = list1;
                list1 = list1.next;
            } else {
                currHead = list2;
                list2 = list2.next;
            }

            ListNode temp = currHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }

            while (list1 != null) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }

            while (list2 != null) {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }

            return currHead;
        } else {
            if (list1 == null) {
                return list2;
            } else {
                return list1;
            }
        }
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}

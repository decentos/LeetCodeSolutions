package linkedlist;

import util.ListNode;

public class M725SplitLinkedListParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int nodesCount = 0;
        ListNode counter = head;
        while (counter != null) {
            nodesCount++;
            counter = counter.next;
        }

        ListNode[] ans = new ListNode[k];
        int index = 0;
        ListNode curr = head;
        while (curr != null) {
            int size = (int) Math.ceil((double) nodesCount / k);
            nodesCount -= size;
            k--;
            ListNode temp = curr;
            ans[index++] = temp;
            while (size > 1) {
                temp = temp.next;
                size--;
            }
            curr = temp.next;
            temp.next = null;
        }
        return ans;
    }
}

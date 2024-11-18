package linkedlist;

import util.RandomNode;

import java.util.HashMap;
import java.util.Map;

public class M138CopyListRandom {

    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> originalToCopy = new HashMap<>();
        RandomNode dummy = new RandomNode(-1);
        RandomNode copyCurr = dummy;
        RandomNode originalCurr = head;

        while (originalCurr != null) {
            copyCurr.next = getCopy(originalToCopy, originalCurr);
            copyCurr.next.random = getCopy(originalToCopy, originalCurr.random);

            copyCurr = copyCurr.next;
            originalCurr = originalCurr.next;
        }
        return dummy.next;
    }

    private RandomNode getCopy(Map<RandomNode, RandomNode> originalToCopy, RandomNode original) {
        if (original == null) {
            return null;
        } else if (originalToCopy.containsKey(original)) {
            return originalToCopy.get(original);
        } else {
            RandomNode copy = new RandomNode(original.val);
            originalToCopy.put(original, copy);
            return copy;
        }
    }


// ===============================================================================

    public RandomNode copyRandomList2(RandomNode head) {
        if (head == null) {
            return null;
        }

        RandomNode original = head;
        while (original != null) {
            RandomNode copy = new RandomNode(original.val);
            copy.next = original.next;
            original.next = copy;
            original = copy.next;
        }

        original = head;
        while (original != null) {
            if (original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }

        RandomNode originalHead = head;
        RandomNode copyHead = head.next;
        RandomNode curr = copyHead;

        while (curr != null) {
            originalHead.next = originalHead.next.next;
            curr.next = curr.next != null ? curr.next.next : null;

            originalHead = originalHead.next;
            curr = curr.next;
        }
        return copyHead;
    }
}

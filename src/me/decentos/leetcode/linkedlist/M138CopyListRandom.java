package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.RandomNode;

import java.util.HashMap;
import java.util.Map;

public class M138CopyListRandom {
    private final Map<RandomNode, RandomNode> map = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        RandomNode oldHead = head;
        RandomNode newHead = new RandomNode(oldHead.val);
        map.put(oldHead, newHead);
        while (oldHead != null) {
            newHead.random = getNode(oldHead.random);
            newHead.next = getNode(oldHead.next);
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        return map.get(head);
    }

    private RandomNode getNode(RandomNode node) {
        if (node == null) return null;
        if (!map.containsKey(node)) {
            map.put(node, new RandomNode(node.val));
        }
        return map.get(node);
    }

    public RandomNode copyRandomList2(RandomNode head) {
        RandomNode newHead = new RandomNode(0);
        RandomNode curr = newHead;
        RandomNode iterator = head;
        while (iterator != null) {
            RandomNode copy = new RandomNode(iterator.val);
            curr.next = copy;
            map.put(iterator, copy);
            curr = curr.next;
            iterator = iterator.next;
        }
        curr = newHead;
        iterator = head;
        while (iterator != null) {
            curr.next.random = map.get(iterator.random);
            curr = curr.next;
            iterator = iterator.next;
        }
        return newHead.next;
    }

    public RandomNode copyRandomList3(RandomNode head) {
        if (head == null) return null;

        RandomNode curr = head;
        while (curr != null) {
            RandomNode copy = new RandomNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        RandomNode oldNode = head;
        RandomNode newNode = head.next;
        RandomNode newHead = head.next;
        while (oldNode != null) {
            oldNode.next = oldNode.next.next;
            newNode.next = newNode.next != null ? newNode.next.next : null;
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }
}

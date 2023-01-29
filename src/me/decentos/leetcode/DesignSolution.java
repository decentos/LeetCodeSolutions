package me.decentos.leetcode;

import me.decentos.leetcode.design.H460LFUCache;

public class DesignSolution {
    public static void main(String[] args) {
//        M707DesignLinkedList head = new M707DesignLinkedList();
//        head.addAtHead(1);
//        head.addAtTail(3);
//        head.addAtIndex(3,2);

//        M707DoublyLinkedList head = new M707DoublyLinkedList();
//        head.addAtHead(7);
//        head.addAtTail(4);
//        head.addAtHead(2);
//        head.addAtHead(1);
//        head.addAtIndex(3,0);
//        head.deleteAtIndex(2);
//        head.addAtHead(6);
//        head.addAtTail(4);
//        head.get(4);
//        head.addAtHead(4);
//        head.addAtIndex(5,0);
//        head.addAtHead(6);
//        DoublyNode head = DoublyNode.createMock();
//        E703KthLargestInStream e703 = new E703KthLargestInStream(3, new int[]{4, 5, 8, 2});
//        e703.add(3);  // return 4
//        e703.add(5);  // return 5
//        e703.add(10); // return 5
//        e703.add(9);  // return 8
//        e703.add(4);  // return 8
        H460LFUCache lfu = new H460LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);     // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}

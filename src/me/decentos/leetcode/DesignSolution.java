package me.decentos.leetcode;

import me.decentos.leetcode.design.E703KthLargestInStream;

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
        E703KthLargestInStream e703 = new E703KthLargestInStream(3, new int[]{4, 5, 8, 2});
        e703.add(3);  // return 4
        e703.add(5);  // return 5
        e703.add(10); // return 5
        e703.add(9);  // return 8
        e703.add(4);  // return 8
    }
}

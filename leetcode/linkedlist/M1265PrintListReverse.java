package linkedlist;

import java.util.Stack;

public class M1265PrintListReverse {

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        ImmutableListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.getNext();
        }
        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }

    public void printLinkedListInReverse2(ImmutableListNode head) {
        ImmutableListNode last = null;
        while (head != last) {
            ImmutableListNode temp = head;
            while (temp.getNext() != last) {
                temp = temp.getNext();
            }
            temp.printValue();
            last = temp;
        }
    }
}

interface ImmutableListNode {
    void printValue();
    ImmutableListNode getNext();
}

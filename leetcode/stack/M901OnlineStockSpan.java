package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M901OnlineStockSpan {

    private final Deque<Span> stack;

    public M901OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek().price) {
            span += stack.poll().span;
        }
        stack.push(new Span(price, span));
        return span;
    }

    private record Span(int price, int span) {}
}

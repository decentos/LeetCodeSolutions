package design;

import java.util.LinkedList;
import java.util.List;

public class M1472DesignBrowserHistory {
    private final List<String> history;
    private int index;
    private int size;

    public M1472DesignBrowserHistory(String homepage) {
        history = new LinkedList<>();
        index = 0;
        size = 1;
        history.add(homepage);
    }

    public void visit(String url) {
        index++;
        history.add(index, url);
        size = index + 1;
        // history.subList(index + 1, history.size()).clear();
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return history.get(index);
    }

    public String forward(int steps) {
        index = Math.min(size - 1, index + steps);
        return history.get(index);
    }
}

package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class H642DesignSearchSystem {
    private final TrieNode root;
    private TrieNode tempNode;
    private final StringBuilder input;
    private boolean notFound;

    public H642DesignSearchSystem(String[] sentences, int[] times) {
        root = buildTrie(sentences, times);
        tempNode = root;
        input = new StringBuilder();
        notFound = false;
    }

    public List<String> input(char c) {
        if (c == '#') {
            tempNode = root;
            notFound = false;
            addNode(input);
            return Collections.emptyList();
        }
        input.append(c);
        if (notFound || !tempNode.map.containsKey(c)) {
            notFound = true;
            return Collections.emptyList();
        }

//        Queue<TrieNode> sortedOutput = new PriorityQueue<>((a, b) -> a.times != b.times ? b.times - a.times : a.word.compareTo(b.word));
        Queue<TrieNode> sortedOutput = new PriorityQueue<>(); // using class comparator
        tempNode = tempNode.map.get(c);
        search(sortedOutput, tempNode);

        List<String> output = new ArrayList<>();
        while (!sortedOutput.isEmpty() && output.size() < 3) output.add(sortedOutput.poll().word);
        return output;
    }

    private void search(Queue<TrieNode> output, TrieNode node) {
        if (node.word != null) output.offer(node);

        for (char c : node.map.keySet()) {
            search(output, node.map.get(c));
        }
    }

    private void addNode(StringBuilder input) {
        TrieNode temp = root;
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            Map<Character, TrieNode> tempMap = temp.map;
            if (!tempMap.containsKey(curr)) {
                tempMap.put(curr, new TrieNode());
            }
            temp = tempMap.get(curr);
        }
        if (temp.word == null) {
            temp.word = input.toString();
            temp.times = 1;
        } else {
            temp.times++;
        }
        input.setLength(0);
    }

    private TrieNode buildTrie(String[] sentences, int[] times) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            TrieNode temp = root;
            String word = sentences[i];
            for (char c : word.toCharArray()) {
                Map<Character, TrieNode> tempMap = temp.map;
                if (!tempMap.containsKey(c)) {
                    tempMap.put(c, new TrieNode());
                }
                temp = tempMap.get(c);
            }
            temp.word = word;
            temp.times = times[i];
        }
        return root;
    }

    private static class TrieNode implements Comparable<TrieNode> {
        int times;
        String word;
        final Map<Character, TrieNode> map;

        public TrieNode() {
            times = 0;
            word = null;
            map = new HashMap<>();
        }

        @Override
        public int compareTo(TrieNode o) {
            if (times == o.times) return word.compareTo(o.word);
            return o.times - times;
        }
    }
}

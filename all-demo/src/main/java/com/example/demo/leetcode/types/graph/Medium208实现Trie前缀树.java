package com.example.demo.leetcode.types.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author zaochun.zjw
 * @date 2024/3/14
 */
public class Medium208实现Trie前缀树 {

    Map<String, Boolean> hash;

    Map<String, Boolean> stringBooleanMap;

    public Medium208实现Trie前缀树() {
        hash = new HashMap<>();
        stringBooleanMap = new HashMap<>();
    }

    public void insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            stringBooleanMap.put(word.substring(0, i+1), true);
        }
        hash.put(word, true);
    }

    public boolean search(String word) {
        return hash.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        return stringBooleanMap.containsKey(prefix);
    }
}

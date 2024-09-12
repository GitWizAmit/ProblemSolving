package main.java.leetcode;

import java.util.Set;
import java.util.stream.Collectors;

public class ConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int consistentCount = 0;
        Set<Character> set = allowed.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        for (int i = 0; i < words.length; ++i) {
            boolean isConsistent = true;
            for (char ch : words[i].toCharArray()) {
                if (!set.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                consistentCount++;
            }
        }

        return consistentCount;
    }
}

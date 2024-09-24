package main.java.leetcode;

public class LongestCommonPrefixTrie {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        trie.insert(arr2);

        int ans = 0;
        for (int num : arr1) {
            ans = Math.max(ans, trie.search(num));
        }
        return ans;
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isEndOfNumber;

    public TrieNode() {
        children = new TrieNode[10];
        isEndOfNumber = false;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(int[] numbers) {
        for (int num : numbers) {
            char[] charArr = String.valueOf(num).toCharArray();
            TrieNode child = root;
            for (char ch : charArr) {
                int val = ch - '0';
                if (child.children[val] == null) {
                    child.children[val] = new TrieNode();
                }
                child = child.children[val];
            }
            child.isEndOfNumber = true;
        }
    }

    public int search(int num) {
        int commonPrefixLength = 0;
        char[] charArr = String.valueOf(num).toCharArray();
        TrieNode ref = root;
        for (char ch : charArr) {
            int val = ch - '0';
            if (ref.children[val] == null) {
                return commonPrefixLength;
            }
            commonPrefixLength++;
            ref = ref.children[val];
        }
        return commonPrefixLength;
    }
}

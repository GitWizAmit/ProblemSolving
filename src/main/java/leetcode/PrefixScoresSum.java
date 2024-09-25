package main.java.leetcode;

public class PrefixScoresSum {
    public int[] sumPrefixScores(String[] words) {
        int[] prefixScores = new int[words.length];
        Trie trie = new Trie();
        trie.insert(words);

        int k = 0;
        for (String word : words) {
            prefixScores[k++] = trie.search(word);
        }
        return prefixScores;
    }

    // inner class
    private class TrieNode {
        TrieNode[] children;
        int prefixCount;

        public TrieNode() {
            children = new TrieNode[26];
            prefixCount = 0;
        }
    }

    // inner class
    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String[] words) {
            for (String word : words) {
                char[] charArray = word.toCharArray();
                TrieNode node = root;
                for (char ch : charArray) {
                    int idx = ch - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new TrieNode();
                    }
                    node = node.children[idx];
                    node.prefixCount++;
                }
            }
        }

        public int search(String word) {
            int count = 0;

            char[] charArray = word.toCharArray();
            TrieNode node = root;
            for (char ch : charArray) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return count;
                }
                node = node.children[idx];
                count += node.prefixCount;
            }
            return count;
        }
    }
}

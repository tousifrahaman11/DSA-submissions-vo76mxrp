class WordDictionary {

    class TrieNode {
        TrieNode[] child;
        boolean end;

        TrieNode() {   // FIXED: constructor name
            child = new TrieNode[26];
            end = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            node = node.child[idx];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) {
            return node.end;
        }

        char c = word.charAt(i);

        if (c == '.') {
            for (TrieNode childNode : node.child) {
                if (childNode != null && dfs(word, i + 1, childNode)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.child[c - 'a'] == null) {
                return false;
            }
            return dfs(word, i + 1, node.child[c - 'a']);
        }
    }
}
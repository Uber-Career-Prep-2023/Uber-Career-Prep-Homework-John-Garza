import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Time: O(N) where N is len(word)
    // Space: O(N) where N is len(word)
    public void insert(String word) {
        verifyWord(word);

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = verifyLetter(word.charAt(i));

            // Retrieve the next node.
            TrieNode childNode = curr.children.computeIfAbsent(
                    letter,
                    a -> new TrieNode());
            // Increment the number of words in this trie.
            curr.words++;
            curr = childNode;
        }
        if (curr.validWord) {
            throw new IllegalArgumentException("Word already existed in trie.");
        }
        curr.validWord = true;
    }

    // Time: O(N) where N is len(word)
    // Space: O(1)
    public boolean isValidWord(String word) {
        verifyWord(word);

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = verifyLetter(word.charAt(i));

            if (!curr.children.containsKey(letter)) {
                for (int j = i + 1; j < word.length(); j++) {
                    verifyLetter(word.charAt(j));
                }
                return false;
            }
            // Retrieve and move to the next node.
            curr = curr.children.get(letter);
        }
        return curr.validWord;
    }

    // Time: O(N)
    // Time: O(1)
    public void remove(String word) {
        verifyWord(word);

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = verifyLetter(word.charAt(i));
            if (!curr.children.containsKey(letter)) {
                throw new IllegalArgumentException("Word does not exist in the trie.");
            }
            TrieNode child = curr.children.get(letter);
            curr.words--;
            if (child != root && child.words <= 1) {
                curr.children.remove(letter);
            }
            curr = child;
        }
        if (!curr.validWord) {
            throw new IllegalArgumentException("Cannot remove a word which is not in the trie.");
        }
    }

    // Time: O(1)
    // Space: O(1)
    private Character verifyLetter(Character letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Words can only contain letters.");
        }
        // If letter is uppercase, convert it to lowercase.
        return Character.toLowerCase(letter);
    }

    // Time: O(1)
    // Space: O(1)
    private void verifyWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Words cannot be null.");
        }
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Words cannot be empty.");
        }
        if (word.isBlank()) {
            throw new IllegalArgumentException("Words cannot be blank.");
        }
    }

    // Subclass
    private class TrieNode {
        private int words;
        public boolean validWord;
        public Map<Character, TrieNode> children;

        TrieNode() {
            words = 0;
            validWord = false;
            children = new HashMap<>();
        }
    }
}
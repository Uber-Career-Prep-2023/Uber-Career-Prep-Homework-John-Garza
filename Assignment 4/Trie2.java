import java.util.HashMap;
import java.util.Map;

public class Trie2 {
    public static TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        verifyWord(word);

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            // Verify the letter and convert it to lowercase if necessary.
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

    public boolean isValidWord(String word) {
        verifyWord(word);

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            // verify the letter and convert it to lowercase if necessary.
            char letter = verifyLetter(word.charAt(i));

            if (!curr.children.containsKey(letter)) {
                // Verify the rest of the word.
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

    public void remove(String word) {
        verifyWord(word);

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            // verify the letter and convert it to lowercase if necessary.
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

    // Helper Functions
    private Character verifyLetter(Character letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Words can only contain letters.");
        }
        // If uppercase, convert to lowercase.
        return Character.toLowerCase(letter);
    }

    // Verifies if the given word is a valid word.
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

    // Sub class
    public static class TrieNode {
        private int words; // counter to track the number of words ending at this node.
        public boolean validWord; // Indicates if this node marks the end of a valid word.
        public Map<Character, TrieNode> children; // tracks child nodes.

        TrieNode() {
            words = 0;
            validWord = false;
            children = new HashMap<>();
        }
    }
}
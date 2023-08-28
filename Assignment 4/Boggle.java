
// Technique: Trie as parameter
// Time: O(m * n) where m is number of rows and n is number of rows
// Space: O(n) where n is length of all of the words
import java.util.*;

public class Boggle {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'D', 'E' },
                { 'R', 'C', 'P' },
                { 'L', 'A', 'Y' }
        };

        String[] words = { "Ace", "Lay", "Gape" };

        List<String> expected = Arrays.asList("Ace", "Lay");
        System.out.println(expected.equals(boggle(board, words)));

        char[][] board2 = {
                { 'A', 'D', 'E' },
                { 'R', 'C', 'P' },
                { 'L', 'A', 'Y' }
        };

        // The sample provided was missing the word "Race".
        String[] words2 = {
                "Ace", "Gape", "Mace",
                "Ape", "Grape", "Map",
                "Cape", "Lace", "May",
                "Clap", "Lap", "Pace",
                "Clay", "Lay", "Pay",
                "Rap", "Tape", "Tray",
                "Ray", "Trace", "Yap",
                "Race", "Tap", "Trap"
        };

        List<String> expected2 = Arrays.asList(
                "Ace", "Lay", "Clap",
                "Race", "Clay", "Ape",
                "Pace", "Ray", "Cape",
                "Lace", "Lap", "Yap",
                "Pay", "Rap");
        Collections.sort(expected2);
        List<String> res = boggle(board2, words2);
        Collections.sort(res);
        System.out.println(expected2.equals(res));
    }

    public static List<String> boggle(char[][] board, String[] words) {
        if (board == null || words == null)
            return null;

        List<String> validWords = new ArrayList<>();
        if (board.length == 0)
            return validWords;
        Trie2 trie = new Trie2();

        for (String word : words) {
            if (word == null || word.length() < 3)
                continue;
            trie.insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, rows, cols, Trie2.root, new StringBuilder(), validWords);
            }
        }
        return validWords;
    }

    private static void dfs(char[][] board, int i, int j, int ROWS, int COLS, Trie2.TrieNode node, StringBuilder sb,
            List<String> validWords) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || node == null || board[i][j] == '#')
            return;

        if (node.validWord) {
            node.validWord = false;
            validWords.add(sb.toString());
        }

        char letter = verifyLetter(board[i][j]);
        if (!node.children.containsKey(letter)) {
            return;
        }
        Trie2.TrieNode child = node.children.get(letter);
        if (sb.length() == 0)
            sb.append(Character.toUpperCase(letter));
        else
            sb.append(letter);

        board[i][j] = '#';

        dfs(board, i - 1, j, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i + 1, j, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i, j - 1, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i, j + 1, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i + 1, j + 1, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i - 1, j - 1, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i - 1, j + 1, ROWS, COLS, child, new StringBuilder(sb), validWords);
        dfs(board, i + 1, j - 1, ROWS, COLS, child, new StringBuilder(sb), validWords);
        board[i][j] = Character.toUpperCase(letter);
    }

    private static Character verifyLetter(Character letter) {
        if (!Character.isLetter(letter))
            throw new IllegalArgumentException("Not a letter.");

        return Character.toLowerCase(letter);
    }
}
// Time Taken: 1 hr
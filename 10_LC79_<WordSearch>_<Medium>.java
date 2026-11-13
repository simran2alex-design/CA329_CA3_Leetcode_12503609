class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (search(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index) {
        // We matched every letter in the word
        if (index == word.length()) {
            return true;
        }

        // Stop if outside the board or the letter does not match
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        char savedLetter = board[row][col];
        board[row][col] = '#'; // Mark this cell as used

        boolean found =
            search(board, word, row + 1, col, index + 1) || // down
            search(board, word, row - 1, col, index + 1) || // up
            search(board, word, row, col + 1, index + 1) || // right
            search(board, word, row, col - 1, index + 1);   // left

        board[row][col] = savedLetter; // Restore the cell
        return found;
    }
}

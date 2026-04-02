// Jack Grace - 101577863
// Philip Fredeluces - 101576305
// Thi Tuyet Nhung Huynh - 101522902
// Annika Duggal - 101574406
// Shayne Atkins - 101572148

public class Board {
    private char[][] board;

    // Initializes the plain board
    public Board() {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /**
     * 
     * @param row Row value
     * @param col Column value
     * @return Whether or not square is playable
     */
    public boolean isPlayable(int row, int col) {
        return board[row][col] == '-';
    }

    /**
     * 
     * @param row Row value
     * @param col Column value
     * @param player Char value of player symbol [X or O]
     * @return True if move was sucessful
     */
    public boolean makeMove(int row, int col, char player) {
        if (isPlayable(row, col)) {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    /**
     * Reset the square at postition [row, column] back to defulat "-"
     * @param row row value
     * @param col column value
     */
    public void undoMove(int row, int col) {
        board[row][col] = '-';
    }

    public boolean horizontalWin(char symbol) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean verticalWin(char symbol) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean diagonalWin(char symbol) {
        //Top left to bottom right
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        // Top right to bottom left
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    //check all win conditions at once
    public boolean hasWon(char symbol) {
        return horizontalWin(symbol) || verticalWin(symbol) || diagonalWin(symbol);
    }

    //check for draw (ie full board)
    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;  //still an empty cell (can't be draw)
                }
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("    1   2   3");
        System.out.println("  -------------");
        for (int row = 0; row < 3; row++) {
            System.out.print((row + 1) + " |");
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + board[row][col] + " |");
            }
            System.out.println();
            System.out.println("  -------------");
        }
    }
}

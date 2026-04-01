import java.util.Scanner;

public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // Check if a cell is available to play
    public boolean isPlayable(int row, int col) {
        return board[row][col] == '-';
    }

    //Place symbol on the board, return true if successful
    public boolean makeMove(int row, int col, char symbol) {
        if (isPlayable(row, col)) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void promptAndPlaceMove(String playerName, char symbol, Scanner scanner) {
        int row = -1;
        int col = -1;
        boolean placed = false;

        while (!placed) {
            System.out.println(playerName + " (" + symbol + "), enter your move.");

            row = promptCoordinate("Row (1-3): ", scanner) - 1;   //convert to 0 index
            col = promptCoordinate("Column (1-3): ", scanner) - 1;

            if (!isInBounds(row, col)) {
                System.out.println("Please enter row and column values between 1 and 3.");
            } else if (!isPlayable(row, col)) {
                System.out.println("That cell is taken. Choose an empty cell.");
            } else {
                makeMove(row, col, symbol);
                placed = true;
            }
        }
    }

    private int promptCoordinate(String prompt, Scanner scanner) {
        int value = -1;
        while (value < 1 || value > 3) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value < 1 || value > 3) {
                    System.out.println("Invalid input. Enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 and 3.");
            }
        }
        return value;
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    // Win checks
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
    public boolean isDraw() {
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
    public void undoMove(int row, int col) {
        board[row][col] = '-';
    }
}

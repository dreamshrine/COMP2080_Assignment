public class Board {
    static char[][] board;

    public Board(){
        board = new char[3][3];
    }

    public boolean isPlayable(int row, int col){
        return board[row][col] == '\0';
    }

    public boolean makeMove(int row, int col, char team){
        if (isPlayable(row, col)){
            board[row][col] = team;
            return true;
        }
        return false;
    }

    public boolean horiontalWin(char team){
        for (int row = 0; row < 3; row++){
            if (board[row][0] == team && board[row][1] == team && board[row][2] == team){
                return true;
            }
        }
        return false;
    }

    public boolean verticalWin(char team){
        for (int col = 0; col < 3; col++){
            if (board[0][col] == team && board[1][col] == team && board[2][col] == team){
                return true;
            }
        }
        return false;
    }

    // TODO: diagonal win function that checks both diagonal win conditions
    public boolean diagonalWin(char team){
        return false;
    }

    public void printBoard(){
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                System.out.print("[" + board[row][col] + "]");
            }
            System.out.println();
        }
    }
}

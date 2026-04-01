public class Board {
    static String[][] board;

    public Board(){
        board = new String[][]
        {
        {null, null, null},
        {null, null, null},
        {null, null, null}
        };
    }

    public boolean isPlayable(int row, int col){
        if (board[row][col] == null){
            return true;
        }
        return false;
    }

    public boolean makeMove(int row, int col, String team){
        if (isPlayable(row, col)){
            board[row][col] = team;
            return true;
        }
        return false;
    }

    public boolean horiontalWin(String team){
        for (int row = 0; row < 3; row++){
            if (board[row][0] == team && board[row][1] == team && board[row][2] == team){
                return true;
            }
        }
        return false;
    }

    public boolean verticalWin(String team){
        for (int col = 0; col < 3; col++){
            if (board[0][col] == team && board[1][col] == team && board[2][col] == team){
                return true;
            }
        }
        return false;
    }

    // TODO: diagonal win function that checks both diagonal win conditions
    public boolean diagonalWin(String team){
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

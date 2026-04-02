// Jack Grace - 101577863
// Philip Fredeluces - 101576305
// Thi Tuyet Nhung Huynh - 101522902
// Annika Duggal - 101574406
// Shayne Atkins - 101572148

public class Minimax {

    private Minimax() {

    }

    static int minimax(Board minimax_board, int depth, boolean is_maximizing, char aiSymbol, char humanSymbol)
    {
        // Terminal states: +1 favours AI (win), -1 favours human (loss), 0 is neutral (draw)
        if (minimax_board.hasWon(aiSymbol)){
            return 1;
        }
        else if (minimax_board.hasWon(humanSymbol)){
            return -1;
        }
        else if (minimax_board.isBoardFull()){
            return 0;
        }

        int bestScore;
        
        // This simulates alternating players and is used to predict what the opponent is going to do.
        // When maximizing the AI is simulating the best move it could make to, inversely, when minimizing the AI is simulating the best move the opponent can make.
        // Then based off that it can make the best move for itself. This occurs recursively.
        /**
         * The algorithm looks into the "future" under the assumption that during the opponents turn they are going to try and maximize their outcome based on the provided gamestate.
         * Under that assumption the AI can simulate what the opponent will do and therefore find the best possible set of moves. Win, Lose, and draw conditions are quantified where a postitive score is a win.
         * The minimax algorithm takes a heuristic approach playing in a manner that maximizes this positive win condition. If a win is not possible it will play for the draw since 0 is greater than or
         * more positive than -1 (a loss)
         *
         */
        if (is_maximizing){
            bestScore = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if(minimax_board.makeMove(row, col, aiSymbol)){
                        int score = minimax(minimax_board, depth + 1, false, aiSymbol, humanSymbol);
                        minimax_board.undoMove(row, col);
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++){
                for (int col = 0; col < 3; col++){
                    if(minimax_board.makeMove(row, col, humanSymbol)){
                        int score = minimax(minimax_board, depth + 1, true, aiSymbol, humanSymbol);
                        minimax_board.undoMove(row, col);
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;
    }

    /**
     * 
     * @param board This board in which the game is taking place
     * @param aiSymbol The symbol of the AI (O or X)
     * @return The coordinates [row, column] for the best possible move
     */
    static int[] getBestMove(Board board, char aiSymbol) 
    {   

        char humanSymbol = (aiSymbol == 'X') ? 'O' : 'X';

        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;

        // Loops through every valid move in the current game state, plays that move, quantifies the final outcome, undoes the move, and chooses the move with the best outcome in favour of the AI
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if(board.makeMove(row, col, aiSymbol)){
                    int moveValue = minimax(board, 0, false, aiSymbol, humanSymbol);
                    board.undoMove(row, col);
                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }  
        }

        return bestMove;
    }
}

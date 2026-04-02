// Jack Grace - 101577863
// Philip Fredeluces - 101576305
// Thi Tuyet Nhung Huynh - 101522902
// Annika Duggal - 101574406
// Shayne Atkins - 101572148

import java.util.Scanner;

public class GameSetup {
    static Scanner scanner = new Scanner(System.in);

    static void setupTwoPlayer() {
        Board board = new Board();
        System.out.print("Player 1, please enter your name: ");
        String name1 = scanner.nextLine().trim();

        char symbol1 = promptSymbol(name1);
        char symbol2 = (symbol1 == 'X') ? 'O' : 'X';

        System.out.print("Player 2, please enter your name: ");
        String name2 = scanner.nextLine().trim();
        System.out.println(name2 + ", your symbol is: " + symbol2);

        // Determines the symbol of the player depending on the choice of the first player
        // Whatever the first player chooses, the second player has to be the remaining symbol
        String firstPlayer = (symbol1 == 'X') ? name1 : name2;
        char firstSymbol = 'X';
        String secondPlayer = (symbol1 == 'O') ? name1 : name2;
        char secondSymbol = 'O';

        board.printBoard();

        String[] names = {firstPlayer, secondPlayer};
        char[] symbols = {firstSymbol, secondSymbol};
        int turn = 0;

        // game loop
        while (true) {
            // Prompts each player for the desired X or O placements. Once played check win conditions. Efficiency Note: Refer to setupOnePlayer()
            promptAndPlaceMove(names[turn], symbols[turn], board);
            board.printBoard();

            if (board.hasWon(symbols[turn])) {
                System.out.println(names[turn] + " wins!");
                break;
            } else if (board.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            turn = (turn + 1) % 2;  //alternates
        }
    }

    static void setupOnePlayer() 
    {
        Board board = new Board();
        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine().trim();

        // Depending on the choice of the human player, the AI will be assigned the other symbol
        char playerSymbol = promptSymbol(playerName);
        char aiSymbol = (playerSymbol == 'X') ? 'O' : 'X';

        System.out.println("Computer's symbol is: " + aiSymbol);

        boolean playerGoesFirst = (playerSymbol == 'X');
        System.out.println(playerGoesFirst
                ? "\nYou (X) go first!"
                : "\nComputer (X) goes first!");

        // game loop
        int turn = 0;
        char[] symbols = {'X', 'O'};

        while (true) {

            char currentSymbol = symbols[turn];
 
            if (currentSymbol == playerSymbol) {
                board.printBoard();
                promptAndPlaceMove(playerName, playerSymbol, board);
            } else {
                System.out.println("Computer is thinking...");
                playAI(aiSymbol, board);
            }

            // After every move does with by the human player or the computer. Win conditions need to be checked.
            // Interestingly, to save on resources. A win or loss will not occur until a minimum of 5 turns took place. So we don't necessarily need to check the win conditions untill after turn 4.
            // Just a efficiency thought no need to proceed with implementation
            if (board.hasWon(playerSymbol)) {
                board.printBoard();
                System.out.println(playerName + " wins!");
                break;
            } else if (board.hasWon(aiSymbol)) {
                board.printBoard();
                System.out.println("AI wins!");
                break;
            }else if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            turn = (turn + 1) % 2;  //alternates turns
        }
    }

    /** Finds the best move based on the current board gamestate
     * @param symbol Play symbol of the computer
     * @param board The current board game state
     */
    static void playAI(char symbol, Board board){
        int [] move = Minimax.getBestMove(board, symbol);

        int row = move[0];
        int col = move[1];

        board.makeMove(row, col, symbol);

    }

    // --- Helper Functions ---

    static char promptSymbol(String playerName) 
    {
        char symbol = ' ';
        while(symbol != 'X' && symbol != 'O') {
            System.out.print(playerName + ", choose your symbol (X or O): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if(input.equals("X") || input.equals("O")) {
                symbol = input.charAt(0);
            }else{
                System.out.println("Invalid choice. Please enter X or O: ");
            }
        }
        return symbol;
    }

    static void promptAndPlaceMove(String playerName, char symbol, Board board) {
        int row = -1;
        int col = -1;
        boolean placed = false;

        while (!placed) {
            System.out.println(playerName + " (" + symbol + "), enter your move.");

            row = promptCoordinate("Row (1-3): ", scanner) - 1;   //convert to 0 index
            col = promptCoordinate("Column (1-3): ", scanner) - 1;

            if (!isInBounds(row, col)) {
                System.out.println("Please enter row and column values between 1 and 3.");
            } else if (!board.isPlayable(row, col)) {
                System.out.println("That cell is taken. Choose an empty cell.");
            } else {
                board.makeMove(row, col, symbol);
                placed = true;
            }
        }
    }

    static int promptCoordinate(String prompt, Scanner scanner) 
    {
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

    static boolean isInBounds(int row, int col)
    {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
    
}

import java.util.Scanner;

//Shayne Atkins
public class GameSetup {
    static Scanner scanner = new Scanner(System.in);

    static void setupTwoPlayer() {
        System.out.print("Player 1, please enter your name: ");
        String name1 = scanner.nextLine().trim();

        char symbol1 = promptSymbol(name1);
        char symbol2 = (symbol1 == 'X') ? 'O' : 'X';

        System.out.print("Player 2, please enter your name: ");
        String name2 = scanner.nextLine().trim();
        System.out.println(name2 + ", your symbol is: " + symbol2);

        String firstPlayer = (symbol1 == 'X') ? name1 : name2;
        char firstSymbol = 'X';
        String secondPlayer = (symbol1 == 'O') ? name1 : name2;
        char secondSymbol = 'O';

        Board board = new Board();
        board.printBoard();

        // game loop
        String[] names = {firstPlayer, secondPlayer};
        char[] symbols = {firstSymbol, secondSymbol};
        int turn = 0;

        while (true) {
            board.promptAndPlaceMove(names[turn], symbols[turn], scanner);
            board.printBoard();

            if (board.hasWon(symbols[turn])) {
                System.out.println(names[turn] + " wins!");
                break;
            } else if (board.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            turn = (turn + 1) % 2;  //alternates
        }
    }

    static void setupOnePlayer() {
        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine().trim();

        char playerSymbol = promptSymbol(playerName);
        char aiSymbol = (playerSymbol == 'X') ? 'O' : 'X';

        System.out.println("Computer's symbol is: " + aiSymbol);

        boolean playerGoesFirst = (playerSymbol == 'X');
        System.out.println(playerGoesFirst
                ? "\nYou (X) go first!"
                : "\nComputer (X) goes first!");

        Board board = new Board();
        board.printBoard();
    }

    static char promptSymbol(String playerName) {
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
}

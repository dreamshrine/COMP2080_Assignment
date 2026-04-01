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
        System.out.print(name2 + ", your symbol is: " + symbol2);

        String firstPlayer = (symbol1 == 'X') ? name1 : name2;
        char firstSymbol = 'X';
        String secondPlayer = (symbol1 == 'O') ? name1 : name2;
        char secondSymbol = 'O';
    }

    static void setupOnePlayer() {}

    static char promptSymbol(String playerName) {
        char symbol = ' ';
        return symbol;
    }

    static char[][] initBoard() {
        char[][] board = new char[3][3];
        return board;
    }
}

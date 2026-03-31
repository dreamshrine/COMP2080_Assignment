public class Main {
    public static void main(String[] args) throws Exception {
        Board b = new Board();
        b.makeMove(0, 0, "X");
        b.makeMove(1, 0, "O");
        b.makeMove(2, 0, "X");
        b.printBoard();

        System.out.println("Horzontal Win: " + b.horiontalWin("X"));
        System.out.println("Vertical Win: " + b.verticalWin("X"));
    }
}
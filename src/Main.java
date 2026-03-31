public class Main {
    public static void main(String[] args) throws Exception {
        Board b = new Board();
        b.makeMove(0, 0, "X");
        b.makeMove(1, 0, "O");
        b.makeMove(2, 0, "X");
        b.printBoard();

        System.out.println("Horzontal Win: " + b.horiontalWin("X"));
        System.out.println("Vertical Win: " + b.verticalWin("X"));


        // Main Menu Logic
        // This will most likely call the functions HumanVSHuman() or HumanVSComp() which will be located in another class
        // Contained in a while loop
    }
}
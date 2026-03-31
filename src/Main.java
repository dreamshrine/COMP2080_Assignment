public class Main {
    //Shayne Atkins
    public static void main(String[] args) {
        System.out.println("=== Welcome to Tic-Tac-Toe ===");
        System.out.println("1. 2-Player Game");
        System.out.println("2. 1-Player Game(Vs. AI)");
        System.out.print("Select Mode (1 or 2): ");

        int mode = 0;
        while (mode != 1 && mode != 2){
            try {
                mode = Integer.parseInt(GameSetup.scanner.nextLine().trim());
                if (mode != 1 && mode != 2)
                    System.out.print("Invalid input. Enter 1 or 2: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter 1 or 2: ");
            }
        }

        if (mode == 1) {
            GameSetup.setupTwoPlayer();
        }else{
            GameSetup.setupOnePlayer();
        }
    }
}
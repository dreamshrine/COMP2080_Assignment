public class Main {
    //Shayne Atkins
    public static void main(String[] args) {
        System.out.println("=== Welcome to Tic-Tac-Toe ===");
        System.out.println("1. 2-Player Game");
        System.out.println("2. 1-Player Game(Vs. AI)");
        System.out.println("3. Exit");
        System.out.print("Select Mode (1, 2, or 3): ");

        int mode = 0;
        while(mode != 1 && mode != 2 && mode != 3) {
            try {
                mode = Integer.parseInt(GameSetup.scanner.nextLine().trim());
                if (mode != 1 && mode != 2 && mode != 3)
                    System.out.print("Invalid input. Enter 1, 2, or 3: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter 1, 2, or 3: ");
            }
        }

        if(mode == 1) {
            GameSetup.setupTwoPlayer();
        }else if(mode == 2){
            GameSetup.setupOnePlayer();
        }else{
            System.out.println("Thank you so much for playing my game!");
            GameSetup.scanner.close();
        }
    }
}
// Jack Grace - 101577863
// Philip Fredeluces - 101576305
// Thi Tuyet Nhung Huynh - 101522902
// Annika Duggal - 101574406
// Shayne Atkins - 101572148

public class Main {
    //Shayne Atkins
    public static void main(String[] args) {
        while (true){
            System.out.println("=== Welcome to Tic-Tac-Toe ===");
            System.out.println("A. 2-Player Game");
            System.out.println("B. 1-Player Game(Vs. AI)");
            System.out.println("C. Exit Game");
            System.out.print("Select Mode (A, B, C): ");

            char mode = '\0';

            while(mode != 'A' && mode != 'B' && mode != 'C') {
                mode = Character.toUpperCase(GameSetup.scanner.nextLine().charAt(0));
                if (mode != 'A' && mode != 'B' && mode != 'C')
                    System.out.print("Invalid input. Enter A, B or C: ");

                if(mode == 'A') {
                    GameSetup.setupTwoPlayer();
                }else if (mode == 'B'){
                    GameSetup.setupOnePlayer();
                } else if (mode == 'C'){
                    System.exit(0);
                }
            } 
            while (true) 
            {
                System.out.print("Would you like to play again? (Y/N): ");
            char answer = Character.toUpperCase(GameSetup.scanner.nextLine().charAt(0));
            if (answer == 'Y')
            {
                break;
            } else if (answer == 'N')
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid input. Enter Y or N");
            }

            }
            
        }
    }
}
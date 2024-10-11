import java.util.Scanner;

public abstract class Game {

    Scanner scanner = new Scanner(System.in);
    //    protected = can be reached in Board class
    boolean win;

    public Game() {
        win = false;
        scanner = new Scanner(System.in);
    }

    //    Refactor the old "restartInvite" method, seems to work
    public void askForRematch() {
        System.out.println("Do you want a rematch? (yes/no)");
        String answer = scanner.nextLine().trim();
        if (answer.equals("yes")) {
            resetGame();
        } else {
            System.out.println("Thank you for playing, see ya!");
//            Exits really the game, easier than making several if statements.
            System.exit(0);
        }
    }

    protected void resetGame() {
        win = false; // reset win condition
    }
}

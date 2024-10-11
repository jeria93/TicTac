import javax.swing.*;
import java.util.Scanner;

public class Board extends Game {

    private String player1;
    private String player2;
    //    Board
    private char[][] board;
    //    To keep track of selected row, 1-9 ->
    private int rows;
    //    To keep track of selected columns, 1-9, it's a 2D array ↓
    private int cols;

    //    Constructor - give all the types "ready to start values"
    public Board() {
        super();
        board = new char[3][3]; //3x3 simulated board
//        Loops the rows in the 2d array ->
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '-';
            } // Loops the columns of the 2d array field ↓

        }
    }

    private void boardIsDisplayed() {

        System.out.println("Lets play");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println(); //If not inserted console shows -------------
        }
        System.out.println();
    }

    private void instructionBoard() {
        System.out.println("| 0,0 | 0,1 | 0,2 |");
        System.out.println("| 1,0 | 1,1 | 1,2 |");
        System.out.println("| 2,0 | 2,1 | 2,2 |");
    }


    public void startGame() {

//        Should be working in main
        System.out.println("Welcome to the ticktacktoe game, press enter to read and understand the rules");
        scanner.nextLine();
//        Positioning explained
        System.out.println("""
                Choose a number (0-1-2) that represents either a row or column to put X or O
                0 represents the upper left row corner. 0 also represents the upper left corner column, now choose wisely
                """);
        instructionBoard();
        System.out.println();
        System.out.println("Enter player 1 name please");
        player1 = scanner.nextLine();
        System.out.println("Enter player 2 name please");
        player2 = scanner.nextLine();
        boardIsDisplayed();

        while (true) {
            playerTurn(player1);
            if (win) {
                if (!rematch()) {
                    System.out.println("thanks for playing");
                    break;
                }
                resetGame();
            }
            playerTurn(player2);
            if (win) {
                if (!rematch()) {
                    System.out.println("thanks for playing");
                    break;
                }
                resetGame();
            }
        }
    }

    public void playerTurn(String player) {

        while (true) {
            System.out.println("Player " + player + " turn");

            // Checks row input
            int rows = -1;
            while (rows < 0 || rows > 2) {
                System.out.println(player + ", pick a row (0-2)");
                String rowInput = cleanInput(scanner.nextLine());

                if (rowInput.equals("0") || rowInput.equals("1") || rowInput.equals("2")) {
                    try {
//                        Try to convert string to int
                        rows = Integer.parseInt(rowInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Parsing went wrong " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid input. Please enter 0, 1, or 2.");
                }
            }
            // Checks columns input
            int cols = -1;
            while (cols < 0 || cols > 2) {
                System.out.println(player + ", pick a column (0-2)");
                String colInput = cleanInput(scanner.nextLine());

                if (colInput.equals("0") || colInput.equals("1") || colInput.equals("2")) {
                    try {
                        cols = Integer.parseInt(colInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Parsing went wrong " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid input. Please enter 0, 1, or 2.");
                }
            }

            // Check if square is already taken
            if (board[rows][cols] != '-') {
                System.out.println("Square is taken, please choose another.");
                continue;
            }

            updateScoreBoard(rows, cols, player);

            if (hasAnyoneWon()) {
                gameOver(player);
                break;
            }
            checkForDraw();
            break;
        }
    }

    //    Player choosing square()
    private void updateScoreBoard(int row, int col, String player) {

        if (player.equals(player1)) {
            board[row][col] = 'X';
        } else {
            board[row][col] = 'O';
        }
        boardIsDisplayed();

//       Check if anyone won
        if (hasAnyoneWon()) {
            win = true;
        } else {
            checkForDraw();
        }
    }


    //    Comparing squares for different moves
    private boolean hasAnyoneWon() {

        for (int i = 0; i < 3; i++) {
//        Checks rows -> if any row has three same char/symbols xxx or ooo, loop starts with 0-1-2
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }
//        Checks the columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return true;
            }
        }

//            Checks diagonally for both ways.
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
            return true;
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != '-') {
            return true;
        }
        return false;
    }

    //    Game ends. somebody won
    private void gameOver(String player) {

        win = true;
        System.out.println("Game Over!, player " + player + " won");
        askForRematch();
        resetGame();
    }

    //    Getters for player names, tracked wins/losses
    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public boolean isWin() {
        return win;
    }

    //        Changed functionality, this removes unnecessary spaces, citation marks
    private String cleanInput(String input) {

        return input.replaceAll("[^0-9]", "").trim();
    }

    private void checkForDraw() {

        boolean isDraw = true;

//        Check if there is any empty slots on the board
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '-') {
                    isDraw = false;
                    break;
                }

            }
        }
        if (isDraw && !win) {
            System.out.println("Its a draw!");

            if(!rematch()) {
                System.out.println("Thanks for playing");
                //            Exits the program
                System.exit(0);
            }
            resetGame();
        }
    }

    //    Asks players for a "REMATCH" of the game
    public boolean rematch() {
        System.out.println("Do you want a rematch? (yes/no)");
        String answer = scanner.nextLine().trim();

        if (answer.equals("yes")) {
            resetGame();
            return true;
        } else if (answer.equals("no")) {
            System.out.println("Thank you for playing, see ya!");
            return false;
        }
        return false;
    }

    //    Should reset the entire game
    public void resetGame() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '-';
            }
        }

        win = false;
        boardIsDisplayed();
    }
}

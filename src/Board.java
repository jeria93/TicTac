import java.util.Scanner;

public class Board {

    private String player1;
    private String player2;
    //    Board
    private char[][] board;
    //    To keep track of selected row, 1-9
    private int rows;
    //    To keep track of selected columns, 1-9, it's a 2D array
    private int cols;

    private Scanner scanner;
    //    To keep track of who has won or lost
    private boolean win;


    //    Contructor - give all the types "ready to start values"
    public Board() {
        rows = 0;
        cols = 0;
        scanner = new Scanner(System.in);
//3x3 simulated board
        board = new char[3][3];
//        Loops the rows in the 2d array ->
        for (int row = 0; row<board.length; row++) {

            for (int col = 0; col<board[row].length; col++) {
                board[row][col] = '-';
            } // Loops the columns of the 2d array field ↓

        }
//        Nobody has won the first round
        win = false;
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

    public void boardIsDisplayed() {
//        change to the game starts
        System.out.println("test test demo");
        for (int row = 0; row<board.length; row++) {
            for (int col = 0; col<board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //    Change later to "startGame"(?)
    public void gameInitialising() {

//        Should be working in main, remember to import Scanner class.
        System.out.println("Enter player 1 name please");
        player1 = scanner.nextLine();
        System.out.println("Enter player 2 name please");
        player2 = scanner.nextLine();
        boardIsDisplayed();
        playerTurn(player1);

    }

    public void playerTurn(String player) {

        while(true) {
            System.out.println("Player " + player + " turn");
            System.out.println(player + " pick a row please"); //must choose between 0-2
            try {
                rows = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("Invalid input. try entering a number");
                continue;
            }
        }
    }






//    public boolean gameOver() {
//
//        System.out.println("Board");
//
//    }
}

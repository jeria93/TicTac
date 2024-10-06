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


    //    Contructor - give all the types "ready values"
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
        System.out.println("test test demo");
        for (int row = 0; row<board.length; row++) {
            for (int col = 0; col<board[row].length; col++) {
                System.out.println(board[row][col]);
            }
        }
    }



//    public boolean gameOver() {
//
//        System.out.println("Board");
//
//    }
}

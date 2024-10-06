import java.util.Scanner;

public class Board {

    private String player1;
    private String player2;
    private char[][] board;
    private int rows;
    private int cols;
    private Scanner scanner;
    private boolean win;

    public Board() {
        rows = 0;
        cols = 0;
        scanner = new Scanner(System.in);
        board = new char[3][3];
        for (int row = 0; row<board.length; row++) {
            for (int col = 0; col<board[row].length; col++) {
                board[row][col] = ' ';
            }

        }
    }

    public boolean gameOver() {

        System.out.println("Board");
        for(int row) {

        }

    }
}

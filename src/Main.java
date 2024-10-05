import java.awt.datatransfer.Clipboard;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[][] board = new String[3][3];
        board[0][0] = "";
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "";
        board[1][1] = "";
        board[1][2] = "";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player 1 name please");

//        try catch if user puts in something else than a string?
        String playerName1 = scanner.nextLine();
        System.out.println("Player 1 name is " + playerName1);
        System.out.println("Enter player 2 name please");
        String playerName2 = scanner.nextLine();
        System.out.println("Player 2 name is " + playerName2);
        scanner.close();



    }

    public void simulatedBoard(String [][] board) {
        System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
        System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
        System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2]);
    }
}

/* Ideas
2d array for checkboard? 1-9?
scanner for user 1 and 2 input?
try catch -> what if user puts other values than int/string? default values?
rules? how to understand the game?
scanner.close()?
player 1 = x
player 2 = o
player 1, your turn..
player 2 your turn..

if statement/switch, case block -> if square is already taken, return? "square is already taken, try a new one"
Nobody won, tie? start over?
set properties as private, no need for someone to play around the "board"?, scores?
scanner -> Player 1, what's your name? - enter name
scanner -> Player 2, what's your name? - enter name
print out board, change 2d array[][] for actual user input values?
OOP -> board as a class? interface?, test is FAILED if everything is on main, show that you can use OOP.
clean up all code before turning it in. try at least


 */
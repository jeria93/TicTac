import java.util.Scanner;

public class Board {

    private String player1;
    private String player2;
    //    Board
    private char[][] board;
    //    To keep track of selected row, 1-9 ->
    private int rows;
    //    To keep track of selected columns, 1-9, it's a 2D array ↓
    private int cols;
    private Scanner scanner;
    //    To keep track of who has won or lost
    private boolean win;


    //    Constructor - give all the types "ready to start values"
    public Board() {
        rows = 0;
        cols = 0;
        scanner = new Scanner(System.in);
        board = new char[3][3]; //3x3 simulated board
//        Loops the rows in the 2d array ->
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '-';
            } // Loops the columns of the 2d array field ↓

        }
//        Nobody has won the first round
        win = false;
    }

    public void boardIsDisplayed() {

        System.out.println("Lets play");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println(); //If not inserted console shows -------------
        }
        System.out.println();
    }

    public void instructionBoard() {
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
//        scanner.nextLine();
        System.out.println("Enter player 1 name please");
        player1 = scanner.nextLine();
        System.out.println("Enter player 2 name please");
        player2 = scanner.nextLine();
        boardIsDisplayed();
        while (!win) {
            playerTurn(player1);
            if(win) {
                break;
            }
            playerTurn(player2);
        }
//        playerTurn(player1);
//        playerTurn(player2);
    }

    public void playerTurn(String player) {

        while (true) {
            System.out.println("Player " + player + " turn");

            // Hantera radinmatning
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

            int cols = -1;
            while (cols < 0 || cols > 2) {
                System.out.println(player + ", pick a column (0-2)");
                String colInput = cleanInput(scanner.nextLine());

                if (colInput.equals("0") || colInput.equals("1") || colInput.equals("2")) {
                    try {
                        cols = Integer.parseInt(colInput); // Försök konvertera sträng till int
                    } catch (NumberFormatException e) {
                        System.out.println("Parsing went wrong " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid input. Please enter 0, 1, or 2.");
                }
            }

//            System.out.println("Rutan [" + rows + ", " + cols + "] innehåller: " + board[rows][cols]); // Debug
//            if (board[rows][cols] != '-') {
//                System.out.println("Square is taken, please choose another.");
//                continue;
//            }

            // Check if square is already taken
            if (board[rows][cols] != '-') {
                System.out.println("Square is taken, please choose another.");
               continue;
            }

            updateScoreBoard(rows,cols,player);

            if (hasAnyoneWon()) {
                GameOver(player);
                break; // Avsluta while-loopen om spelet är över
            } else {
                checkForDraw();
            }
            break;
//            break;
        }

//        updateScoreBoard(rows, cols, player);

    }

    //    Player choosing square()
    public void updateScoreBoard(int row, int col, String player) {

        if (player.equals(player1)) {
            board[row][col] = 'X';
            boardIsDisplayed();
            if (hasAnyoneWon()) {
                GameOver(player1);
            } else {
                checkForDraw();
            }
        } else {
            board[row][col] = 'O';
            boardIsDisplayed();
            if (hasAnyoneWon()) {
                GameOver(player2);
            } else {
                checkForDraw();
            }
        }

    }


    //    Refactor at a later point?
    public boolean hasAnyoneWon() {

        for (int i = 0; i < 3; i++) {
//        Checks rows -> if any row has three same char/symbols xxx or ooo, loop starts with 0-1-2
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
//        Checks the columns
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                    return true;
                }
//            Checks diagonally for both ways.
                if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
                    return true;
                }
                if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != '-') {
                    return true;
                }

            }

        }
        return false;
    }

    //    Game ends. somebody won, this method is maybe needed in "hasAnyoneWon"?/updateScoreBoard
    public void GameOver(String player) {

        win = true;
        System.out.println("Game Over!, player " + player + " won");
//        When selected no, game should end, not run again.
        restartInvite();
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
    public String cleanInput(String input) {

        return input.replaceAll("[^0-9]", "").trim();
    }

//    public String cleanInput(String input) {
////        Removes any quotation marks from the beginning and end of the string,
//        if (input.startsWith("\"") && input.endsWith("\"")) {
//            input = input.substring(1, input.length() - 1);
//        }
//        return input;
//    }

    public void checkForDraw() {

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
        if(isDraw && !win) {
            System.out.println("Its a draw!");
//            Resets game, needs a restart instead?
//            resetGame();
            restartInvite();
        }
    }

    //    Asks players for a "REMATCH" of the game
    public void restartInvite() {
        System.out.println("Do you want a rematch? (yes/no)");
        String answer = scanner.nextLine().trim();

        if(answer.equals("yes")) {
            resetGame();
        } else {
            System.out.println("Thank you for playing, see ya!");

        }
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
        startGame();
    }
}

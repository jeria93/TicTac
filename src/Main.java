//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Board ticTacGame = new Board();
        ticTacGame.startGame();
        while (true) {
            ticTacGame.playerTurn(ticTacGame.getPlayer1());
            if (ticTacGame.isWin()) {
                if (!ticTacGame.rematch()) {
                    System.out.println("thanks for playing");
                    break;
                }
                ticTacGame.resetGame();
            }

            ticTacGame.playerTurn(ticTacGame.getPlayer2());
            if (ticTacGame.isWin()) {
                if (!ticTacGame.rematch()) {
                    System.out.println("thanks for playing");
                    break;
                }
                ticTacGame.resetGame();
            }
        }
    }
}
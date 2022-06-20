package application;

public class Game {
    public static int gameCount;

    public Game() {
        System.out.println("Welcome to TIC TAC TOE");
        gameCount++;
    }

    public void playAgainstPlayer(Board board) {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        int i = 0;
        board.playerChoose(player1.name);
        board.setSelection(player1.symbol);
        while (i < 4) {
            board.playerChoose(player2.name);
            board.setSelection(player2.symbol);
            if (board.checkWin()) {
                return;
            }
            board.playerChoose(player1.name);
            board.setSelection(player1.symbol);
            if (board.checkWin()) {
                return;
            }
            i++;
        }
    }


    public void playAgainstComputer(Board board) {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Computer", 'O');
        int i = 0;
        board.playerChoose(player1.name);
        board.setSelection(player1.symbol);
        while (i < 4) {
            board.computerChoose(player2.name);
            board.setSelection(player2.symbol);
            if (board.checkWin()) {
                return;
            }
            board.playerChoose(player1.name);
            board.setSelection(player1.symbol);
            if (board.checkWin()) {
                return;
            }
            i++;
        }
        System.out.println("It is a tie!");
    }

}

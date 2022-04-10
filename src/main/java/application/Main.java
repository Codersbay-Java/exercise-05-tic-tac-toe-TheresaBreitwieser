package application;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to TIC TAC TOE");
        Board board = new Board();


        System.out.println("Would you like to play against another player press 1, to play against computer press 2");
        int selection = scanner.nextInt();
        Player player1 = null;
        Player player2 = null;

        if (selection == 1) {
            player1 = new Player("Player1", 'X');
            player2 = new Player("Player2", 'O');
            int i = 0;
            board.playerChoose(player1.name);
            board.setSelection(player1.symbol);
            while (i < 4) {
                board.playerChoose(player2.name);
                board.setSelection(player2.symbol);
                if (board.checkWin()) {
                    return;
                }
                ;
                board.playerChoose(player1.name);
                board.setSelection(player1.symbol);
                if (board.checkWin()) {
                    return;
                }
                ;
            }
            System.out.println("It is a tie!");

        } else if (selection == 2) {
            player1 = new Player("Player1", 'X');
            player2 = new Player("Computer", 'O');
            int i = 0;
            board.playerChoose(player1.name);
            board.setSelection(player1.symbol);
            while (i < 4) {
                board.computerChoose(player2.name);
                board.setSelection(player2.symbol);
                if (board.checkWin()) {
                    return;
                }
                ;
                board.playerChoose(player1.name);
                board.setSelection(player1.symbol);
                if (board.checkWin()) {
                    return;
                }
                ;
            }
            System.out.println("It is a tie!");

        }
    }
}


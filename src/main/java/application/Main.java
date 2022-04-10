package application;


import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game= new Game();
        Board board = new Board();


        System.out.println("Would you like to play against another player press 1, to play against computer press 2");
        int selection = scanner.nextInt();

        if (selection == 1) {
           game.playAgainstPlayer(board);
        } else if (selection == 2) {
            game.playAgainstComputer(board);
        }

        System.out.println(Game.gameCount);
    }
}


package application;

import java.util.Scanner;
import java.util.Random;

public class Board {
    private static final int BOARD_SIZE = 3;
    private static final int EMPTY_BOARD = 32; // " " Leerzeichen im ascII hat den Wert 32
    public static final int PLAYER_ONE = 88; //ASCII value for X
    public static final int PLAYER_TWO = 79; //ASCII value for O
    private int[][] board;
    private int[] selection = new int[2];


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Board() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        printBoard();
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY_BOARD;
                System.out.print("|" + (char) board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void computerChoose(String player) {
        boolean wrongInput = true;
        int row = 0;
        int col = 0;
        // Computer selektiert Reihe und Col, Werte werden geprüft und in int Array gegeben
        while (wrongInput) {
            System.out.println(player + " is choosing a row and a column");
            row = random.nextInt((3 - 1) + 1) + 1;
            col = random.nextInt((3 - 1) + 1) + 1;

            wrongInput = checkChoose(row, col);
        }
        selection = new int[]{row, col};
    }

    public void playerChoose(String player) {
        boolean wrongInput = true;
        int row = 0;
        int col = 0;
        // Spieler selektiert Reihe und Col, Werte werden geprüft und in int Array gegeben
        while (wrongInput) {
            System.out.println(player + " choose a row and a column");
            System.out.print("Please type in your row (from 1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Please type in your col (from 1-3): ");
            col = scanner.nextInt() - 1;

            wrongInput = checkChoose(row, col);
        }
        selection = new int[]{row, col};
    }

    public boolean checkChoose(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Number is not in range, please enter a valid number");
            return true;
        }
        //checkt ob der Spieler auf ein freies Feld setzt (AscII " " = 32)
        else if (board[row][col] != EMPTY_BOARD) {
            System.out.println("This spot is not possible. Please re-enter your numbers");
            return true;

        } else {
            return false;
        }

    }


    public void setSelection(char value) {
        //Spieler Auswahl wird am Board positioniert und Board ausgegeben

        board[selection[0]][selection[1]] = value;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|" + (char) board[i][j] + "|");
            }
            System.out.println();
        }
    }


    public boolean checkWin() {
        return checkRow() || checkCol() || checkDiagonal1() || checkDiagonal2();
    }

    public boolean checkRow() {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum = sum + board[i][j];
                if (sum == 3 * PLAYER_ONE) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * PLAYER_TWO) {
                    System.out.println("Player2 (O) has won");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean checkCol() {
        int sum = 0;
        for (int j = 0; j < board[0].length; j++) {
            sum = 0;
            for (int i = 0; i < board.length; i++) {
                sum = sum + board[i][j];
                if (sum == 3 * PLAYER_ONE) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * PLAYER_TWO) {
                    System.out.println("Player2 (O) has won");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean checkDiagonal1() {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (i = 0; i < board[0].length; i++) {
                sum = sum + board[i][i];
                if (sum == 3 * PLAYER_ONE) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * PLAYER_TWO) {
                    System.out.println("Player2 (O) has won");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal2() {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum = sum + board[i][board.length - i - 1];
            if (sum == 3 * PLAYER_ONE) {
                System.out.println("Player1 (X) has won");
                return true;
            } else if (sum == 3 * PLAYER_TWO) {
                System.out.println("Player2 (O) has won");
                return true;
            }
        }
        return false;
    }

}

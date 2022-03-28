package application;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int BOARD_SIZE = 3;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        String player1 = "Player1";
        String player2 = "Player2";

        System.out.println("---Welcome to Tic Tac Toe--");

        printGameboard(board);
//		AscII X= 88; (XXX = 264)
//		AscII O= 79; (OOO = 237)
        char valueXPlayer1 = 'X';
        char valueOPlayer2 = 'O';


        // ------------------Round1------------------------
        int[] selection1 = playerChoose(player1, board);
        setSelection(selection1, board, valueXPlayer1);

        int[] selection2 = playerChoose(player2, board);
        setSelection(selection2, board, valueOPlayer2);

        // -----------------Round2---------------------------
        selection1 = playerChoose(player1, board);
        setSelection(selection1, board, valueXPlayer1);

        selection2 = playerChoose(player2, board);
        setSelection(selection2, board, valueOPlayer2);

        // -----------------Round3---------------------------
        selection1 = playerChoose(player1, board);
        setSelection(selection1, board, valueXPlayer1);

        if(checkWin(board) == true) {
            return;
        }

        selection2 = playerChoose(player2, board);
        setSelection(selection2, board, valueOPlayer2);

        if(checkWin(board) == true) {
            return;
        }

        // -----------------Round4---------------------------

        selection1 = playerChoose(player1, board);
        setSelection(selection1, board, valueXPlayer1);

        if(checkWin(board) == true) {
            return;
        }

        selection2 = playerChoose(player2, board);
        setSelection(selection2, board, valueOPlayer2);

        if(checkWin(board) == true) {
            return;
        }
        // -----------------Round5---------------------------

        selection1 = playerChoose(player1, board);
        setSelection(selection1, board, valueXPlayer1);

        if(checkWin(board) == true) {
            return;
        }
        System.out.println("It is a tie");

    }

    public static void printGameboard(int[][] gameboard) {
        // " " Leerzeichen im ascII hat den Wert 32
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = 32;
                System.out.print("|" + (char) gameboard[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static int[] playerChoose(String player, int[][] board) {
        boolean wrongInput = true;
        int row = 0;
        int col = 0;
        // Spieler selektiert Reihe und Col, Werte werden geprüft und in int Array retour gegeben
        while (wrongInput) {
            System.out.println(player + " choose a row and a column");
            System.out.print("Please type in your row (from 1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Please type in your col (from 1-3): ");
            col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Number is not in range, please enter a valid number");
                wrongInput = true;
            }
            //checkt ob der Spieler auf ein freies Feld setzt (AscII " " = 32)
            else if (board[row][col] != 32) {
                System.out.println("This spot is not possible. Please re-enter your numbers");
                wrongInput = true;

            } else {
                wrongInput = false;
            }

        }

        int[] rowCol = {row, col};
        System.out.println(Arrays.toString(rowCol));
        return rowCol;

    }

    public static void setSelection(int[] selection, int[][] board, char value) {
        //Spieler Auswahl wird am Board positioniert und Board ausgegeben

        board[selection[0]][selection[1]] = value;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|" + (char) board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int[][] board) {
        boolean row = checkRow(board);
        boolean col = checkCol(board);
        boolean checkDiagonal1 = checkDiagonal1(board);
        boolean checkDiagonal2 = checkDiagonal2(board);

        if(row== true || col==true || checkDiagonal1==true || checkDiagonal2==true) {
            return true;
        } else {
            return false;
        }


    }

    public static boolean checkRow(int[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum = sum + board[i][j];
                if (sum == 3 * 88) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * 79) {
                    System.out.println("Player2 (O) has won");
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkCol(int[][] board) {
        int sum = 0;
        for (int j = 0; j < board[0].length; j++) {
            sum = 0;
            for (int i = 0; i < board.length; i++) {
                sum = sum + board[i][j];
                if (sum == 3 * 88) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * 79) {
                    System.out.println("Player2 (O) has won");
                   return true;
                }
            }

        }
        return false;
    }

    public static boolean checkDiagonal1(int[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (i = 0; i < board[0].length; i++) {
                sum = sum + board[i][i];
                if (sum == 3 * 88) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * 79) {
                    System.out.println("Player2 (O) has won");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonal2(int[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum = sum + board[i][board.length-i-1];
                if (sum == 3 * 88) {
                    System.out.println("Player1 (X) has won");
                    return true;
                } else if (sum == 3 * 79) {
                    System.out.println("Player2 (O) has won");
                    return true;
                }
            }
        return false;
        }

    }


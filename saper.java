/*
saper w javie :>
*/

import java.util.*;

public class Saper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 10; // liczba pól na planszy
        int m = 10; // liczba min na planszy
        int[][] board = new int[n][n]; // plansza

        // inicjalizacja planszy
        for (int i = 0; i < m; i++) {
            int x = (int)(Math.random() * n);
            int y = (int)(Math.random() * n);
            if (board[x][y] == -1) {
                i--;
            } else {
                board[x][y] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                int count = 0;
                if (i > 0 && j > 0 && board[i-1][j-1] == -1) count++;
                if (i > 0 && board[i-1][j] == -1) count++;
                if (i > 0 && j < n-1 && board[i-1][j+1] == -1) count++;
                if (j > 0 && board[i][j-1] == -1) count++;
                if (j < n-1 && board[i][j+1] == -1) count++;
                if (i < n-1 && j > 0 && board[i+1][j-1] == -1) count++;
                if (i < n-1 && board[i+1][j] == -1) count++;
                if (i < n-1 && j < n-1 && board[i+1][j+1] == -1) count++;
                board[i][j] = count;
            }
        }

        // rozgrywka
        boolean[][] revealed = new boolean[n][n];
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!revealed[i][j]) {
                        System.out.print(". ");
                    } else if (board[i][j] == -1) {
                        System.out.print("* ");
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                }
                System.out.println();
            }
            System.out.print("wybierz x: ");
            int x = scanner.nextInt();
            System.out.print("wybierz y: ");
            int y = scanner.nextInt();
            if (board[x][y] == -1) {
                System.out.println("przegrałeś!");
                break;
            }
            revealed[x][y] = true;
            boolean win = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!revealed[i][j] && board[i][j] != -1) {
                        win = false;
                        break;
                    }
                }
                if (!win) {
                    break;
                }
            }
            if (win) {
                System.out.println("wygrałeś!");
                break;
            }
        }
    }
}

/*
działa sprawdzaned
pozdrawiam cieplusio :>
*/

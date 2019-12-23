package tictactoe;

import java.util.Scanner;

public class Main {

    public static void printField(char[][] arr) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static char[][] fillField(String cells) {
        char[][] arr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char fieldChar = cells.charAt( 3* i + j);
                arr[i][j] = fieldChar;
            }
        }
        return arr;
    }

    public static boolean checkWin(char[][] arr) {

        int nX = 0;
        int nO = 0;
        int nEmpty = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char fieldChar = arr[i][j];
                if (fieldChar == 'X') {
                    nX++;
                } else if (fieldChar == 'O') {
                    nO++;
                } else {
                    nEmpty++;
                }
            }
        }

        int xWins = 0;
        int oWins = 0;

        for (int i = 0; i < 3; i++) {
            //check rows for X
            if (arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X') {
                xWins++;
            }
            //check rows for O
            if (arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O') {
                oWins++;
            }

            //check columns for X
            if (arr[0][i] == 'X' && arr[1][i] == 'X' && arr[2][i] == 'X') {
                xWins++;
            }
            //check rows for O
            if (arr[0][i] == 'O' && arr[1][i] == 'O' && arr[2][i] == 'O') {
                oWins++;
            }

        }

        // check main diagonal for X
        if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
            xWins++;
        }
        // check main diagonal for O
        if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
            oWins++;
        }
        // check secondary diagonal for X
        if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
            xWins++;
        }
        // check main diagonal for O
        if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
            oWins++;
        }

        int dif = Math.abs(nX - nO);

        if (xWins + oWins > 1 || dif > 1 ) {
            System.out.println("Impossible");
            return false;
        }

        if (xWins == 1 && oWins == 0 && dif < 2) {
            System.out.println("X wins");
            return false;
        }

        if (xWins == 0 && oWins == 1 && dif < 2) {
            System.out.println("O wins");
            return false;
        }

        if (xWins + oWins == 0 && nEmpty == 0) {
            System.out.println("Draw");
            return false;
        }

        if (xWins + oWins == 0 && nEmpty > 0 && dif < 2) {
            System.out.println("Game not finished");
            return true;
        }
        return true;
    }

    public static int ySwap(int y) {
        if(y == 0){
            y =+2;
        }
        else if(y == 2){
            y-=2;
        }
        return y;
    }

    public static void userMove(Scanner scanner, char[][] arr, int turn){
        boolean input = true;
        int x = 0;
        int y = 0;

        System.out.println("Enter the coordinates: ");
        x = scanner.nextInt()-1;
        y = scanner.nextInt()-1;
        while(input){
            if(x >= 3 || y >= 3){
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println("Enter the coordinates: ");
                x = scanner.nextInt()-1;
                y = scanner.nextInt()-1;
            }
            else{
                input = false;
            }
        }

        y = ySwap(y);

        while(arr[y][x] != '_'){
            System.out.println("This cell is occupied! Choose another one! \n");
            System.out.println("Enter the coordinates: ");
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;

            while(x >= 3 || y >= 3){
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println("Enter the coordinates: ");
                x = scanner.nextInt()-1;
                y = scanner.nextInt()-1;
            }

            y = ySwap(y);
        }

        if(turn % 2 == 0){
            arr[y][x] = 'X';
        }
        else{
            arr[y][x] = 'O';
        }

    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String cells = "_________";
        char[][] arr = fillField(cells);

        int turn = 0;

        while(checkWin(arr)){
            printField(arr);
            userMove(scanner, arr, turn);
            printField(arr);
            turn++;
        }

    }
}

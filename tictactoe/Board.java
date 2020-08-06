package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Board {


    String cells = "_________";
    char[][] arr;
    int turn = 0;

    public Board() {
        char[][] arr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char fieldChar = cells.charAt( 3* i + j);
                arr[i][j] = fieldChar;
            }
        }
        this.arr = arr;
    }

    public void turnCounter() {
        this.turn++;
    }

    public void printField() {
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

    public static int[] validateInput(){
        int[] cords = new int[2];
        boolean input = true;

        while(input){
            try {
                System.out.println("Enter the coordinates: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                cords = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

                cords[0] = cords[0] - 1;
                cords[1] = cords[1] - 1;

                if(cords[0] >= 3 || cords[1] >= 3){
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else{
                    input = false;
                }

            } catch (NumberFormatException | IOException e) {
                System.out.println("You should enter numbers!");
            }

        }
        return cords;
    }

    public char whoGoes(){
        if(turn % 2 == 0){
            return 'X';
        }
        else{
            return 'O';
        }
    }

    public void userMove(){
        int[] cords = validateInput();
        int x = cords[0];
        int y = cords[1];

        while(arr[x][y] != '_'){
            System.out.println("This cell is occupied! Choose another one!");
            cords = validateInput();
            x = cords[0];
            y = cords[1];

        }
        arr[x][y] = whoGoes();
        printField();
        turnCounter();
    }

    public boolean checkWin() {

        char result = 'a';
        boolean win = true;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i][0] == 'X' || arr[i][0] == 'O') && arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]) {
                result = arr[i][0];
                win = false;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if ((arr[0][i] == 'X' || arr[0][i] == 'O') && arr[0][i] == arr[1][i] && arr[0][i] == arr[2][i]) {
                result = arr[0][i];
                win = false;
            }
        }


        if ((arr[1][1] == 'X' || arr[1][1] == 'O') && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] ||
                (arr[1][1] == 'X' || arr[1][1] == 'O') && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]) {
            result = arr[1][1];
            win = false;
        }

        if (!win) {
            System.out.println(result + " " + "wins");
        }
        else if (checkDraw()){
            System.out.println("Draw");
            win = false;
        }
        return win;
    }

    public boolean checkDraw() {

        int underline = 0;
        boolean checkDraw = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 'X') {
                    underline++;
                } else if (arr[i][j] == 'O'){
                    underline++;
                }
            }
        }

        if (underline == 9) {
            checkDraw = true;
        }
        return checkDraw;
    }

    public void easyAi() {
        if(!checkDraw()){
            Random random = new Random();
            int x = random.nextInt(3);
            int y = random.nextInt(3);

            while(arr[x][y] != '_') {
                x = random.nextInt(3);
                y = random.nextInt(3);
            }

            System.out.println("Making move level \"easy\"");

            arr[x][y] = whoGoes();
            printField();
            turnCounter();
        }
    }

    public void mediumAi() {
        char p = whoGoes();
        boolean move = false;

        //diagonal checks for win route
        if((arr[2][0] == p) && arr[1][1] == p && arr[0][2] == '_'){
            arr[0][2] = p;
            move = true;
        }
        else if((arr[0][0] == p) && arr[1][1] == p && arr[2][2] == '_'){
            arr[2][2] = p;
            move = true;
        }
        else if((arr[0][2] == p) && arr[1][1] == p && arr[2][0] == '_'){
            arr[2][0] = p;
            move = true;
        }
        else if((arr[2][2] == p) && arr[1][1] == p && arr[0][0] == '_'){
            arr[0][0] = p;
            move = true;
        }

        if(!move){
            for (int i = 0; i < arr.length; i++) {
                //checks right column for a win route
                if ((arr[i][0] == p) && arr[i][0] == arr[i][1] && arr[i][2] == '_') {
                    arr[i][2] = p;
                    move = true;
                    break;
                }
                //checks left column for a win route
                if ((arr[i][1] == p) && arr[i][1] == arr[i][2] && arr[i][0] == '_') {
                    arr[i][0] = p;
                    move = true;
                    break;
                }
                //checks bottom column for win route
                if ((arr[0][i] == p) && arr[0][i] == arr[1][i] && arr[2][i] == '_') {
                    arr[2][i] = p;
                    move = true;
                    break;
                }
                //checks top column for win route
                if ((arr[2][i] == p) && arr[2][i] == arr[1][i] && arr[0][i] == '_') {
                    arr[0][i] = p;

                    move = true;
                    break;
                }
            }
        }

        if(!move){
            Random random = new Random();
            int x = random.nextInt(3);
            int y = random.nextInt(3);

            while(arr[x][y] != '_') {
                x = random.nextInt(3);
                y = random.nextInt(3);
            }
            arr[x][y] = p;
        }

        System.out.println("Making move level \"medium\"");
        printField();
        turnCounter();
    }

    public void hardAi(){
        HardAi ai = new HardAi();
        int []optimal = ai.findBestMove(arr);
        int i = optimal[0];
        int j = optimal[1];
        arr[i][j] = whoGoes();
        System.out.println("Making move level \"hard\"");
        printField();
        turnCounter();
    }
}

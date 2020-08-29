package life;

import java.util.Random;

public class GenerateUniverse {
    public char[][] getUniverse() {
        return universe;
    }

    char[][] universe;

    public GenerateUniverse(int n){
        universe = new char[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(random.nextBoolean() == true){
                    universe[i][j] = 'O';
                }
                else
                    universe[i][j] = ' ';
            }
        }
    }

    public void printUniverse(){
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                if(universe[i][j] == 'O'){
                    System.out.print(universe[i][j]);
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

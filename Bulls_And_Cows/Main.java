package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int turnCounter = 1;
        boolean winCondition = false;
        char[] playerGuess;
        int codeLength;
        int possibleCharacters;

        try {
            System.out.println("Please, enter the secret code's length:");

            codeLength = Integer.parseInt(input.nextLine());

            System.out.println("Input the number of possible symbols in the code:");

            possibleCharacters = Integer.parseInt(input.nextLine());

            if(codeLength > 36 || codeLength < 1){
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(-1);
            }else if(codeLength > possibleCharacters){
                System.out.printf("Error: it's not possible to generate a code with" +
                        " a length of %d with %d unique symbols.\n",codeLength, possibleCharacters);
                System.exit(-1);
            }else if(possibleCharacters > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(-1);
            }

            Guess guessing = new Guess(codeLength, possibleCharacters);

            System.out.println("Okay, let's start a game!");

            while(winCondition == false){
                System.out.println("Turn " + turnCounter);
                playerGuess = input.nextLine().toCharArray();
                winCondition = guessing.compareGuess(playerGuess);
                turnCounter++;
            }

        } catch (Exception e) {
            System.out.println("Error detected " + e );
            System.exit(-1);
        }



    }
}

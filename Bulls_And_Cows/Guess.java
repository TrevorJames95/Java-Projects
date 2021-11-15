package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Guess {
    private List<Character> randomList;
    private String secret = "";
    private String seed = "0123456789abcdefghijklmnopqrstuvwxyz";


    public void generateSecret(int endRange){
        for (int i = 0; i < endRange; i++) {
            secret += "*";
        }
        if(endRange > 10){
            System.out.printf("The secret is prepared: %s (0-9, a-%c).\n",secret, seed.charAt(endRange));
        }else {
            System.out.printf("The secret is prepared: %s (0-%c).\n",secret, seed.charAt(endRange));
        }
    }

    public Guess(int codeLength, int possibleCharacters) {
        randomList = new ArrayList<Character>();
        //Creating the character pool.
        for (int i = 0; i < possibleCharacters; i++) {
            randomList.add(seed.charAt(i));
        }

        int endRange = randomList.size()-1;

        //Randomizes the characters into our secret phrase.
        Collections.shuffle(randomList);
        while (randomList.get(0) == '0') {
            Collections.shuffle(randomList);
        }

        //Removing characters to reach the specified code length.
        while(randomList.size() > codeLength){
            randomList.remove(randomList.size()-1);
        }

        generateSecret(endRange);
    }

    public boolean compareGuess(char[] guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length; i++) {
            if(randomList.get(i) == guess[i]) {
                bulls++;
            }
            else {
                for (int j = 0; j < guess.length; j++) {
                    if(randomList.get(i) == guess[j]){
                        cows++;
                    }
                }
            }
        }

        if(bulls == guess.length) {
            System.out.printf("Grade: %d bull(s).\n", bulls);
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        }else if(bulls == 0 && cows == 0){
            System.out.printf("Grade: None.\n");
        }else if(bulls > 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s).\n", bulls);
        }else if( cows > 0 && bulls == 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
        }else {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
        }

        return false;
    }
}

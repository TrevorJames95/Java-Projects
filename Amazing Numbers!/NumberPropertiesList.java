package numbers;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringJoiner;

public class NumberPropertiesList {
    StringJoiner numProperties = new StringJoiner(", ");

    public void evenOrOdd(long num) {
        boolean even = false;
        boolean odd = false;
        if(num % 2 == 0){
            even = true;
        } else{
            odd = true;
        }

        if(even) {
            numProperties.add("even");
        } else {
            numProperties.add("odd");
        }
    }

    public void buzzNumber(long num) {
        if(num % 10 == 7 && num % 7 == 0) {
            //System.out.println("buzz: true");
            numProperties.add("buzz");
        } else if(num % 10 == 7) {
            //System.out.println("buzz: true");
            numProperties.add("buzz");
        } else if(num % 7 == 0){
            //System.out.println("buzz: true");
            numProperties.add("buzz");
        } else {
            //System.out.println("buzz: false");
        }
    }

    public void duckNumber(long num) {
        boolean res = false;
        String number = String.valueOf(num);
        // Ignore leading 0s
        int i = 0, n = number.length();
        while (i < n && number.charAt(i) == '0')
            i++;

        // Check remaining digits
        while (i < n) {
            if (number.charAt(i) == '0')
                res = true;
            i++;
        }
        if(res) {
            numProperties.add("duck");
        }
        //System.out.println("duck: " + res);
    }

    public void palindromicNumber(long num) {
        Stack stack = new Stack();
        String inputString = String.valueOf(num);
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString += stack.pop();
        }

        if (inputString.equals(reverseString)) {
            //System.out.println("palindromic: true");
            numProperties.add("palindromic");
        } else {
            //System.out.println("palindromic: false");
        }
    }

    public void gapfulNumber(long num) {
        String number = Long.toString(num);
        if(number.length() < 3) {
            //System.out.println("gapful: false");
        } else {
            char firstDigit = number.charAt(0);
            char lastDigit = number.charAt(number.length()-1);
            String concatenation = String.valueOf(firstDigit) + lastDigit;
            int divisor = Integer.parseInt(concatenation) ;
            if(num % divisor == 0) {
                //System.out.println("gapful: true");
                numProperties.add("gapful");
            } else {
                //System.out.println("gapful: false");
            }
        }
    }

    public void spyNumber(long num) {
        //sum of all digits is equal to the product of all digits.
        int product = 1;
        int sum = 0;
        String digits = Long.toString(num);
        for (int i = 0; i < digits.length(); i++) {
            product *= Character.getNumericValue(digits.charAt(i));
            sum += Character.getNumericValue(digits.charAt(i));
        }

        if(sum == product) {
            //System.out.println("spy: true");
            numProperties.add("spy");
        } else {
            //System.out.println("spy: false");
        }
    }

    public void sunnyNumber(long num){
        //A number is sunny if N+1 is a perfect square.
        double sqrt = Math.sqrt(num + 1);
        if(sqrt - Math.floor(sqrt) == 0) {
            //System.out.println("sunny: true");
            numProperties.add("sunny");
        } else {
            //System.out.println("sunny: false");
        }
    }

    public void perfectSquare(long num) {
        double sqrt = Math.sqrt(num);
        if(sqrt - Math.floor(sqrt) == 0) {
            //System.out.println("square: true");
            numProperties.add("square");
        } else {
            //System.out.println("square: false");
        }
    }

    public void jumpingNumbers(long num) {
        String number = Long.toString(num);
        boolean checker = true;
        if(number.length() == 1) {
            //System.out.println("jumping: true");
            numProperties.add("jumping");
        } else {
            ArrayList<Character> digits = new ArrayList<Character>();
            for (char c : number.toCharArray()) {
                digits.add(c);
            }

            while(digits.size()>1) {
                if(Math.abs(Character.getNumericValue(digits.get(0)) - Character.getNumericValue(digits.get(1))) == 1) {
                    digits.remove(0);
                } else {
                    checker = false;
                    break;
                }
            }
            if(checker) {
                //System.out.println("jumping: true");
                numProperties.add("jumping");
            } else {
                //System.out.println("jumping: false");
            }
        }
    }

    public void happyNumbers(long number) {
        long slow, fast;

        //  initialize slow and fast by n
        slow = fast = number;
        do
        {
            //  move slow number
            // by one iteration
            slow = numSquareSum(slow);

            //  move fast number
            // by two iteration
            fast = numSquareSum(numSquareSum(fast));

        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        if(slow == 1){
            //System.out.println("happy: true");
            numProperties.add("happy");
        } else {
            //System.out.println("sad: true");
            numProperties.add("sad");
        }
    }

    long numSquareSum(long n)
    {
        long squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }

    public void groupFunctionCall(long number) {
        buzzNumber(number);
        duckNumber(number);
        palindromicNumber(number);
        gapfulNumber(number);
        spyNumber(number);
        perfectSquare(number);
        sunnyNumber(number);
        jumpingNumbers(number);
        happyNumbers(number);
        evenOrOdd(number);
    }

    public void printResults(long number) {
        groupFunctionCall(number);
        String sj = numProperties.toString();
        System.out.println(number + " is " + sj);
    }

    public boolean printRes1Property(long number, String property) {
        groupFunctionCall(number);
        String sj = numProperties.toString().toUpperCase();
        if(sj.contains(property)){
            System.out.println(number + " is " + sj.toLowerCase());
            return true;
        } else {
            return false;
        }
    }
    public boolean printRes2Property(long number, String prop1, String prop2) {
        groupFunctionCall(number);
        String sj = numProperties.toString().toUpperCase();
        if(sj.contains(prop1) && sj.contains(prop2)) {
            System.out.println(number + " is " + sj.toLowerCase());
            return true;
        } else {
            return false;
        }
    }

    public boolean printMultipleProperties(long number, String [] prop) {
        groupFunctionCall(number);
        String sj = numProperties.toString().toUpperCase();

        for (int i = 0; i < prop.length; i++) {
            if(prop[i].charAt(0) == '-') {
                //Checks if the current number generated an unwanted property.
                String negativeProp = prop[i].substring(1);
                if(sj.contains(negativeProp)) {
                    return false;
                }
            } else if(sj.contains(prop[i])) {
                //Checks if the current string contains our wanted property;
                //From there we move on to the next property.
            } else {
                return false;
            }
        }

        System.out.println(number + " is " + sj.toLowerCase());
        return true;
    }
}

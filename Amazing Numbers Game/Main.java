package numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    static String properties = "EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD," +
            "-EVEN, -ODD, -BUZZ, -DUCK, -PALINDROMIC, -GAPFUL, -SPY, -SQUARE, -SUNNY, -JUMPING, -HAPPY, -SAD";
    public static void main(String[] args) {
//       write your code here
        Scanner scanner = new Scanner(System.in);
        NumberProperties num = new NumberProperties();
        long number;
        int consecutiveNumbers;
        boolean runCondition = true;
        String input;
        String [] numbers;
        int switchCondition;

        System.out.println("Welcome to Amazing Numbers!\n");
        num.userPrompt();

        while(runCondition) {
            System.out.printf("Enter a request:");
            input = scanner.nextLine().toUpperCase();

            //Loops the user prompt until something is entered.
            while(input.isEmpty()) {
                num.userPrompt();
                input = scanner.nextLine().toUpperCase();
            }

            numbers = input.split(" ");
            number = Long.parseLong(numbers[0]);
            switchCondition = numbers.length;

            if(number == 0) {
                runCondition = false;
            } else if(!isNatural(number)) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else{
                //Start of the program after error checks have cleared.
                switch(switchCondition) {
                    case 1: {
                        System.out.println("Properties of " + number);
                        num.groupFunctionCall(number);
                        break;
                    }
                    case 2: {
                        consecutiveNumbers = Integer.parseInt(numbers[1]);
                        if(isNatural(consecutiveNumbers)) {
                            for (int i = 0; i < consecutiveNumbers; i++) {
                                NumberPropertiesList data = new NumberPropertiesList();
                                data.printResults(number);
                                number++;
                            }
                        } else {
                            System.out.println("The second parameter should be a natural number");
                        }
                        System.out.println();
                        break;
                    }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:  {
                        String [] props = Arrays.copyOfRange(numbers,2,numbers.length);
                        if(containsWrongProperty(props) && mutuallyExclusive(props)) {
                            //Long if statement to check if our properties are
                            //mutually exclusive and available on our list.
                            consecutiveNumbers = Integer.parseInt(numbers[1]);
                            if(isNatural(consecutiveNumbers)) {
                                generateNumbers(props, consecutiveNumbers, number);
                            }
                        }
                        break;
                    }
                    case 99:
                        System.out.println("No input found");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + switchCondition);
                }
            }
        }
        System.out.println("Goodbye!");
    }

    public static boolean isNatural(long num) {
        //Checks if the number is a natural number.
        return num > 0;
    }

    public static boolean containsWrongProperty(String [] props) {
        int counter = 0;
        StringBuilder errorMsg = new StringBuilder();
        StringJoiner wrongProperties = new StringJoiner(", ");
        for (String property : props) {
            if(!properties.contains(property)) {
                wrongProperties.add(property);
                counter++;
            }
        }
        if(counter > 1) {
            errorMsg.append("The properties [" + wrongProperties + "] are wrong");
            System.out.println(errorMsg);
            System.out.println("Available properties: [" + properties + "]");
            return false;
        } else if(counter == 1){
            errorMsg.append("The property [" + wrongProperties + "] is wrong");
            System.out.println(errorMsg);
            System.out.println("Available properties: [" + properties + "]");
            return false;
        }
        return true;
    }

    public static boolean mutuallyExclusive(String [] props) {
        //Checks for properties that can't occur at the same time such as even and odd.
        List<String> pair = Arrays.asList(props);
        if(pair.contains("ODD") && pair.contains("EVEN")){
            System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]");
            return false;
        } else if(pair.contains("SPY") && pair.contains("DUCK")) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
            return false;
        } else if(pair.contains("SUNNY") && pair.contains("SQUARE")) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]");
            return false;
        }  else if(pair.contains("HAPPY") && pair.contains("SAD")) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]");
            return false;
        } else if(pair.contains("-ODD") && pair.contains("-EVEN")){
            System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]");
            return false;
        } else if(pair.contains("-SPY") && pair.contains("-DUCK")) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
            return false;
        } else if(pair.contains("-SUNNY") && pair.contains("-SQUARE")) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]");
            return false;
        }  else if(pair.contains("-HAPPY") && pair.contains("-SAD")) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]");
            return false;
        } else if(pair.contains("-ODD") && pair.contains("ODD")) {
            System.out.println("The request contains mutually exclusive properties: [-ODD, ODD]");
            return false;
        } else if(pair.contains("-EVEN") && pair.contains("EVEN")) {
            System.out.println("The request contains mutually exclusive properties: [-EVEN, EVEN]");
            return false;
        } else if(pair.contains("-DUCK") && pair.contains("DUCK")) {
            System.out.println("The request contains mutually exclusive properties: [-DUCK, DUCK]");
            return false;
        } else {
            return true;
        }
    }

    public static void generateNumbers(String [] props, int consecutiveNumbers, long number) {
        for (int i = 0; i < consecutiveNumbers; i++) {
            NumberPropertiesList data = new NumberPropertiesList();
            if(data.printMultipleProperties(number, props)) {
                number++;
            } else {
                number++;
                i--;
            }
        }
    }
}

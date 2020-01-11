package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        String action = "";
        Scanner scanner = new Scanner(System.in);
        Coffee c = new Coffee();

        while(!action.equals("exit")){
            System.out.println(" Write action (buy, fill, take, remaining, exit");
            action = scanner.next();

            switch(action){
                case "buy":
                {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    c.setOption(scanner.next());
                    c.coffeeCheck();

                    break;
                }

                case "fill":
                {
                    System.out.println("Write how many ml of water the coffee machine has: ");
                    c.setWater(scanner.nextInt());

                    System.out.println("Write how many ml of milk the coffee machine has: ");
                    c.setMilk(scanner.nextInt());

                    System.out.println("Write how many grams of coffee beans the coffee machine has: ");
                    c.setBeans(scanner.nextInt());

                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    c.setCups(scanner.nextInt());

                    c.displayMachine();

                    break;
                }

                case "take":
                {
                    System.out.println("I gave you " + c.getCash());
                    c.setCash(0);
                    c.displayMachine();
                    break;
                }

                case "remaining":
                    c.displayMachine();
                    break;

                default:
                    break;
            }
        }
    }
}

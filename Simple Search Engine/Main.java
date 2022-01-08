package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Index index = new Index();
        index.buildMap(args[1]);

        System.out.println();
        printMenu();
        int menuOption = Integer.parseInt(scanner.nextLine());
        boolean runCondition = true;

        while(runCondition){
            switch(menuOption) {
                case 1:
                    System.out.println();
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String searchStrategy = scanner.nextLine();
                    System.out.println();
                    System.out.println("Enter a name or email to search all suitable people.");
                    String query = scanner.nextLine().toLowerCase();
                    if(searchStrategy.equals("ANY")) {
                        System.out.println();
                        index.findAny(query);
                    } else if(searchStrategy.equals("NONE")) {
                        System.out.println();
                        index.findNone(query);
                    } else if(searchStrategy.equals("ALL")) {
                        System.out.println();
                        index.findAll(query);
                    }

                    System.out.println();
                    printMenu();
                    menuOption = Integer.parseInt(scanner.nextLine());
                    break;
                case 2:
                    System.out.println();
                    System.out.println("=== List of people ===");
                    index.print();
                    System.out.println();
                    printMenu();
                    menuOption = Integer.parseInt(scanner.nextLine());
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Bye!");
                    runCondition = false;
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    printMenu();
                    menuOption = Integer.parseInt(scanner.nextLine());
            }
        }
    }

    public static void printMenu() {
        System.out.println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
    }
}

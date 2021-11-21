package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        int rows, seats;
        int switchCondition;

        System.out.println("Enter the number of rows:");
        rows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        seats = Integer.parseInt(scanner.nextLine());

        RoomManager room = new RoomManager(rows, seats);
        room.printMenu();
        room.drawRoom();

        switchCondition = Integer.parseInt(scanner.nextLine());

        do{
            switch(switchCondition) {
                case 1:
                    //Show the seats.
                    room.printRoom();
                    room.printMenu();
                    switchCondition = Integer.parseInt(scanner.nextLine());
                    break;
                case 2:
                    //Buy a ticket.
                    room.ticketPrice();
                    room.printMenu();
                    switchCondition = Integer.parseInt(scanner.nextLine());
                    break;
                case 3:
                    room.cinemaStats();
                    room.printMenu();
                    switchCondition = Integer.parseInt(scanner.nextLine());
                    break;
                    //Show the statistics for the cinema.
                default:
                    break;
            }
        } while (switchCondition != 0);
    }
}
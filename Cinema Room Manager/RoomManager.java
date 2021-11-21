package cinema;

import java.util.Scanner;

public class RoomManager {
    char[][] room;
    int rows;
    int seats;
    int ticketPrice;
    int totalIncome;
    int ticketCounter = 0;
    int currentIncome = 0;
    int seatNumber, rowNumber;
    double percentageSold;
    Scanner scanner = new Scanner(System.in);

    RoomManager(int rows, int seats){
        this.rows = rows;
        this.seats = seats;
        this.room = new char[rows + 1][seats + 1];
        if(rows * seats < 60) {
            totalIncome = rows * seats * 10;
        } else {
            this.totalIncome = (rows / 2) * seats * 10 + (rows - rows / 2) * seats * 8;
        }
    }

    public void ticketPrice() {
        updateRoom();
        if(rows * seats < 60) {
            ticketPrice = 10;
        } else {
            if(Math.floorDiv(rows, 2) >= rowNumber) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        System.out.println("Ticket price: $" + ticketPrice);
        ticketCounter++;
        currentIncome += ticketPrice;
        percentageSold = ((double) ticketCounter / (rows * seats)) * 100.0;
    }

    public void printMenu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

    }

    public void updateRoom() {
        System.out.println("Enter a row number:");
        rowNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter a seat number in that row:");
        seatNumber = Integer.parseInt(scanner.nextLine());

        if(rowNumber > rows || seatNumber > seats){
            System.out.println("Wrong input!");
            updateRoom();
        }

        if(room[rowNumber][seatNumber] == 'B'){
            System.out.println("That ticket has already been purchased!");
            updateRoom();
        } else{
            room[rowNumber][seatNumber] ='B';
        }
    }

    public void printRoom() {
        System.out.println("Cinema: ");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                System.out.printf(room[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void drawRoom() {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if(i == 0) {
                    room[i][j] = Character.forDigit(j, 10);
                } else if(j == 0) {
                    room[i][j] = Character.forDigit(i, 10);
                } else {
                    room[i][j] = 'S';
                }
            }
        }
        room[0][0] = ' ';
    }

    public void cinemaStats() {
        System.out.println("Number of purchased tickets: " + ticketCounter);
        System.out.printf("Percentage: %.2f%%%n", percentageSold);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}

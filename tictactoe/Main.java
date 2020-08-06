package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input command: ");
        String [] inputs = scanner.nextLine().split(" ");
        String players = null;

        while(inputs[0].equals("start") && !inputs[0].equals("exit")){
            try{
                if(inputs[1].equals("easy") || inputs[1].equals("user") || inputs[1].equals("medium") ||
                        inputs[1].equals("hard")){
                    players = inputs[1];
                }
                else throw new Exception();

                if(inputs[2].equals("easy") || inputs[2].equals("user") || inputs[2].equals("medium") ||
                        inputs[2].equals("hard")){
                    players+= inputs[2];
                }
                else throw new Exception();
            }
            catch(Exception e){
                System.out.println("Bad parameters!");
                System.out.print("Input command: ");
                inputs = scanner.nextLine().split(" ");
            }

            if(!players.equals("")){
                switch(players){
                    case "easyeasy":
                    {
                        Board board = new Board();
                        board.printField();
                        System.out.println((board.checkWin()));
                        while(board.checkWin()){
                            board.easyAi();

                            if(board.checkWin()) {
                                board.easyAi();
                            }
                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "useruser":
                    {
                        Board board = new Board();
                        board.printField();
                        while(board.checkWin()){
                            board.userMove();

                            if(board.checkWin()) {
                                board.userMove();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "usereasy":
                    {
                        Board board = new Board();
                        board.printField();
                        while(board.checkWin()){
                            board.userMove();

                            if(board.checkWin()) {
                                board.easyAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "easyuser":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.easyAi();

                            if(board.checkWin()) {
                                board.userMove();
                            }
                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "easymedium":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.easyAi();

                            if(board.checkWin()) {
                                board.mediumAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "usermedium":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.userMove();

                            if(board.checkWin()) {
                                board.mediumAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "mediumuser":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.mediumAi();

                            if(board.checkWin()) {
                                board.userMove();
                            }
                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "mediummedium":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.mediumAi();

                            if(board.checkWin()) {
                                board.mediumAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "mediumeasy":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.mediumAi();

                            if(board.checkWin()) {
                                board.easyAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "userhard":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.userMove();

                            if(board.checkWin()) {
                                board.hardAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "harduser":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.hardAi();

                            if(board.checkWin()) {
                                board.userMove();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "hardhard":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.hardAi();

                            if(board.checkWin()) {
                                board.hardAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "mediumhard":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.mediumAi();

                            if(board.checkWin()) {
                                board.hardAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "hardmedium":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.hardAi();

                            if(board.checkWin()) {
                                board.mediumAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "easyhard":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.easyAi();

                            if(board.checkWin()) {
                                board.hardAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    case "hardeasy":
                    {
                        Board board = new Board();
                        board.printField();

                        while(board.checkWin()){
                            board.hardAi();

                            if(board.checkWin()) {
                                board.easyAi();
                            }

                        }

                        System.out.print("Input command: ");
                        inputs = scanner.nextLine().split(" ");
                        break;
                    }

                    default:
                        System.out.println("error");
                        inputs[0] = "exit";
                        break;
                }
            }

        }
    }
}
package encryptdecrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cipher c = new Cipher();
        String data = "";

        //Handles all of the command line arguments.
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                c.setMode(args[i+1]);
            }
            else if (args[i].equals("-key")) {
                c.setKey(Integer.parseInt(args[i + 1]));
            }
            else if(args[i].equals("-alg")){
                c.setAlg(args[i+1]);
            }
            else if (args[i].equals("-data")) {
                data = args[i+1];
                data = data.replace("\"", "");
                c.setPhrase(data.toCharArray());
            }
            else if(args[i].equals("-in")){
                c.setInputFile(args[i+1]);
                c.setInputCheck(true);
            }
            else if(args[i].equals("-out")){
                c.setOutputFile(args[i+1]);
                c.setOutputCheck(true);
            }
        }

        if(c.isInputCheck()){
            File file = new File(c.getInputFile());
            try (Scanner scanner = new Scanner(file)) {
                c.setPhrase(scanner.nextLine().toCharArray());
            }
            catch (IOException e) {
                System.out.println("No file found: " + c.getInputFile());
            }
        }

        // handles the conversion of the string based on the mode.
        if(c.getMode().equals("enc")){
            if(c.getAlg().equals("unicode")){
                c.unicode();
            }
            else if(c.getAlg().equals("shift")){
                c.shift();
            }
            else{
                c.shift();
            }
        }
        else if(c.getMode().equals("dec")){
            if(c.getAlg().equals("unicode")){
                c.setKey(c.getKey()*-1);
                c.unicode();
            }
            else if(c.getAlg().equals("shift")){
                c.setKey(c.getKey()*-1);
                c.shift();
            }
            else{
                c.setKey(c.getKey()*-1);
                c.shift();
            }
        }

        if(c.isOutputCheck()){
            try {
                FileWriter fileWriter = new FileWriter(c.getOutputFile());
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(c.getResult());
                printWriter.close();
            } catch (IOException e) {
                System.out.println("No file found: " + c.getOutputFile());
            }
        }
        else{
            System.out.println(c.getResult());
        }
    }
}

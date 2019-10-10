package encryptdecrypt;
public class Cipher {

    private String mode = "";
    private String alg = "";
    private int key = 0;

    private boolean inputCheck = false;
    private boolean outputCheck = false;

    private String inputFile = "";

    private String outputFile = "";

    private char[] phrase = {};
    private String result = "";


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isInputCheck() {
        return inputCheck;
    }

    public void setInputCheck(boolean inputCheck) {
        this.inputCheck = inputCheck;
    }

    public boolean isOutputCheck() {
        return outputCheck;
    }

    public void setOutputCheck(boolean outputCheck) {
        this.outputCheck = outputCheck;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public char[] getPhrase() {
        return phrase;
    }

    public void setPhrase(char[] phrase) {
        this.phrase = phrase;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    //Encrypts or decrypts based on the sign value of the shift.
    public void unicode() {
        String output = "";
        for (int i = 0; i < this.phrase.length; i++) {
            output += (char) (phrase[i] + this.key);
        }
        this.result = output;
    }

    //Shifting using a fixed alphabet and cesar cipher.
    public void shift() {
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        char[] alphaUpper = alphabetUpper.toCharArray();
        char[] alphaLower = alphabetLower.toCharArray();
        String output = "";
        int position = 0;

        for (int i = 0; i < this.phrase.length; i++) {
            if (Character.isLetter(this.phrase[i]) == true) {
                for (int j = 0; j < 26; j++) {
                    if (this.phrase[i] == alphaLower[j]) {
                        position = (j + key) % 26;
                        if (position < 0) {
                            position += 26;
                        }
                        output += alphaLower[position];

                    } else if (this.phrase[i] == alphaUpper[j]) {
                        position = (j + key) % 26;
                        if (position < 0) {
                            position += 26;
                        }
                        output += alphaUpper[position];
                    }
                }
            }
            else {
                output += this.phrase[i];
            }
        }
        this.result = output;
    }
}
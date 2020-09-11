import java.io.IOException;
import java.util.Scanner;

public class Driver {

    final static private int defaultCase = 10;

    public static void main(String[] args) {

        boolean exit = false;
        int selection = defaultCase;

        while(!exit){
            switch (selection) {
                case 1:
                    // Perform Vigenere cipher encryption
                    Vigenere vigenereEncryptor = new Vigenere();
                    try {
                        vigenereEncryptor.execute();
                    } catch (IOException e) {
                        System.err.println("Failed to execute Vigenere cipher encryption");
                        e.printStackTrace();
                    }
                    selection = defaultCase;
                    break;

                case 2:
                    // Perform Caesar cipher encryption
                    Caesar caesarEncryptor = new Caesar();
                    try {
                        caesarEncryptor.execute();
                        caesarEncryptor.findLetterFrequency();
                        caesarEncryptor.findBigramFrequency();
                    } catch (IOException e) {
                        System.err.println("Failed to execute Caesar cipher encryption");
                        e.printStackTrace();
                    }
                    selection = defaultCase;
                    break;

                case 3:
                    RSA rsa = new RSA();
                    rsa.execute();
                    selection = defaultCase;
                    break;

                case 0:
                    System.out.println("Exiting");
                    exit = true;
                    break;

                default:
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Press 1 for Vigenere cipher, 2 for Caesar cipher, 3 for RSA, 0 to exit");
                    selection = keyboard.nextInt();
            }

        }

    }


}

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        boolean exit = false;
        int selection = 3;

        while(!exit){
            switch (selection) {
                case 1:
                    // Perform Vigenere Cipher encryption
                    System.out.println("Doing Vigenere");
                    selection = 3;
                    break;

                case 2:
                    // Perform Caesar Cipher encryption
                    System.out.println("Doing Caesar");
                    selection = 3;
                    break;

                case 0:
                    System.out.println("Exiting");
                    exit = true;
                    break;

                default:
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Press 1 for Vigenere cipher, 2 for Caesar cipher, 0 to exit");
                    selection = keyboard.nextInt();
            }

        }

    }


}

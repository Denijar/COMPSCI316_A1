import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Vigenere {

    final private String inputTextFileName = "input/plaintext.txt";

    private String key;
    private String inputText;

    public Vigenere(){
        // Get encryption key
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the first 3 letters of your UPI");
        key = keyboard.nextLine();
    }

    public void execute() throws IOException {
        // Get text to encrypt
        BufferedReader br = new BufferedReader(new FileReader(inputTextFileName));
        while ((inputText = br.readLine()) == null){}
        System.out.println(inputText);

        // Cycle through the plain text, looping through the key
        int keyPosition = 0;
        String outputText = "";

        for (int i = 0; i < inputText.length(); i++){
            char c = inputText.charAt(i);
            //Process char
            System.out.print("" + Alphabet.getNum(c) + ",");
            // Loop through the key
            if(keyPosition == 2) keyPosition = 0;
            else keyPosition++;
        }

    }


}

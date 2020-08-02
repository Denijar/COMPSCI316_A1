import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vigenere {

    private String inputTextFileName = "input/plaintext.txt";
    private Character[] alphabetChar = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private List<Character> alphabet = Arrays.asList(alphabetChar);

    private String key;
    private String inputText;

    public Vigenere(){
        // Get encryption key
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the key");
        key = keyboard.nextLine();
    }

    public void execute() throws IOException {
        // Get text to encrypt
        BufferedReader br = new BufferedReader(new FileReader(inputTextFileName));
        while ((inputText = br.readLine()) == null){}
        System.out.println(inputText);

        int keyPosition = 0;
        String outputText = "";

        for (int i = 0; i < inputText.length(); i++){
            // Find index value of new character
            Character inputLetter = inputText.charAt(i);
            int totalNum = alphabet.indexOf(inputLetter) + alphabet.indexOf(key.charAt(keyPosition));
            int newNum = totalNum % 26;

            // Add character to the output
            outputText += alphabet.get(newNum);

            // Iterate through the key
            if(keyPosition == (key.length() - 1)) keyPosition = 0;
            else keyPosition++;
        }

        // Print the result
        System.out.println(outputText);

    }
}

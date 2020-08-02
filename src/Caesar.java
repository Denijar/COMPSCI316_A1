import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Caesar {

    private String inputTextFileName = "input/plaintext.txt";

    private Character[] alphabetChar = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private List<Character> alphabet = Arrays.asList(alphabetChar);

    private int key;
    private String inputText;

    public Caesar(){
        // Get encryption key
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a 3 digit number");
        int inputInt = keyboard.nextInt();
        if(inputInt % 26 == 0) key = 7;
        else key = inputInt % 26;
    }

    public void execute() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(inputTextFileName));
        while ((inputText = br.readLine()) == null){}
        System.out.println(inputText);

        String outputText = "";

        for (int i = 0; i < inputText.length(); i++){
            // Find the new index value for each character
            Character inputLetter = inputText.charAt(i);
            int totalNum = alphabet.indexOf(inputLetter) + key;
            int newNum = totalNum % 26;

            // Add character to the output
            outputText += alphabet.get(newNum);
        }

        System.out.println(outputText);
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Caesar {

    private final String inputTextFileName = "input/plaintext.txt";

    private final Character[] alphabetChar = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private final List<Character> alphabet = Arrays.asList(alphabetChar);

    private final int key;

    private String outputText;

    public Caesar(){
        // Get encryption key
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a 3 digit number (from your UPI)");
        int inputInt = keyboard.nextInt();
        if(inputInt % 26 == 0) key = 7;
        else key = inputInt % 26;
    }

    public void execute() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(inputTextFileName));
        String inputText;
        while ((inputText = br.readLine()) == null){}

        System.out.println("Input text:");
        System.out.println(inputText);

        outputText = "";

        for (int i = 0; i < inputText.length(); i++){
            // Find the new index value for each character
            Character inputLetter = inputText.charAt(i);
            int totalNum = alphabet.indexOf(inputLetter) + key;
            int newNum = totalNum % 26;

            // Add character to the output
            outputText += alphabet.get(newNum);
        }

        System.out.println("Output text:");
        System.out.println(outputText);
    }

    public void findLetterFrequency(){
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Iterate through every letter
        for (int i = 0; i < outputText.length(); i++){
            Character letter = outputText.charAt(i);
            if(frequencyMap.containsKey(letter)){
                frequencyMap.put(letter, frequencyMap.get(letter)+1);
            } else {
                frequencyMap.put(letter, 1);
            }
        }

        // Java 8 wizardry to list the letter frequencies
        System.out.println("Letter frequencies:");
        frequencyMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);
    }

    public void findBigramFrequency(){
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Iterate through every pair of adjacent letters
        for (int i = 0; i < outputText.length() - 1; i++){
            String bigram = String.valueOf(outputText.charAt(i)) + String.valueOf(outputText.charAt(i + 1));
            if(frequencyMap.containsKey(bigram)){
                frequencyMap.put(bigram, frequencyMap.get(bigram)+1);
            } else {
                frequencyMap.put(bigram, 1);
            }
        }

        // Java 8 wizardry to list the top 10 bigram frequencies
        System.out.println("Top 10 bigram frequencies:");
        frequencyMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(10).forEach(System.out::println);
    }
}

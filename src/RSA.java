import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    private int publicParameter;
    private int publicKey;
    private int privateKey;
    private int message;


    public RSA(){
        Scanner keyboard = new Scanner(System.in);
        // get the public parameter (n)
        System.out.println("Enter the public parameter (n)");
        publicParameter = keyboard.nextInt();

        // get the public key (e)
        System.out.println("Enter the public key (e)");
        publicKey = keyboard.nextInt();

        // get the private key (e)
        System.out.println("Enter the private key (d)");
        privateKey = keyboard.nextInt();

        // get the message to encrypt (m)
        System.out.println("Enter a number to encrypt (the number from your UPI, m)");
        message = keyboard.nextInt();
    }

    public void execute(){
        // calculate the cipher text
        BigInteger bigInteger = new BigInteger(String.valueOf(message));
        bigInteger = bigInteger.pow(publicKey);
        System.out.println(bigInteger);
        bigInteger = bigInteger.mod(new BigInteger(String.valueOf(publicParameter)));

        System.out.println("Cipher text value (c)");
        System.out.println(bigInteger);

        // convert back to the original message
        bigInteger = bigInteger.pow(privateKey);
        bigInteger = bigInteger.mod(new BigInteger(String.valueOf(publicParameter)));

        System.out.println("Original text (m):");
        System.out.println(bigInteger);
    }
}

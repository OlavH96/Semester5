import rsa.PrivateKey;
import rsa.PublicKey;
import rsa.RSA;

import java.math.BigInteger;

import static java.math.BigInteger.*;

/**
 * Created by faiter on 11/13/17.
 */
public class Oppgave4 {

    public static void main(String[] args) {

        PublicKey bobPublicKey = new PublicKey(13, 437);
        PrivateKey bobPrivateKey = new PrivateKey(23, 19, 61, 437);

        // 1
        System.out.println("\nopg 1");
        BigInteger message, sign;

        message = valueOf(78);
        sign = valueOf(394);
        System.out.println("Valid Signature: "+RSA.verfifySignature(message, sign, bobPublicKey));


        message = valueOf(123);
        sign = valueOf(289);
        System.out.println("Valid Signature: "+RSA.verfifySignature(message, sign, bobPublicKey));

        // 2
        System.out.println("\nopg 2");
        BigInteger y = valueOf(101);
        BigInteger x = RSA.encrypt(y.intValue(), bobPublicKey);

        System.out.println("Fake message: ["+x+", "+y+"]");
        System.out.println("Valid Signature: "+RSA.verfifySignature(x, y, bobPublicKey));

        // 3
        System.out.println("\nopg 3");

        BigInteger message1, sign1, message2, sign2, fakeMessage, fakeSign;

        message1 = valueOf(38);
        sign1 = valueOf(171);

        message2 = valueOf(97);
        sign2 = valueOf(337);

        fakeMessage = message1.multiply(message2).mod(bobPublicKey.getN());
        fakeSign = sign1.multiply(sign2).mod(bobPublicKey.getN());
        System.out.println("Fake message: ["+fakeMessage+", "+fakeSign+"]");

        System.out.println("Valid Signature: "+RSA.verfifySignature(fakeMessage, fakeSign, bobPublicKey));

        // 4
        System.out.println("\nopg 4");

        PublicKey alicePublicKey = new PublicKey(283, 17 * 43);
        PrivateKey alicePrivateKey = new PrivateKey(17, 43, 19, 17 * 43);

        BigInteger aliceEncrypted = RSA.encrypt(109, bobPublicKey);
        BigInteger aliceSign = RSA.sign(aliceEncrypted, alicePrivateKey);

        System.out.println("Decrypted: "+RSA.decrypt(aliceEncrypted, bobPrivateKey));
        System.out.println("Valid Signature: "+RSA.verfifySignature(aliceEncrypted, aliceSign, alicePublicKey));

    }
}
import elGamal.*;

import static java.math.BigInteger.valueOf;

/**
 * Created by faiter on 11/13/17.
 */
public class Oppgave5 {

    public static void main(String[] args) {

        int alpha, beta, a, p;

        alpha = 13;
        beta = 29;
        p = 37;
        a = 15;

        // 1
        System.out.println("\nopg 1");

        KeyPair keyPair = ElGamal.generateKeyPair(p, alpha, beta, a);
        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();
        System.out.println(keyPair);

        // 2
        System.out.println("\nopg 2");

        int message, k;

        message = 14;
        k = 3;

        System.out.println(ElGamal.sign(valueOf(message), k, privateKey, publicKey));

        message = 11;
        k = 5;
        System.out.println(ElGamal.sign(valueOf(message), k, privateKey, publicKey));

        // 3
        System.out.println("\nopg 3");

        message = 32;
        ElGamalSignature signature = new ElGamalSignature(valueOf(19), valueOf(6));

        System.out.println(ElGamal.verifySignature(valueOf(message), signature, publicKey));

        message = 9;
        signature = new ElGamalSignature(valueOf(32), valueOf(16));
        System.out.println(ElGamal.verifySignature(valueOf(message), signature, publicKey));
    }
}
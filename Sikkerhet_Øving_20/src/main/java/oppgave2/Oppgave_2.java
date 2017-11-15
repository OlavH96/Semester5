package oppgave2;

import rsa.KeyPair;
import rsa.PrivateKey;
import rsa.PublicKey;
import rsa.RSA;
import util.NumberGenerator;

import java.math.BigInteger;

/**
 * Created by faiter on 11/3/17.
 */
public class Oppgave_2 {

    public static void main(String[] args) {

        int p = NumberGenerator.generatePrime(8);
        int q = NumberGenerator.generatePrime(8);

        System.out.println(Integer.toBinaryString(p)+": "+p);
        System.out.println(Integer.toBinaryString(q)+": "+q);

        KeyPair keyPair = RSA.generateKeyPair(p, q);

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        System.out.println(keyPair);

        BigInteger encrypt = RSA.encrypt(42, publicKey);
        System.out.println("Encrypted: "+encrypt);

        BigInteger decrypt = RSA.decrypt(encrypt, privateKey);

        System.out.println("Decrypted: "+decrypt);
    }
}
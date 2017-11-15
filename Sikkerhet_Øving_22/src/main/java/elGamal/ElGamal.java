package elGamal;

import util.ModUtil;

import java.math.BigInteger;

import static java.lang.Math.pow;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static util.ModUtil.inverse;

/**
 * Created by faiter on 11/10/17.
 */
public class ElGamal {

    public static KeyPair generateKeyPair(int p, int alpha, int beta, int a){

        PublicKey publicKey = new PublicKey(p, alpha, beta);

        PrivateKey privateKey = new PrivateKey(a);

        return new KeyPair(privateKey, publicKey);
    }

    public static Message encrypt(int x, int k, PublicKey publicKey){

        int alpha = publicKey.getAlpha();
        int beta = publicKey.getBeta();
        int p = publicKey.getP();

        return new Message((int) pow(alpha, k) % p, x*(int) pow(beta,k) % p);

    }
    public static int decrypt(Message message, PrivateKey privateKey, int p){

        int a = privateKey.getA();

        int aPowK = message.getaPowK(); // alpha^k
        int xBPowK = message.getxBPowK(); // x*beta^k

        int alphaPowKPowA = (int) pow(aPowK, a) % p;
        int inverse = inverse(alphaPowKPowA, p);

        int i = (xBPowK * inverse) % p;

        return i;

    }
    public static ElGamalSignature sign(BigInteger message, int k, PrivateKey privateKey, PublicKey publicKey){

        BigInteger alpha = BigInteger.valueOf(publicKey.getAlpha());
        BigInteger p = valueOf(publicKey.getP());
        BigInteger a = valueOf(privateKey.getA());

        BigInteger gamma = alpha.pow(k).mod(p);

        BigInteger inverse = valueOf(ModUtil.inverse(k, publicKey.getP()));

        BigInteger delta = message.subtract(a.multiply(gamma)).multiply(inverse).mod(p.subtract(ONE));

        return new ElGamalSignature(gamma, delta);
    }

    public static boolean verifySignature(BigInteger message, ElGamalSignature signature, PublicKey key){

        int messageInt = message.intValue();

        BigInteger p = valueOf(key.getP());
        BigInteger beta = valueOf(key.getBeta());
        BigInteger alpha = valueOf(key.getAlpha());

        BigInteger gamma = signature.getGamma();
        int gammaInt = gamma.intValue();
        BigInteger delta = signature.getDelta();
        int deltaInt = delta.intValue();

        BigInteger congruence = alpha.pow(messageInt);

        return beta.pow(gammaInt).multiply(gamma.pow(deltaInt)).mod(p).equals(congruence);
    }

    public static void main(String[] args) {

        int p, alpha, beta, a, k, message;
        p = 29;
        alpha = 11;
        beta = 16;
        a = 8;
        k = 3;
        message = 4;

        KeyPair keyPair = generateKeyPair(p, alpha, beta, a);
        System.out.println(keyPair);

        Message encrypt = encrypt(message, k, keyPair.getPublicKey());
        System.out.println(encrypt);

        /*int alphaPowKPowA = (int) pow(encrypt.getaPowK(), a) % p;
        int alphaPowKPowAInverse = inverse(alphaPowKPowA, p);
        System.out.println((encrypt.getxBPowK() * alphaPowKPowAInverse) % p);
*/

        int decrypt = decrypt(encrypt, keyPair.getPrivateKey(), p);
        System.out.println("Decrypted: "+decrypt);




    }
}

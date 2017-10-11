import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by faiter on 9/13/17.
 */
public class RSA {

    public static int R(int num, int exp, int mod){

        BigInteger numB = BigInteger.valueOf(num);
        BigInteger modB = BigInteger.valueOf(mod);

        return numB.pow(exp).mod(modB).intValue(); // num^exp % mod, får overflow med int eller long
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        int encrypted = 66514; // kryptert med public key

        int exponent = 17; // private key d
        int mod = 86609;


        System.out.println(R(encrypted, exponent, mod));
        //System.out.println(decrypt(encrypted, pubKey));
    }
}
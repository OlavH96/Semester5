package rsa;

import util.MathUtil;

import java.math.BigInteger;

/**
 * Created by faiter on 11/3/17.
 */
public class RSA {

    public static KeyPair generateKeyPair(int p, int q){

        int n = p*q;
        int phiN = ( (p-1) * (q-1) );

        int e = ( findE(phiN) ); // b
        int d = ( findD(e, phiN) ); // a

        System.out.println("coprime: "+((e*d) % phiN));

        PublicKey publicKey = new PublicKey(e, n);
        PrivateKey privateKey = new PrivateKey(p, q, d, n);

        return new KeyPair(privateKey, publicKey);
    }

    public static BigInteger encrypt(int x, PublicKey key){

        BigInteger e = key.getE();
        BigInteger n = key.getN();

        System.out.println(key);

        return BigInteger.valueOf(MathUtil.squareAndMultiply(x, Integer.toBinaryString(x).length(), e.intValue(), n.intValue())); //xBig.pow(e.intValue()).mod(n);
    }

    public static BigInteger decrypt(BigInteger y, PrivateKey key){

        BigInteger d = key.getD();
        BigInteger n = key.getN();

        System.out.println(key);

        return BigInteger.valueOf(MathUtil.squareAndMultiply(y.intValue(), y.bitLength(), d.intValue(), n.intValue()));//y.pow(d.intValue()).mod(n); // y^d % n
    }

    private static int findE(int phiN){
        int gcd = 4; // større enn 3
        while (MathUtil.gcd(phiN, gcd) != 1){
          gcd++;
        }
        return gcd;
    }
    private static int findD(int e, int phiN){
        int d = 1;
        while ( (d*e) % phiN != 1 ){
            d++;
        }
        return d;
    }

    public static void main(String[] args) {

        int a = findD(13, 360);

        System.out.println(a);

    }
}

package util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by faiter on 11/7/17.
 */
public class NumberGenerator {

    public static int generatePrime(int bits){

        int nr;
        do {
            nr = BigInteger.probablePrime(bits, new SecureRandom()).intValue();
        }while (!MathUtil.isPrime(nr));


        return nr;

    }

    public static void main(String[] args) {

        int prime = generatePrime(8);

        System.out.println(prime);
        System.out.println(Integer.toBinaryString(prime));

    }
}

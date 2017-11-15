package elGamal;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;
import static java.math.BigInteger.valueOf;

/**
 * Created by faiter on 11/10/17.
 */
public class ShanksAlgorithm {

    public static void calculate(int alpha, int beta, int p){

        int m = (int) ceil(sqrt(p));
        System.out.println("m: "+m);

        Map<Integer, BigInteger> js = new HashMap<>();

        System.out.println(js);

        for (int j = 0; j < m - 1; j++) {

            BigInteger pow = valueOf(alpha).modPow(valueOf(m * j), valueOf(p) );

            js.put(j, pow);
        }

        Map<Integer, BigInteger> jsSorted = js.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Js Sorted: "+jsSorted);

        SortedMap<Integer, BigInteger> js2 = new TreeMap<>(Comparator.comparing(integer -> integer));
        for (int i = 0; i < m - 1; i++) {

            BigInteger bigI = valueOf(i);

            BigInteger pow = valueOf(beta).multiply(valueOf(alpha)).modPow(bigI.negate(), valueOf(p));

            js2.put(i, pow);
        }

        /*js2.
        Map<Integer, BigInteger> js2Sorted = js2.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Js2 Sorted: "+js2Sorted);

        Set<Map.Entry<Integer, BigInteger>> jsEntries = jsSorted.entrySet();
        Set<Map.Entry<Integer, BigInteger>> js2Entries = js2Sorted.entrySet();

        Map.Entry<Integer, BigInteger> jy = null;
        Map.Entry<Integer, BigInteger> iy = null;


        for (Map.Entry<Integer, BigInteger> js2Entry : js2Entries) {

            for (Map.Entry<Integer, BigInteger> jsEntry : jsEntries) {

                if (js2Entry.getValue().equals(jsEntry.getValue())){

                    System.out.println("Same entries!");
                    jy = js2Entry;
                    iy = jsEntry;
                    break;
                }
            }
        }

        if (jy == null || iy    == null) return;

        Integer j = jy.getKey();
        Integer i = iy.getKey();
        BigInteger y = jy.getValue();

        System.out.println("log alpha beta <- "+(m*j + i) +" mod "+p);
*/
    }

    public static PrivateKey bruteForce(PublicKey publicKey){

        int alpha = publicKey.getAlpha();
        int beta = publicKey.getBeta();
        int p = publicKey.getP();

        return new PrivateKey(bruteForce(alpha, beta, p));
    }
    public static int bruteForce(int alpha, int beta, int n){

        int aGuess = 0;
        // alpha ^ a === beta % p
        while (pow(alpha, ++aGuess) % n != beta);

        return aGuess;
    }

    public static void main(String[] args) {

        int p, alpha, beta, a;
        p = 19;
        alpha = 13;
        beta = 14;
        a = 5;

        KeyPair keyPair = ElGamal.generateKeyPair(p, alpha, beta, a);
        System.out.println(keyPair);

        PrivateKey privateKey = bruteForce(keyPair.getPublicKey());
        System.out.println(privateKey);

        p = 29;
        alpha = 11;
        beta = 16;
        a = 8;

        keyPair = ElGamal.generateKeyPair(p, alpha, beta, a);
        System.out.println(keyPair);
        privateKey = bruteForce(keyPair.getPublicKey());
        System.out.println(privateKey);

        p = 53;
        alpha = 21;
        beta = 26;

        System.out.println(bruteForce(alpha, beta, p));

        calculate(alpha, beta, p);

        // 21^-1 mod 53 == 32^-1 mod 53

    }
}

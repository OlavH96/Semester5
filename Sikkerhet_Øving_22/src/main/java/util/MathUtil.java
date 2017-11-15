package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by faiter on 11/2/17.
 */
public class MathUtil {

    /**
     * Starter bakfra
     */
    public static int getBit(int nr, int position) {
        return (nr >> position) & 1;

        // 10 >> 1 = 1 & 1 == 1
    }

    /**
     * @param length Length of number c in binary, ex: c=15 -> 1111 -> 4 length
     * @return result of x^c mod n
     */
    public static int squareAndMultiply(int x, int length, int c, int n){

        int z = 1;

        for (int i = length-1; i >= 0 ; i--) { // getbit går bakfra, må reversere loopen

            z = (z*z) % n;
            //System.out.println("z² % n = "+z);

            //System.out.println("bit "+i+" : "+getBit(c,i));
            if (getBit(c, i) == 1){
                z = (z*x) % n;
                //System.out.println("z*x % n = "+z);
            }

        }
        return z;
    }

    public static BigInteger fact(BigInteger b){

        if(b.intValue() == 1) return BigInteger.valueOf(1);

        return b.multiply(fact(b.subtract(BigInteger.valueOf(1))));
    }

    /**
     * @param n Number to guess factor in
     * @param B Guess
     * @return A factor in the number n
     */
    public static int pollard_p_minius_1(int n, int B){

        BigInteger a = BigInteger.valueOf(2);
        BigInteger j = BigInteger.valueOf(B);
        //for(int j = 2; j <= B; j++) {

        a = a.modPow(fact(j), BigInteger.valueOf(n));

        System.out.println(a);
          /*  a = ( (int) pow(a, j) ) % n;
            System.out.print(a+", ");
        //}
        System.out.println("\nB: "+B);*/

        int d = gcd(a.intValue()-1, n);

        if( d > 1 && d < n){
            return d;
        }
        else{
            System.out.println("Pollard p-1 failed: [n: "+n+", B: "+B+", d:"+d+"]");
            return -1;
        }
    }

    /**
     *
     * @param f Function to use for calculation
     * @param n Number to find factor in
     * @param x1 First x value
     * @return
     */
    public static int pollard_rho(Function<Integer, Integer> f, int n, int x1){

        f = f.andThen(integer -> integer % n); // alt er i zn

        BiFunction<Integer, Integer, Integer> gcd = MathUtil::gcd;
        gcd = gcd.andThen(integer -> integer % n);

        //System.out.println("n: "+n+", x1: "+x1);


        int x2 = f.apply(x1);

        //System.out.println("x2: "+x2);
        int d = gcd.apply(x2 - x1, n);

        List<Integer> xjs = new ArrayList<>();
        xjs.add(x2);

        int j = 0;
        while (d == 1){

            x1 = f.apply(x1);
            xjs.add(j++, x1);

            x1 = f.apply(x1);
            xjs.add(j++, x1);

            //System.out.println(xjs);

            d = gcd.apply(( x1 - xjs.get((j-1)/2) ), n);
            //System.out.println("d: "+d);
        }

        if (d == n){
            System.out.println("FAILURE");
            return -1;
        }
        else{
            System.out.println("Iterations: "+j);
            return d < 0 ? -d: d; // success
        }
    }

    public static int mod(int x, int y) {
        int result = x % y;
        if (result < 0)
        {
            result += y;
        }
        return result;
    }

    public static int gcd(int p, int q) {

        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}

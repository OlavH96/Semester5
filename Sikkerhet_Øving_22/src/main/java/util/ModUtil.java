package util;

/**
 * Created by faiter on 11/10/17.
 */
public class ModUtil {

    public static int inverse(int nr, int mod){

        if (MathUtil.gcd(nr, mod) != 1){
            System.out.println("No Inverse for nr "+nr+" in mod "+mod);
            return -1;
        }

        int inverse = 0;

        while (nr*++inverse % mod != 1);

        return inverse;
    }

    public static void main(String[] args) {

        int nr = 11;
        int mod = 23;
        int inverse = inverse(nr, mod);

        System.out.println(inverse);
        System.out.println(nr*inverse % mod);

    }
}

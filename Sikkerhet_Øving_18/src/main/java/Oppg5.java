import java.util.function.Function;

import static java.lang.Integer.toBinaryString;

/**
 * Created by faiter on 11/1/17.
 */
public class Oppg5 {

    public static void main(String[] args) {

        Function<Integer, Integer> h = i -> Hasher.squareHashBinary(i, 4);

        int k = 0b1001;
        int ipad = 0b0011;
        int opad = 0b0101;
        int x = 0b0110;

        System.out.println("HMAC for 0"+ toBinaryString(x)+": 0"+ toBinaryString(HMAC.HMAC(h, k, x, ipad, opad)));


    }
}

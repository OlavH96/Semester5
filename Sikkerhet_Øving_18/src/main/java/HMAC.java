import java.util.function.Function;

import static java.lang.Integer.*;
import static java.lang.String.valueOf;

/**
 * Created by faiter on 10/30/17.
 */
public class HMAC {

    public static int concat(int b1, int b2, int length){

        return (b1 << length) | b2;

    }

    public static int HMAC(Function<Integer, Integer> h, int k, int x, int ipad, int opad){

        return h.apply(concat((k ^ opad), ( h.apply(concat((k ^ ipad), x, 4)) ), 4));

    }
    public static int CBC_MAC(Function<Integer, Integer> h, int x, String plus){


        int IV = 0b0000_0000_0000_0000;
        int y = IV;

        String binaryString = plus+toBinaryString(x);
        //System.out.println(binaryString);

        for (int i = 0; i < binaryString.length(); i++) {
            int ch = parseInt(valueOf(binaryString.charAt(i)));
            //System.out.println(ch);
            y = h.apply( y ^ ch);
        }

        return y;
    }

    public static void main(String[] args) {

        Function<Integer, Integer> h = i -> Hasher.squareHashBinary(i, 4);

        int k = 0b1001;
        int ipad = 0b0011;
        int opad = 0b0101;
        int x = 0b0110;

        System.out.println("HMAC for 0"+ toBinaryString(x)+": 0"+ toBinaryString(HMAC(h, k, x, ipad, opad)));


        x = 0b0111;
        System.out.println("HMAC for 0"+ toBinaryString(x)+": 00"+ toBinaryString(HMAC(h, k, x, ipad, opad)));


        Function<Integer, Integer> hCaesar = i -> (i+3) % ((int) Math.pow(2, 4));

        x = 0b1101_1111_1010_0001;
        int xDot = 0b0010_1100_0001_1111;

        System.out.println("CBC_MAC x: "+toBinaryString(CBC_MAC(hCaesar, x,"")));
        System.out.println("CBC_MAC x': 0"+toBinaryString(CBC_MAC(hCaesar, xDot,"00")));
    }
}

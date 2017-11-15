package oppgave1; /**
 * Created by faiter on 11/2/17.
 */

import util.MathUtil;

public class Oppgave_1 {

    public static void main(String[] args) {

        int nr, exp, length, mod;

        nr = 23;
        exp = 27; //11011
        length = Integer.toBinaryString(exp).length();
        mod = 89;
        System.out.println(nr+"^"+exp+" mod "+mod+":\t\t"+ MathUtil.squareAndMultiply(nr, length, exp, mod));

        nr = 23;
        exp = 122; // 1111010
        length = Integer.toBinaryString(exp).length();
        mod = 89;
        System.out.println(nr+"^"+exp+" mod "+mod+":\t\t"+ MathUtil.squareAndMultiply(nr, length, exp, mod));

        nr = 17;
        exp = 84; // 1010100
        length = Integer.toBinaryString(exp).length();
        mod = 93;
        System.out.println(nr+"^"+exp+" mod "+mod+":\t\t"+ MathUtil.squareAndMultiply(nr, length, exp, mod));

        nr = 2991;
        exp = 388; // 110000100
        length = Integer.toBinaryString(exp).length();
        mod = 5912;
        System.out.println(nr+"^"+exp+" mod "+mod+":\t"+ MathUtil.squareAndMultiply(nr, length, exp, mod));



    }
}

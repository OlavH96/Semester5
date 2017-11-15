package oppgave3;

import util.MathUtil;

/**
 * Created by faiter on 11/4/17.
 */
public class Oppgave_3 {

    public static void main(String[] args) {

        int n = 1829;
        int B = 5;

        int factor = MathUtil.pollard_p_minius_1(n, B);
        int otherFactor = n / factor;
        System.out.println("Factor: "+ factor);
        System.out.println("Other factor: "+ otherFactor);
        System.out.println(factor+"*"+ otherFactor +"="+factor*otherFactor);

        System.out.println();

        /* Oppgave 2

        n1 = 18779 = 89 * 211
        n2 = 42583 = 97 * 439

        p-1 = 88 || 210, p-1 deler B!

        88 = 2 * 2 * 2 * 11
        B == 11

        210
        105 2
        35 3
        7 5
         = 2 * 3 * 5 * 7

        B = 7 -> B! = 5040 -> B! / 210 = 24
        97-1 = 96

        96 = 2 * 2 * 2 * 2 * 2 * 3
        B = 3

        438
        2*3*73

        p-1 = 96 || 438, p-1 deler B!
        B = 8 -> B! = 40320 -> B! / 96 = 420
         */
        System.out.println("18779: "+MathUtil.pollard_p_minius_1(18779, 7));
        System.out.println("42583: "+MathUtil.pollard_p_minius_1(42583, 2));

        n = 6319; // 6319;
        B = 8; // 4

        int answer = MathUtil.pollard_p_minius_1(n, B);
        System.out.println("Factor: "+answer);
        int otherfactor = n/answer;
        System.out.println("Other factor: "+otherfactor);

        System.out.println(answer+"*"+otherfactor+"="+answer*otherfactor);

       /*
        while (answer == -1 && B < 10){
            B++;
            answer = MathUtil.pollard_p_minius_1(n, B);
        }

        System.out.println(B);*/




    }
}
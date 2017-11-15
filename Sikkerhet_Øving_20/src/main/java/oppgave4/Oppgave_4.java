package oppgave4;

import util.MathUtil;

import java.util.function.Function;

/**
 * Created by faiter on 11/5/17.
 */
public class Oppgave_4 {

    public static void main(String[] args) {

        Function<Integer, Integer> f = x -> (x*x) + 1;

        int x1, n;

        x1 = 1;
        n = 851;
        findFactor(f, n, x1);

        x1 = 1;
        n = 1517;
        findFactor(f, n, x1);

        x1 = 1;
        n = 31861;
        findFactor(f, n, x1);
    }
    private static void findFactor(Function<Integer, Integer> f, int n, int x1){

        System.out.println("n:" +n);

        int factor = MathUtil.pollard_rho(f, n, x1);

        int otherFactor = n / factor;
        System.out.println("Faktor: "+ factor);
        System.out.println("Other factor: "+ otherFactor);
        System.out.println(factor+"*"+ otherFactor +" = "+factor*otherFactor);

        if (n != factor*otherFactor) System.out.println("FAILED");

        System.out.println();
    }
}

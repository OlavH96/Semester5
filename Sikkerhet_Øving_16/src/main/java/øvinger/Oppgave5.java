package øvinger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by faiter on 10/25/17.
 */
public class Oppgave5 {

    private static String xor(String first, String second){

        String shortest = first.length() < second.length():

        String out = "";



    }

    private static String K(String K, int nr){

        switch (nr){
            case 1:
                return String.valueOf(K.substring(0, 6));
            case 2:
                return String.valueOf(K.substring(2, 8));
            case 3:
                return String.valueOf(K.substring(4, 10));
            case 4:
                return String.valueOf(K.substring(6, 12));
            default:
                return "0";
        }
    }

    public static String pi_S(String toSubstitute){

        System.out.println("to substitute: "+toSubstitute);

        Map<String, String> map = new HashMap<>();

        map.put("000", "010");
        map.put("001", "100");
        map.put("010", "000");
        map.put("011", "011");
        map.put("100", "001");
        map.put("101", "110");
        map.put("110", "111");
        map.put("111", "101");

        StringBuilder out = new StringBuilder();

        try {
            String substring = toSubstitute.substring(0, 3);
            String substring1 = toSubstitute.substring(3, 6);

            System.out.println("s1: "+substring);
            System.out.println("s2: "+substring1);

            out.append(map.get(substring));
            out.append(map.get(substring1));
        }
        catch(IndexOutOfBoundsException e){/*Ignore it*/}

        return out.toString();
    }

    public static String pi_P(String toPermutate){

        StringBuilder out = new StringBuilder();

        System.out.println("to Permutate: "+toPermutate);

        String _1 = toPermutate.substring(0, 1);
        String _2 = toPermutate.substring(1, 2);
        String _3 = toPermutate.substring(2, 3);
        String _4 = toPermutate.substring(3, 4);
        String _5 = toPermutate.substring(4, 5);
        String _6 = toPermutate.substring(5, 6);

        out.append(_3);
        out.append(_1);
        out.append(_5);
        out.append(_2);
        out.append(_4);
        out.append(_6);

        return out.toString();
    }

    public static String encrypt(String toEncrypt, int l, int m, int nr, String K){

        String w = toEncrypt;

        String u;
        String v = "";

        int y;

        for (int r = 1; r <= nr - 1; r++) {

            int w_r_minus_1 = Integer.parseInt(w.substring(r - 1, r));
            int k_r = Integer.parseInt(K(K, r));

            System.out.println("w^r-1: "+w_r_minus_1+" - k^r: "+k_r);

            u = String.valueOf( w_r_minus_1 ^ k_r );

            for (int i = 1; i < m; i++) {

                System.out.println("u: "+u);
                System.out.println("v pi_S: "+pi_S(u));
                v = pi_S(u);
            }
            System.out.println("w: "+pi_P(v));
            w = pi_P(v);
        }

        int substring = Integer.parseInt(w);
        int k = Integer.parseInt(K(K, nr));

        System.out.println("w: "+substring+" - k: "+ k );
        System.out.println((substring ^ k));

        u = String.valueOf((substring ^ k));

        System.out.println("u = w^k: "+u);

        for (int i = 1; i < m; i++) {
            System.out.println("v pi_S: "+pi_S(u));
            v = pi_S(u);
        }

        System.out.println("v: "+v);

        int c = Integer.parseInt(v);
        int k1 = Integer.parseInt(K(K, nr+1));

        y = c ^ k1;

        return Integer.toString(y);
    }

    public static void main(String[] args) {

        int l = 2;
        int m = 3;
        int nr = 3;

        String K = "011100011011";

        String toEncrypt = "011100";

        System.out.println("k: "+K);
        System.out.println("k1: "+K(K, 1));
        System.out.println("k2: "+K(K, 2));
        System.out.println("k3: "+K(K, 3));
        System.out.println("k4: "+K(K, 4));

        System.out.println("To Encrypt: "+toEncrypt);

        System.out.println("y: "+encrypt(toEncrypt, l, m, nr, K));
    }
}

package rest.util;

import java.util.Arrays;

/**
 * Created by faiter on 9/21/17.
 */
public class TokenGenerator {

    public static String generate(String seed){

        return new StringBuilder(seed).reverse().append(".").append(seed.hashCode()).append(Arrays.toString(seed.getBytes())).toString();

    }
    public static boolean validate(String token){

        String s = new StringBuilder(token.split("\\.")[0]).reverse().toString();

        return token.equals(generate(s));
    }

    public static void main(String[] args) {

        String token = generate("olavh");

        System.out.println(token);

        System.out.println(validate(token));

    }
}
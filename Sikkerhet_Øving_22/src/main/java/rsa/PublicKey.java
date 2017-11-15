package rsa;

import java.math.BigInteger;

/**
 * Created by faiter on 11/3/17.
 */

public class PublicKey {

    private BigInteger e,n;

    public PublicKey(int e, int n) {

        this.e = BigInteger.valueOf(e);
        this.n = BigInteger.valueOf(n);
    }

    public BigInteger getE() {

        return e;
    }

    public BigInteger getN() {

        return n;
    }

    @Override
    public String toString() {
        return "PublicKey{" + "e=" + e + ", n=" + n + '}';
    }
}
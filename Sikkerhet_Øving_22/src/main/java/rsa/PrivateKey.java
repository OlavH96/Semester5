package rsa;


import java.math.BigInteger;

/**
 * Created by faiter on 11/3/17.
 */

public class PrivateKey {

    private BigInteger n, d, p, q;

    public PrivateKey(int p, int q, int d, int n) {

        this.d = BigInteger.valueOf(d);
        this.p = BigInteger.valueOf(p);
        this.q = BigInteger.valueOf(q);
        this.n = BigInteger.valueOf(n);
    }

    public BigInteger getD() {

        return d;
    }

    public BigInteger getP() {

        return p;
    }

    public BigInteger getQ() {

        return q;
    }

    public BigInteger getN() {

        return n;
    }

    @Override
    public String toString() {

        return "PrivateKey{" + "d=" + d + ", p=" + p + ", q=" + q + '}';
    }
}

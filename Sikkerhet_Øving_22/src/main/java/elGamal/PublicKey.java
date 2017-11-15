package elGamal;

/**
 * Created by faiter on 11/10/17.
 */
public class PublicKey {

    private int p, alpha, beta;

    public PublicKey(int p, int alpha, int beta) {

        this.p = p;
        this.alpha = alpha;
        this.beta = beta;
    }

    public int getP() {
        return p;
    }
    public int getAlpha() {
        return alpha;
    }
    public int getBeta() {
        return beta;
    }

    @Override
    public String toString() {

        return "PublicKey{" + "p=" + p + ", alpha=" + alpha + ", beta=" + beta + '}';
    }
}

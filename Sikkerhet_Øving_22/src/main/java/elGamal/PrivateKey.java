package elGamal;

/**
 * Created by faiter on 11/10/17.
 */
public class PrivateKey {

    private int a;

    public PrivateKey(int a) {

        this.a = a;
    }

    public int getA() {

        return a;
    }

    @Override
    public String toString() {

        return "PrivateKey{" + "a=" + a + '}';
    }
}

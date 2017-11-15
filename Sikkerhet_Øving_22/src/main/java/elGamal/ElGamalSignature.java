package elGamal;

import java.math.BigInteger;

/**
 * Created by faiter on 11/13/17.
 */
public class ElGamalSignature {

    BigInteger gamma, delta;

    public ElGamalSignature(BigInteger gamma, BigInteger delta) {

        this.gamma = gamma;
        this.delta = delta;
    }

    public BigInteger getGamma() {

        return gamma;
    }

    public BigInteger getDelta() {

        return delta;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElGamalSignature that = (ElGamalSignature) o;

        if (gamma != null ? !gamma.equals(that.gamma) : that.gamma != null) return false;
        return delta != null ? delta.equals(that.delta) : that.delta == null;
    }

    @Override
    public int hashCode() {

        int result = gamma != null ? gamma.hashCode() : 0;
        result = 31 * result + (delta != null ? delta.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "ElGamalSignature{" + "gamma=" + gamma + ", delta=" + delta + '}';
    }
}

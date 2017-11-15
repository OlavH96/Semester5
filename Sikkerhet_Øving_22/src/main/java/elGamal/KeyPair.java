package elGamal;

/**
 * Created by faiter on 11/10/17.
 */
public class KeyPair {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyPair(PrivateKey privateKey, PublicKey publicKey) {

        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {

        return privateKey;
    }

    public PublicKey getPublicKey() {

        return publicKey;
    }

    @Override
    public String toString() {

        return "KeyPair{" + "privateKey=" + privateKey + ", publicKey=" + publicKey + '}';
    }
}


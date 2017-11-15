import elGamal.ElGamal;
import elGamal.KeyPair;
import elGamal.Message;

/**
 * Created by faiter on 11/10/17.
 */
public class Oppgave2 {

    public static void main(String[] args) {

        //       alpha^a  beta mod p
        // p=19, 13^5 === 14 mod 19

        int p, alpha, beta, a, k, message;
        p = 19;
        alpha = 13;
        beta = 14;
        a = 5;

        KeyPair keyPair = ElGamal.generateKeyPair(p, alpha, beta, a);
        System.out.println(keyPair);

        message = 3;
        k = 6;

        System.out.println(ElGamal.encrypt(message, k, keyPair.getPublicKey()));

        message = 17;
        k = 4;

        System.out.println(ElGamal.encrypt(message, k, keyPair.getPublicKey()));
        int decrypt = ElGamal.decrypt(new Message(12, 11), keyPair.getPrivateKey(), p);
        System.out.println(decrypt+" - "+String.valueOf((char)(decrypt+'a')));

        decrypt = ElGamal.decrypt(new Message(2, 8), keyPair.getPrivateKey(), p);
        System.out.println(decrypt+" - "+String.valueOf((char)(decrypt+'a')));
    }
}
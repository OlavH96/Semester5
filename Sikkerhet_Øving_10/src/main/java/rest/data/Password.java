package rest.data;

import rest.util.PBKDF2;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by faiter on 9/20/17.
 */
public class Password {

    private byte[] encrypted;
    private byte[] salt;

    public Password() {}

    public Password(byte[] encrypted, byte[] salt) {

        this.encrypted = encrypted;
        this.salt = salt;
    }

    public static Password generate(String password) {

      PBKDF2 crypt = new PBKDF2();

        try {
            byte[] salt = crypt.generateSalt();
            byte[] encryptedPassword = crypt.getEncryptedPassword(password, salt);

            return new Password(encryptedPassword, salt);
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public byte[] getEncrypted() {

        return encrypted;
    }

    public void setEncrypted(byte[] encrypted) {

        this.encrypted = encrypted;
    }

    public byte[] getSalt() {

        return salt;
    }

    public void setSalt(byte[] salt) {

        this.salt = salt;
    }

}

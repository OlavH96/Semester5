package rest.data;

import rest.util.PBKDF2;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by faiter on 9/20/17.
 */
public class User {

    private String username;
    private Password password;

    public User(){}

    public User(String username, Password password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public Password getPassword() {

        return password;
    }

    public void setPassword(Password password) {

        this.password = password;
    }

    public boolean authenticate(String password){

        PBKDF2 crypt = new PBKDF2();

        Password password1 = getPassword();

        try {
            return crypt.authenticate(password, password1.getEncrypted(), password1.getSalt());
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by faiter on 9/13/17.
 */
public class RSATest {

    @Test
    public void test_encrypt_and_decrypt(){

        int message = 9;

        int e = 7;
        int d = 103;
        int mod = 143;

        int encrypted = RSA.R(message, e, mod);

        assertEquals(encrypted, 48);

        int decrypted = RSA.R(encrypted, d, mod);

        assertEquals( message, decrypted);


    }

}

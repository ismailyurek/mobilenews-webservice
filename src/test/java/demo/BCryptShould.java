package demo;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.SecureRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BCryptShould {

    String pepperTest = "this is the test pepper.";
    private String username = "testusername";
    private String password = "testpassword";

    @Test
    public void test_pepper() {
        String pepper1 = BCrypt.gensalt(4, new SecureRandom(pepperTest.getBytes()));
        String pepper2 = BCrypt.gensalt(4, new SecureRandom(pepperTest.getBytes()));

        assertEquals(pepper1, pepper2);
    }

    @Test
    public void test_checkpw() {
        String salt = getSalt(username);
        String passwordHash1 = getPasswordHash(password, salt);

        assertThat(BCrypt.checkpw(password, passwordHash1), Matchers.is(true));
    }

    @Test
    public void auth() {
        String salt = getSalt(username);
        String passwordHash = getPasswordHash(password, salt);

        String pepper = getMagicPepper();
        String passwordHashWithSaltAndPepper = getPasswordHash(passwordHash, pepper);

        String passwordHash2 = getPasswordHash(password, salt);

        boolean result = BCrypt.checkpw(passwordHash2, passwordHashWithSaltAndPepper);
        assertThat(result, Matchers.is(true));
    }

    private String getPasswordHash(String password, String salt) {
        return BCrypt.hashpw(password, salt);
    }

    private String getMagicPepper() {
        return BCrypt.gensalt(4, new SecureRandom(pepperTest.getBytes()));
    }

    private String getSalt(String username) {
        int logRounds = getLogRounds(username);
        if(logRounds >= 4 && logRounds <= 31)
        {
            return BCrypt.gensalt(logRounds);
        }

        return BCrypt.gensalt();
    }

    private int getLogRounds(String username) {
        return 0;
    }
}

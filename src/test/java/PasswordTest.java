import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void passwordIsValid() {
        Password isValid = new Password();
        assertTrue(Password.passwordIsValid("Mthoko123!@#1"));
    }

    @Test
    void passwordIsOk() {
    }
}
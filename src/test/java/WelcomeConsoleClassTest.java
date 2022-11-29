import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WelcomeConsoleClassTest {
    @Test
    void ClassNotNullTest() {
        WelcomeConsole obj = new WelcomeConsole();
        assertNotNull(obj);

    }
}

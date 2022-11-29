package Database;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class DatabaseConnectionTest {

    DatabaseConnection testingConnection = new DatabaseConnection(Mode.TEST);

    @Test
    void connect() {
        assertFalse(Objects.isNull(this.testingConnection.connect()));
    }

    @Test
    void close() {

    }
}
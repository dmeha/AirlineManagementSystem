package Database;

import java.sql.Connection;

public interface DBconnection {

public Connection connect();
void close();
}

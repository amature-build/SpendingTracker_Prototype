package my_app.data_access.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteHelper {
    private Connection connection;

    public SqliteHelper() throws  SQLException {
        String url = "jdbc:sqlite:src/resource/database.db";
        connection = DriverManager.getConnection(url);
    }

    public SqliteHelper(String dbFilePath) throws SQLException {
        String url = "jdbc:sqlite:" + dbFilePath;
        connection = DriverManager.getConnection(url);
    }

    public Connection get_connection() {
        return connection;
    }

    public void close_connection() throws SQLException {
        connection.close();
    }
}

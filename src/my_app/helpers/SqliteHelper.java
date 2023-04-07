package my_app.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteHelper implements AutoCloseable {
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
    public boolean is_closed() throws SQLException {
        return connection.isClosed();
    }

    public void close_connection() throws SQLException {
        connection.close();
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

package my_app.data_access.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteHelper {
    private Connection conn;

    public SqliteHelper() throws  SQLException {
        String url = "jdbc:sqlite:src/resource/database.db";
        conn = DriverManager.getConnection(url);
    }

    public SqliteHelper(String dbFilePath) throws SQLException {
        String url = "jdbc:sqlite:" + dbFilePath;
        conn = DriverManager.getConnection(url);
    }

    public Connection get_connection() {
        return conn;
    }

    public void close_connection() throws SQLException {
        conn.close();
    }
}

package my_app.data_access.helpers;

import my_app.helpers.SqliteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SqliteHelperTest {

    private SqliteHelper helper = null;

    @AfterEach
    void tearDown() throws SQLException {
        if (helper != null) {
            helper.close_connection();
        }
    }

    @Test
    void get_connection() throws SQLException {
        try (SqliteHelper conn = new SqliteHelper()) {
            assertNotNull(conn, "Connection should not be null");
        }
    }

    @Test
    void close_connection() throws SQLException {
        try (SqliteHelper conn = new SqliteHelper()) {
            helper = conn;
        }
        helper.close_connection();

        assertTrue(helper.is_closed());
    }
}
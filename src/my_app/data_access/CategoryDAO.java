package my_app.data_access;

import my_app.business_logic.Category;
import my_app.helpers.SqliteHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoryDAO {
    private SqliteHelper helper;

    public CategoryDAO() throws SQLException {
        this.helper = new SqliteHelper();
    }

    public List<Category> getAllParentCategory() throws SQLException {
        String sql = "SELECT id, name FROM category WHERE parent_id IS NULL";
        try (
            Connection connection = helper.get_connection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
        ) {
            List<Category> categories = new ArrayList<>();
            while (result.next()) {
                Category category = new Category(result.getInt("id"), result.getString("name"), null);
                categories.add(category);
            }
            return categories;
        }

    }
}

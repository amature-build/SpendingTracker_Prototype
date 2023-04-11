package my_app.data_access;

import my_app.business_logic.Category;
import my_app.helpers.SqliteHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoryDao {
    private SqliteHelper helper;

    public CategoryDao() throws SQLException {
        this.helper = new SqliteHelper();
    }

    public List<Category> getCategories() throws SQLException {
        String sql = "SELECT id, name FROM category WHERE parent_id IS NULL";
        try (
            Connection connection = helper.get_connection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
        ) {
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name, null);
                categories.add(category);
            }
            return categories;
        }
    }

    public List<Category> getSubCategories(Category parentCategory) throws SQLException {
        String sql = "SELECT id, name FROM category where parent_id = ?";
        try (
            Connection connection = helper.get_connection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, parentCategory.getId());

            try (ResultSet resultSet = statement.executeQuery();) {
                List<Category> subCategories = new ArrayList<>();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Category subCategory = new Category(id, name, parentCategory);
                    subCategories.add(subCategory);
                }
                return subCategories;
            }
        }
    }
}

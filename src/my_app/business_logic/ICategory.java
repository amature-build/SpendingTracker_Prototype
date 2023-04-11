package my_app.business_logic;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {
    public interface iCategory {
        List<Category> getCategories() throws SQLException;
        List<Category> getSubcategories(Category parentCategory) throws SQLException;
        void addCategory(Category category) throws SQLException;
    }
}

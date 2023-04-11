package my_app.business_logic;

import my_app.data_access.CategoryDao;

import java.sql.SQLException;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private Category parentCategory;
    private CategoryDao categoryDao;

    public Category() {}

    public Category(int id, String name, Category parentCategory) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isTopLevel() {
        return parentCategory == null;
    }

    public List<Category> getSubCategories() throws SQLException {
        categoryDao = new CategoryDao();
        if (!this.isTopLevel()) {
            throw new IllegalStateException("Is not a top level category.");
        }
        return categoryDao.getSubCategories(this);
    }
}

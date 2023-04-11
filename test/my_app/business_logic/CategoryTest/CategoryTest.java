package my_app.business_logic.CategoryTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import my_app.business_logic.Category;
import my_app.business_logic.Trip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    private Category category;

    @BeforeEach
    void setup() {
        category = new Category();
    }

    @AfterEach
    void tear_down() {
        category = null;
    }

    @Test
    void getSubCategories() throws SQLException {
        category.setId(1);
        List<Category> test;
        test = category.getSubCategories();
        long output = test.stream().count();
        assertEquals(output, 6);
    }
}

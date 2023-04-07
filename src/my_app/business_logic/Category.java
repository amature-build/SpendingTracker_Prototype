package my_app.business_logic;

public class Category {
    private int id;
    private String name;
    private Category parentCategory;

    public Category(int id, String name, Category parentCategory) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

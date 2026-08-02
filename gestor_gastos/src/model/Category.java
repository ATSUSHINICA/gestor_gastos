package model;

/**
 * This class represents a category used to classify each financial movement
 * as either an income or an expense. Categories help identify and organize
 * movements correctly within the system.
 * @author José Alejandro Díaz Delgado
 * @since 2026/07/23
 */
public class Category {

    private String name;
    /* This variable stores the category type (EXPENSE or INCOME) */
    private CategoryType type;

    /**
     * Constructor for the Category class.
     * @param name name of the category
     * @param type category type (EXPENSE or INCOME)
     */
    public Category(String name, CategoryType type) {
        this.name = validateName(name);
        this.type = type;
    }

    /**
     * Validates the name of the category.
     * @param name category name
     * @return validated name
     */
    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: category name cannot be empty");
        }
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    // Getters
    public String getName() { return name; }
    public CategoryType getType() { return type; }

    // Setters
    public void setName(String name) { this.name = validateName(name); }
    public void setType(CategoryType type) { this.type = type; }
}

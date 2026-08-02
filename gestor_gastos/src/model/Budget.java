package model;

import java.time.YearMonth;

/**
 * This class is responsible for dividing the user's monthly budget into
 * different categories such as leisure, subscriptions, household expenses, etc.
 * Each budget entry defines a spending limit for a specific category within
 * a given month.
 * @author José Alejandro Díaz Delgado
 * @since 2026/07/23
 */
public class Budget {

    private Category category; // Defines whether this budget belongs to an expense or income
    private double limit;      // Maximum allowed amount for this budget
    private YearMonth period;  // Month and year this budget applies to

    /**
     * Constructor for the Budget class.
     * @param category category assigned to this budget (expense or income)
     * @param limit maximum allowed amount for this budget
     * @param period month and year this budget corresponds to
     */
    public Budget(Category category, double limit, YearMonth period) {
        this.category = validateCategory(category);
        this.limit = validateLimit(limit);
        this.period = period;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "category=" + category +
                ", limit=" + limit +
                ", period=" + period +
                '}';
    }

    //================================= VALIDATION METHODS =================================

    /**
     * Validates the category assigned to this budget.
     * @param category the category to validate
     * @return the validated category
     */
    private Category validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("A budget must have a category assigned");
        }

        if (category.getType() != CategoryType.EXPENSE) {
            throw new IllegalArgumentException("Invalid category type for this budget");
        }

        return category;
    }

    /**
     * Validates the spending limit of the budget.
     * @param limit the limit to validate
     * @return the validated limit
     */
    private double validateLimit(double limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Budget limit must be greater than zero");
        }

        return limit;
    }

    //================================= GETTERS =================================

    public Category getCategory() { return category; }
    public double getLimit() { return limit; }
    public YearMonth getPeriod() { return period; }

    //================================= SETTERS =================================

    public void setCategory(Category category) { this.category = validateCategory(category); }
    public void setPeriod(YearMonth period) { this.period = period; }
    public void setLimit(double limit) { this.limit = validateLimit(limit); }
}

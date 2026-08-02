package model;

import java.time.LocalDate;

/**
 * This class is a child of Movement and represents an income entry.
 * It contains all the information specific to income movements,
 * including the source from which the income originates.
 * @author José Alejandro Díaz Delgado
 * @since 2026/07/23
 */
public class Income extends Movement {

    private String source;  // Information about where the income comes from

    /**
     * Constructor for the Income class.
     * Initializes all income values and validates that the provided
     * category corresponds to an INCOME type.
     *
     * @param name        name of the income
     * @param amount      amount of money received
     * @param date        date when the income was received
     * @param category    category associated with the income (must be INCOME)
     * @param description description of the income
     * @param source      origin or source of the income
     */
    public Income(String name, double amount, LocalDate date,
                  Category category, String description, String source) {

        super(name, amount, date, category, description);

        if (category.getType() != CategoryType.INCOME) {
            throw new IllegalArgumentException("The category for this income is incorrect");
        }

        this.source = validateSource(source);
    }

    /**
     * Validates the source of the income.
     * @param source information about the origin of the income
     * @return validated source
     */
    private String validateSource(String source) {
        if (source == null || source.isBlank()) {
            throw new IllegalArgumentException("Income source cannot be empty");
        }

        if (source.length() < 3) {
            throw new IllegalArgumentException("Income source is too short");
        }

        return source;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") + ", source='" + source + "'}";
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = validateSource(source); }
}

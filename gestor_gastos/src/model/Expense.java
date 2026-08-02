package model;

import java.time.LocalDate;

/**
 * This class is a child of Movement and represents an expense entry.
 * It contains all the information specific to expense movements and ensures
 * that the assigned category corresponds to an EXPENSE type.
 * @author José Alejandro Díaz Delgado
 * @since 2026/07/23
 */
public class Expense extends Movement {

    /**
     * Constructor for the Expense class.
     * Initializes all expense values and validates that the provided
     * category corresponds to an EXPENSE type.
     *
     * @param name        name of the expense
     * @param amount      amount of money spent
     * @param date        date when the expense occurred
     * @param category    category associated with the expense (must be EXPENSE)
     * @param description description of the expense
     */
    public Expense(String name, double amount, LocalDate date,
                   Category category, String description) {

        super(name, amount, date, category, description);

        if (category.getType() != CategoryType.EXPENSE) {
            throw new IllegalArgumentException("Incorrect category type for this expense");
        }
    }
}

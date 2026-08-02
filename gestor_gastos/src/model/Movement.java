package model;

import java.time.LocalDate;

/**
 * The abstract parent class Movement contains the core data shared by both
 * expenses and income entries. It provides the essential attributes required
 * to identify and describe each financial movement within the system.
 * @author José Alejandro Delgado Díaz
 * @since 2026/07/23
 */
public abstract class Movement {

    private static int counter;

    private int id;
    private String name;          // Name of the movement
    private double amount;        // Monetary value of the movement
    private LocalDate date;       // Date selected by the user
    private Category category;    // Category assigned (expense or income)
    private String description;   // Additional information describing the movement

    /**
     * Constructor for the Movement class.
     * @param name name of the movement
     * @param amount monetary value of the movement
     * @param date date chosen by the user for the movement
     * @param category category assigned to the movement (expense or income)
     * @param description additional information describing the movement
     */
    public Movement(String name, double amount, LocalDate date, Category category, String description) {
        this.id = ++counter;
        this.name = validateName(name);
        this.amount = validateAmount(amount);
        this.date = validateDate(date);
        this.category = category;
        this.description = validateDescription(description);
    }

    @Override
    public String toString() {
        return "Movement{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }

    //====================================== VALIDATION METHODS ======================================

    /**
     * Validates the name of the movement.
     * @param name movement name
     * @return validated name
     */
    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (name.length() < 2) {
            throw new IllegalArgumentException("Name is too short");
        }

        return name;
    }

    /**
     * Validates the amount of the movement.
     * @param amount movement amount
     * @return validated amount
     */
    private double validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        return amount;
    }

    /**
     * Validates the description of the movement.
     * @param description movement description
     * @return validated description
     */
    private String validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        if (description.length() < 5) {
            throw new IllegalArgumentException("Description is too short");
        }

        return description;
    }

    /**
     * Validates the date of the movement.
     * @param date movement date
     * @return validated date
     */
    private LocalDate validateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date;
    }

    //====================================== GETTERS ======================================

    public String getName() { return name; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }

    //====================================== SETTERS ======================================

    public void setName(String name) { this.name = validateName(name); }
    public void setAmount(double amount) { this.amount = validateAmount(amount); }
    public void setDate(LocalDate date) { this.date = date; }
    public void setCategory(Category category) { this.category = category; }
    public void setDescription(String description) { this.description = validateDescription(description); }
}

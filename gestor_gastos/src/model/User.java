package model;

/**
 * This class defines the core attributes and required values for every user
 * within the system.
 * @author José Alejandro Díaz Delgado
 * @since 2026/07/22
 */
import java.time.*;

public class User {

    private String name;
    private String email;
    private String password;

    /**
     * Date when the user was registered in the system.
     * It is automatically assigned when the object is created.
     */
    private final LocalDate creationDate;

    /**
     * Constructor for the User class.
     * @param name        user's name
     * @param email       user's email
     * @param password    user's password used to access the account
     */
    public User(String name, String email, String password) {
        this.password = validatePassword(password);
        this.email = validateEmail(email);
        this.name = validateName(name);
        this.creationDate = LocalDate.now();
    }

    /*================================== VALIDATION METHODS =====================================*/

    /**
     * Validates the user's password.
     * @param password the password provided by the user
     * @return the validated password
     */
    private String validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("The provided password is invalid");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("The password is too short");
        }

        return password;
    }

    /**
     * Validates the user's email.
     * @param email the email provided by the user
     * @return the validated email
     */
    private String validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return email;
    }

    /**
     * Validates the user's name.
     * @param name the name provided by the user
     * @return the validated name
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    /*================================== GETTERS =====================================*/

    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getCreationDate() { return creationDate; }

    /*================================== SETTERS =====================================*/

    public void setName(String name) { this.name = validateName(name); }
    public void setEmail(String email) { this.email = validateEmail(email); }
    public void setPassword(String password) { this.password = validatePassword(password); }

}

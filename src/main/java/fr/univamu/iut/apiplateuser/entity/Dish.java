package fr.univamu.iut.apiplateuser.entity;

import jakarta.persistence.*;

/**
 * Represents a dish entity.
 */
@Entity
@Table(name = "dish")
public class Dish {

    /**
     * The unique identifier of the dish.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The name of the dish.
     */
    @Column(name = "name")
    private String name;

    /**
     * The price of the dish.
     */
    @Column(name = "price")
    private double price;

    /**
     * The description of the dish.
     */
    @Column(name = "description")
    private String description;

    /**
     * Constructs a new Dish with the given parameters.
     *
     * @param id          The unique identifier of the dish.
     * @param name        The name of the dish.
     * @param price       The price of the dish.
     * @param description The description of the dish.
     */
    public Dish(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * Constructs a new Dish with default values.
     */
    public Dish() {}

    // Getters and setters

    /**
     * Gets the unique identifier of the dish.
     *
     * @return The unique identifier of the dish.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the dish.
     *
     * @param id The unique identifier of the dish.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the dish.
     *
     * @return The name of the dish.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the dish.
     *
     * @param name The name of the dish.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the dish.
     *
     * @return The price of the dish.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price The price of the dish.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the description of the dish.
     *
     * @return The description of the dish.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the dish.
     *
     * @param description The description of the dish.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

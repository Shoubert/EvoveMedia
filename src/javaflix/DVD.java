package project5;


/* Shubert Charlotin<kgshuby@msn.com>
 * CMP 218 M1
 * Project 4: DVD class
 * Due: 5 / 11 / 2007 11:59 pm
 * DVD.java
 */
/**
 * this DVD class is to store all inventory of the store.
 * - Inventory items for Movies
 * - Inventory items for Concerts
 * - Inventory items for  video games
 */
/*
 *This class is serve as the parent for both Movie and Game
 */
public abstract class DVD {
    public int id; //unique id
    private static int count = 1;
    protected int value; // store game value
    protected String title; // The title of Object rent
    protected int year; // store year
    protected boolean available;

    /**
     * default constructor
     */
    public DVD() {
        id = count++;
        title = "No Title";
        year = 0;
        available = false;
    }

    /**
     * default constructor with parameterize
     * @param title String
     * @param year int
     */
    public DVD(String title, int year) {
        this();
        setTitle(title);
        setYear(year);

    }

    /**
     * Mutator Methods
     */
    // set title
    public void setTitle(String t) {
        if (t.trim().length() != 0) {
            title = t;
        }
    }

    // set year
    public void setYear(int y) {
        if (year >= 1935 && year <= 2007) {
            year = y;
        }

    }

    // set availablelity
    public void setAvailable(boolean a) {
        available = a;
    }

    // set id
    public int getId() {
        return id;
    }

    /**
     * Accessor Methods
     */
    // get title
    public String getTitle() {
        return title;
    }

    // get year
    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    // get value
    public int getValue() {
        return value;
    }

    /*
     * Overridden Methods
     */
    public String toString() {
        return id + ": " + title;
    }


} //end

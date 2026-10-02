package project5;

/* Shubert Charlotin<kgshuby@msn.com>
 * CMP 218 M1
 * Project 4: Game class
 * Due: 5 / 11 / 2007 11:59 pm
 * Game.java
 */
/**
 * This class represent all the games that could be rent by a customer
 * each games have a unique Id, title, and platform
 * this class also extend the DVD class
 *
 */
public class Game extends DVD implements Comparable {


    /**
     * Simbolic  class constants
     */
    public static final int PS1 = 1; // store PS1
    public static final int DC = 2; // store DC

    public static final int PS2 = 3; // store PS2
    public static final int XBOX = 4; //store XBOX
    public static final int CUBE = 5; // store CUBE
    public static final int PS3 = 6; // store PS3
    public static final int X360 = 7; // store x360
    public static final int WII = 8; // store WII

    /**
     * Accessible constants for platform
     */
    private int platform; //game platform


    /**
     * default constructor
     */
    public Game() {
        super();

        platform = PS1; // default game platform = PS1

    }

    public Game(String title, int platform, int year) {
        super();
        setTitle(title); // set tilte
        setYear(year); // set year
        setPlatform(platform); // set platform
        super.available = title.trim().length() > 0 && platform > 0 &&
                          year >= 1995;
    }

    /**
     * Mutator methods
     */

//set title

    public void setTitle(String t) {
        if (t.trim().length() != 0) {
            title = t;
        }
    }

    //set year
    public void setYear(int y) {
        if (y >= 1995) {
            year = y;
        }
    }

    // boolean available calling the super class for game availability
    public void setAvailable(boolean a) {
        super.available = a;

    }


    /**
     * Accessor Methods
     */
    //get Id
    public int getID() {
        return (super.getId());
    }

    // get Value
    public int getValue() {
        return value;
    }

    // get platform
    public int getPlatform() {
        return platform;
    }

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

    // seting the value of each game platform
    public void setPlatform(int c) {
        if (c == PS1 || c == DC || c == PS2 || c == XBOX || c == CUBE ||
            c == PS3 || c == X360 || c == WII) {
            platform = c;
        }
    }

    // display the value of each game Platform object
    private String showPlatform() {
        if (platform == PS1) {
            super.value = 50;
            return "Playstation";
        } else if (platform == DC) {
            super.value = 50;
            return "Dreamcast";
        } else if (platform == PS2) {
            super.value = 100;
            return "Playstation 2";
        } else if (platform == XBOX) {
            super.value = 100;
            return "Xbox";
        } else if (platform == CUBE) {
            super.value = 100;
            return "Game Cube";
        } else if (platform == PS3) {
            super.value = 150;
            return "Playstation 3";
        } else if (platform == X360) {
            super.value = 150;
            return "Xbox 360";
        } else if (platform == WII) {
            super.value = 150;
            return "Nintendo WII";
        } else {
            return "NO DATA";
        }

    }

    // toString displaying a game unique  title, platform, year, and availablelity
    public String toString() {
        return super.getId() + ":" + super.getTitle() + " " + showPlatform() +
                "'" + super.getYear() + "\n" + (available ? "In" : "Out of") +
                " stock. ";
    }

    // compare each platform according to their values
    public int compareTo(Object o) {
        Game m1 = (Game) o;
        if (this.getTitle().compareTo(m1.getTitle()) > 0) {
            return 1;
        } else

        if (this.getTitle().compareTo(m1.getTitle()) < 0) {
            return -1;
        }
        if (this.getValue() > (m1.getValue())) {
            return 1;
        } else
        if (this.getValue() < (m1.getValue())) {
            return -1;
        } else
        if (this.getYear() > (m1.getYear())) {
            return 1;

        } else
        if (this.getYear() < (m1.getYear())) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * equauls
     * Overridden equals method from Object
     */
    public boolean equals(Object o) {
        if (o instanceof Game) {
            Game g = (Game) o;
            if ((getTitle().equals(g.getTitle())) &&
                (getPlatform() == (g.getPlatform())) &&
                (getYear() == (g.getYear()))) {
                return true;
            }
        }
        return false;
    }
} //end

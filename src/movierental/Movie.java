package movierental;

/**
 * A movie a customer can rent, charged a per-day late fee that depends on its genre.
 *
 * @author Shoubert Charlotin
 * @version Assignment 08 (2014), fixed 2026
 */
public class Movie {
    public static final double DEFAULT_LATE_FEE = 2.0;

    private String title;
    private String rating;
    private int id;
    private int rentTime;
    private final double lateFeePerDay;

    public Movie(String title, String rating, int id, int rentTime) {
        this(title, rating, id, rentTime, DEFAULT_LATE_FEE);
    }

    protected Movie(String title, String rating, int id, int rentTime, double lateFeePerDay) {
        setTitle(title);
        setRating(rating);
        setID(id);
        setRentTime(rentTime);
        this.lateFeePerDay = lateFeePerDay;
    }

    /** Copy constructor. */
    public Movie(Movie original) {
        if (original == null) {
            throw new IllegalArgumentException("Please rent a movie");
        }
        title = original.title;
        rating = original.rating;
        id = original.id;
        rentTime = original.rentTime;
        lateFeePerDay = original.lateFeePerDay;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        if (title != null) this.title = title;
    }

    public String getRating() { return rating; }

    public void setRating(String rating) {
        if (rating != null) this.rating = rating;
    }

    public int getID() { return id; }

    public void setID(int id) {
        if (id > 0) this.id = id;
    }

    public int getRentTime() { return rentTime; }

    public void setRentTime(int rentTime) {
        if (rentTime > 0) this.rentTime = rentTime;
    }

    public double getLateFeePerDay() { return lateFeePerDay; }

    public String getGenre() { return "General"; }

    /** Late fee owed for returning the movie {@code daysLate} days late (0 if on time). */
    public double calcLateFees(int daysLate) {
        return daysLate > 0 ? daysLate * lateFeePerDay : 0.0;
    }

    public void movieDetails(int daysLate) {
        System.out.println("The movie title is: " + title + ". The rating is: " + rating + ". The ID is: " + id
                + ". The rent time is: " + rentTime + " days. The genre is: " + getGenre() + ".");
        System.out.printf("The late fee for %d day(s) late is: $%.2f%n", Math.max(daysLate, 0), calcLateFees(daysLate));
    }

    /** Two rentals are the same movie when their IDs match. */
    @Override
    public boolean equals(Object other) {
        return other instanceof Movie && ((Movie) other).id == id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }

    @Override
    public String toString() {
        return title + " (" + rating + ", " + getGenre() + ", ID " + id + ")";
    }
}

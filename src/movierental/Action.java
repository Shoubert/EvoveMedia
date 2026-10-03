package movierental;

/** Action movie: late fee $3.0 per day. */
public class Action extends Movie {
    public static final double LATE_FEE = 3.0;

    public Action(String title, String rating, int id, int rentTime) {
        super(title, rating, id, rentTime, LATE_FEE);
    }

    @Override
    public String getGenre() { return "Action"; }
}

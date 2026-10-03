package movierental;

/** Comedy movie: late fee $2.5 per day. */
public class Comedy extends Movie {
    public static final double LATE_FEE = 2.5;

    public Comedy(String title, String rating, int id, int rentTime) {
        super(title, rating, id, rentTime, LATE_FEE);
    }

    @Override
    public String getGenre() { return "Comedy"; }
}

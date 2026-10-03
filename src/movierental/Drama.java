package movierental;

/** Drama movie: late fee $2.0 per day. */
public class Drama extends Movie {
    public static final double LATE_FEE = 2.0;

    public Drama(String title, String rating, int id, int rentTime) {
        super(title, rating, id, rentTime, LATE_FEE);
    }

    @Override
    public String getGenre() { return "Drama"; }
}

package movierental;

/**
 * Checks for the movie rental classes. Exits non-zero on the first failure.
 *
 *   java -cp out movierental.SmokeTest
 */
public final class SmokeTest {

    private static int passed;

    private static void check(boolean ok, String what) {
        if (!ok) {
            System.err.println("FAIL: " + what);
            System.exit(1);
        }
        passed++;
        System.out.println("ok   " + what);
    }

    public static void main(String[] args) {
        Movie comedy = new Comedy("Men In Black", "PG-13", 123456789, 5);
        check(comedy.getTitle().equals("Men In Black") && comedy.getRating().equals("PG-13"), "title and rating not swapped");
        check(comedy.getRentTime() == 5, "subclass keeps rent time");
        check(comedy.getGenre().equals("Comedy"), "genre comes from the subclass");
        check(comedy.calcLateFees(4) == 10.0, "comedy: 4 days x $2.50");
        check(new Action("A", "R", 1, 3).calcLateFees(4) == 12.0, "action: 4 days x $3.00");
        check(new Drama("D", "G", 2, 7).calcLateFees(4) == 8.0, "drama: 4 days x $2.00");
        check(comedy.calcLateFees(0) == 0.0 && comedy.calcLateFees(-3) == 0.0, "no fee when on time");
        check(new Movie(comedy).calcLateFees(2) == 5.0, "copy keeps late fee rate");
        check(new Movie(comedy).equals(comedy), "copy equals original (same ID)");
        check(!comedy.equals(new Drama("D", "G", 2, 7)), "different IDs are different movies");

        System.out.println(passed + " checks passed");
    }
}

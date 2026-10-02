package javaflix;

/**
 * Headless checks for the JavaFlix data classes (no GUI). Exits non-zero on the first failure.
 *
 *   java -cp out javaflix.SmokeTest
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
        Address a = new Address(12, "Main St", "Philadelphia", "pa", "19103");
        check(a.getState().equals("PA"), "state is upper-cased");
        check(new Address(1, "X", "Y", "ZZZ", "123").getZipcode().equals("00000"), "invalid state/zip keep defaults");
        check(a.equals(new Address(12, "Main St", "Philadelphia", "PA", "19103")), "address equality by value");

        Customer c = new Customer("Lisa", 'k', "Caterer", a);
        check(c.getMiddle() == 'K' && c.getAddress() == a, "customer keeps middle initial and address");
        check(c.toString().contains("Valid"), "customer with names is valid");
        check(new Customer("Ann", "Zed").compareTo(new Customer("Bob", "Abe")) > 0, "customers sort by last name");

        Movie m = new Movie("The Matrix", "Wachowski", Movie.R, 1999, 136);
        check(m.getYear() == 1999, "DVD.setYear stores the new year");
        check(m.isAvailable(), "complete movie is in stock");
        check(m.toHours().equals("2:16"), "136 min = 2:16");
        check(new Movie("Short", "D", Movie.G, 2000, 65).toHours().equals("1:05"), "65 min = 1:05");
        check(m.getRating() == Movie.R, "rating stored");

        Concert live = new Concert("Queen", "Live Aid", "Various", 1985, 600);
        check(live.getBand().equals("Queen") && live.getYear() == 1985, "concert built through Movie constructor");

        Game g = new Game("Halo 3", Game.X360, 2007);
        check(g.isAvailable() && g.getPlatform() == Game.X360, "game available on its platform");

        FlixQueue q = new FlixQueue(m, live);
        check(q.size() == 2 && !q.isEmpty(), "queue holds two movies");
        check(q.add(new Movie("Toy Story", "Lasseter", Movie.G, 1995, 81)), "third movie fits");
        check(!q.add(new Movie("Casablanca", "Curtiz", Movie.PG, 1942, 102)), "fourth movie rejected (MAX_QUEUE = 3)");
        Movie rented = q.rent();
        check(rented == m && !m.isAvailable(), "rent() hands out the first in-stock movie and marks it out");
        check(q.size() == 2, "rented movie leaves the queue");
        check(q.clone().equals(q), "clone equals original");

        System.out.println(passed + " checks passed");
    }
}

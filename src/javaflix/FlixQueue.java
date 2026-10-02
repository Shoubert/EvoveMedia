package javaflix;

/**
 * FlixQueue: the movies a customer has queued to rent.
 * A customer may hold at most MAX_QUEUE movies. rent() hands out the next movie that is
 * in stock and marks it out of stock.
 *
 * Rebuilt from the original (which did not compile) following its comments and method names:
 * MAX_QUEUE = 3, a constructor taking the movies, Rent(), isEmpty(), compareTo() and equals().
 */
public class FlixQueue implements Cloneable, Comparable<FlixQueue> {

    /**
     * Static constant MAX_QUEUE = 3
     * amount of movie a customer allow to rent
     */
    public static final int MAX_QUEUE = 3;

    private final Movie[] movies = new Movie[MAX_QUEUE];
    private int count; // movies currently in the queue

    /**
     * default constructor: empty queue
     */
    public FlixQueue() {
        count = 0;
    }

    /**
     * parameterized constructor: queue up to MAX_QUEUE movies
     * @param items movies to queue
     * @throws IllegalArgumentException if more than MAX_QUEUE movies are given
     */
    public FlixQueue(Movie... items) {
        this();
        if (items.length > MAX_QUEUE) {
            throw new IllegalArgumentException("A customer may queue at most " + MAX_QUEUE + " movies");
        }
        for (Movie m : items) {
            add(m);
        }
    }

    /**
     * add a movie to the end of the queue
     * @return true if it was added, false if the queue is full
     */
    public boolean add(Movie m) {
        if (m == null || count == MAX_QUEUE) {
            return false;
        }
        movies[count++] = m;
        return true;
    }

    /*
     * Mutator Methods
     */
    /**
     * rent the first queued movie that is in stock; it is removed from the queue and marked out of stock
     * @return the rented movie, or null if nothing queued is available
     */
    public Movie rent() {
        for (int i = 0; i < count; i++) {
            if (movies[i].isAvailable()) {
                Movie m = movies[i];
                m.setAvailable(false);
                System.arraycopy(movies, i + 1, movies, i, count - i - 1);
                movies[--count] = null;
                return m;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public Movie peek() {
        return count == 0 ? null : movies[0];
    }

    /**
     * queues are ordered by how many movies they hold
     */
    public int compareTo(FlixQueue other) {
        return Integer.compare(count, other.count);
    }

    /**
     * Overiding Methods
     */
    public boolean equals(Object in) {
        if (!(in instanceof FlixQueue)) {
            return false;
        }
        FlixQueue q = (FlixQueue) in;
        if (q.count != count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (!movies[i].equals(q.movies[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.hashCode(java.util.Arrays.copyOf(movies, count));
    }

    @Override
    public FlixQueue clone() {
        return new FlixQueue(java.util.Arrays.copyOf(movies, count));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Queue (" + count + "/" + MAX_QUEUE + ")");
        for (int i = 0; i < count; i++) {
            sb.append("\n  ").append(i + 1).append(". ").append(movies[i].getTitle());
        }
        return sb.toString();
    }
}

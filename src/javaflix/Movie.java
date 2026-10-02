package javaflix;
/* Shubert Charlotin<kgshuby@msn.com>
  * CMP 218 M1
  * Project 2: Movie rental
  * Due: 3 / 28 / 2007 11:59 pm
  * Movie.java
  */
  /**
  *  this class is to store movies for a video store rental
  *  also all the data for a movie is store in this class,
  *  such as the movie title, director, rating, a movie length and the year the movie was made .
  *
  *  Title, year and availability are inherited from DVD (they used to be re-declared here,
  *  which hid the DVD fields).
  */
 public class Movie extends DVD implements Comparable<Movie> {

     private String director; // store movie director
     private int rating; // store movie rating
     private int min; // store number of minute

   // constant for various MPAA ratings
     public static final int NR = 0; //store rating NR
     public static final int G = 1; //store  rating G
     public static final int PG = 2; //store  rating PG
     public static final int PG13 = 3; //store  rating PG-13
     public static final int R = 4; // store rating R
     public static final int NC17 = 5; //store rating NC-17

 /**
  * default constructor
  * instance variables are initialize to their default value
  */
  public Movie() {
         super();
         min = 0;
         director = "No Director";
         rating = NR;
     }

     /**
     * parameterized constructor
     * set title, director, rating, year and minutes by calling each of the set methods
     * movie must have non-blank titles and directors to be available
    */
     public Movie(String title, String director, int rating, int year, int min) {
         this();
         setTitle(title);
         setDirector(director);
         setRating(rating);
         setYear(year);
         setMin(min);

         available = !(this.title.equals("No Title") || this.director.equals("No Director") || this.year == 0);
     }

     /**
      * set director
      * @param d String
      */
     public void setDirector(String d) {
         if (d != null && d.trim().length() > 0)
             director = d.trim();
     }

     /**
      * set rating (ignored unless it is one of the rating constants)
      * @param r int
      */
     public void setRating(int r) {
         switch (r) {
             case NR:
             case G:
             case PG:
             case PG13:
             case R:
             case NC17:
                 rating = r;
                 break;
             default:
                 break;
         }
     }

     /**
      *  set minutes
      * @param m int
      */
     public void setMin(int m) {
         if ( m > 0)
             min = m;
     }

    /**
      * Accessors
      */
     public String getDirector() {
         return director;
     }

     public int getRating() {
         return rating;
     }

     /**
     * return minute
      * @return int
      */
     public int getMin() {
         return min;
     }

     /**
      * return movie id (the DVD inventory id)
      * @return int
      */
     public int getMovId() {
         return getId();
     }

     /* private helper methods, to make things display nicely*/
     private String showRating(){
         switch (rating) {
             case G: return "Rating G";
             case PG: return "Rating PG";
             case PG13: return "Rating PG13";
             case R: return "Rating R";
             case NC17: return "Rated NC-17";
             default: return "No Rating";
         }
     }

     /**
      * running time as h:mm
      */
      public String toHours(){
          int hours = min / 60;
          int m = min % 60;
          return hours + ":" + ( m >= 10 ? String.valueOf(m) : "0" + m );
    }

      /* Overrides other Object class */
     public boolean equals(Object o) {
         if (!(o instanceof Movie)) {
             return false;
         }
         Movie m = ( Movie ) o;
         return title.equals(m.title) && director.equals(m.director) &&
                rating == m.rating && year == m.year && min == m.min;
     }

     @Override
     public int hashCode() {
         return java.util.Objects.hash(title, director, rating, year, min);
     }

     /* display Object's data*/
     public String toString() {
         return id + ": " + title + "  Directed by " + director +  "\n " + showRating() + " " + year + " " + toHours() + "\n" + ( available ? "In" : "Out of") + " stock. ";
     }

    /**
      *  compare two movies by title, then year
      * @param m Movie
      * @return int
    */
     public int compareTo(Movie m) {
         int t = title.compareTo( m.title );
         return t != 0 ? t : Integer.compare(year, m.year);
     }
  }//end

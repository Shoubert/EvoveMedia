package project4;
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
  */

  /**
  * Method Movie
  * instance variables
  *
  */
 public class Movie extends DVD implements Comparable {

     private String title; // store movie title
     private String director; // store movie director
     private int rating; // store movie rating
     private int year; // store year of a movie
     private int min; // store number of minute
     private boolean available; // store avalablelity
     private static int count = 0; //  how many  movie object
   // constant for various MPAA ratings

     public static final int G = 1; //store  rating G
     public static final int PG = 2; //store  rating PG
     public static final int PG13 = 3; //store  rating G
     public static final int R = 4; // store rating R
     public static final int MC17 = 5; //store rating MC17
     public static final int NR = 0; //store rating NR

     private int MovId; // store movie id
 /**
  * default constructor
  * instance variables are initialize to their default value
  * instant variables: Year = 1935; min=0  director = ""; rating = false; moviD = ++count; title = "";
  */
  public Movie() {
         year = 0;
         min = 0;
         director = "No Director";
         title = "No Title";
         rating = NR; // set rating to false
         available = false; // set available to false
         MovId = ++count;
     }

     /**
      * parameterized construstor
      * instance variables are set according to their parameters
     */
     /**
     * parameterized constructor
     * set year, and minute in year min calling each of the set methods define
     * movie must have non-blank titlese and directors
    */

     public Movie(String title, String director, int rating, int year, int min) {

         this();
         setTitle(title);
         setDirector(director);
         setRating(rating);
         setYear(year);
         setMin(min);

         if (! ( title.equals( "No Title")||director.equals("No director")|| rating == -1 || year == -1) )
             available = true;

     }

     /**
      * mutators
      * set title
      * @param t String
      */
     public void setTitle(String t) {
          if (t.trim().length() > 0)
              title = t;
      }

     /**
      * set director
      * @param d String
      */
     public void setDirector(String d) {
     StringTokenizer st = new StringTokenizer(d);
     if (t.trim().length() > 0)
         director = d;
     }

     /**
      * set rating
      * @param rating String
      */
     public void setRating(int rating) {
         switch (rating){
      case G:
      case PG:
      case PG13:
      case R:
      case NC17:
      case NR:
          rating = r;
          break;
         }
     }

     /**
      * set year
      * @param  int y
      */
     public void setYear(int y) {
         if (year >= 1935 && year <= 2007)
             year = y;

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
     * set available
     * @param av boolean
     */
     public void setAvailable(boolean a) {
        available = a;

    }

    /**
      * Accessors
      */
     public String getTitle() {
         return title;
       }

     /**
      * return director
      */

     public String getDirector() {
         return director;
     }
     public int getRating()
     {
     return rating;
     }
    
     /**
      *  return the year
      * @return int
     */
     public int getYear() {
         return year;
     }

     /**
     * return minute
      * @return int
      */
     public int getMin() {
         return min;
     }

     /**
      * return movie id
      * @return int
      */
     public int getMovId() {
         return MovId;
     }
     public boolean isAvailable(){
     return available;
     }
     /* private helper methods, to make things display nicely*/
     private String showRating(){
     if ( rating == NR )
         return "No Rating";
     else if ( rating == G )
         return "Rating G";
     else if ( rating == PG )
         return "Rating PG";
     else if ( rating == PG13 )
         return "Rating PG13";
     else if ( rating == R )
         return "Rating R";
     else return "Rated NC-17";
     }
     /**
      *
     * @param o Object
      * @return boolean
      */
      public String toHours(){
      	int hours = 0;
      	int m = min;
      	while( m >= 60){
      		hours ++;
      		m -= 60;
      	}
      	return hours + ":" + ( m > 10 ? m : "0" + m );
    }
      /* Overrides other Object class */
     public boolean equals(Object o) {
         Movie m = ( Movie ) o;
         if(this.title == ( m.title ) && this.director == ( m.director ) &&
             this.rating == ( m.rating ) && this.year == ( m.year ) &&
             this.min == ( m.min ))
             return true;

         else
             return false;
     }
    
     // method to return the title, director, rating, min, year, and movie availabilities
     /* display Object's data*/
          
     public String toString() {

         return id + ": " + title + "  Directed by " + director +  "\n " + showRating() + " " + year + " " + toHours() + "\n" + ( available ? "In" : "Out of") + " stock. ";
           }
    /**
      *  method to compare two movies
      * @param o Object
      * @return int
    */
     public int compareTo(Object o) {
         Movie m = (Movie) o; // explicit casting
        int t = title.compareTo( m.title );
         if ( t == 0 )
             return year -m.year;
             else 
             return t;
     }
  }//end

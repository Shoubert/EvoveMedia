package javaflix;

/**
   * Shubert Charlotin<kgshuby@msn.com>
   * CMP 218 M1
  * Project2: Concert DVDs rentals
   * Due 3/28/07 11:59 PM
   * Concert.java
   *
   *   This class is to store DVDs for rentalat  a customer's request:
   *   The amount of data for each DVDs is about the same as the movie
   *   this class is writen with the list possible codes
   */

  /**
   *   Method Concert
   *   class concert is a subclass of the parent class movie
   *   concert is an extends  class of movie
   */
  public class Concert extends Movie {
      /*
       * create a concert object
       */
      private String band; //varible to store movie data
     /**
       * default constructor
       * call the default constructor in the super class then initializes concerts to
       *
       * 
      */
      public Concert() {
          super();
          band = "No band data";
      }

/**
 * parameterized constructor  
 */
      public Concert(String band, String title, String director, int year,
                     int min) {
          super(title, director, Movie.NR, year, min); // calling the parent class constructor (concerts are not rated)

          this.band = ( band.trim().length() == 0 ? "No  Data" : band); 

      }

      public void setBand(String b) {
          if (b.trim().length() > 0)
              band = b;
      }
      //Accessor ( other accessor are inherited from Movie )

      public String getBand() {
         return band;
     }
     // Mutator ( other mutators are inherited from Movie )

      public boolean equals(Object o) {
          if (!(o instanceof Concert)) {
              return false;
          }
          Concert temp = (Concert) o; // explicit casting
          return band.equals(temp.band) && super.equals(o);
      }

      @Override
      public int hashCode() {
          return 31 * super.hashCode() + band.hashCode();
      }

      public String toString() {
          return super.toString() + "\n Band name :" + " " + band;
      }

      public int compareTo(Movie o) {
          if (o instanceof Concert) {
              int b = band.compareTo( ((Concert) o).band );
              if (b != 0)
                  return b;
          }
          return super.compareTo( o );
      }

 }

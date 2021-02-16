package project3;

 /**
  * Shubert Charlotin<shoubetcharlotin@gmail.com>
   * IT 2660 D
   * Assignment1: Customer Account
   * Due 01/20/19 11:59 PM
   * Address.java
   *
   * This class is to store a customer's address:
   * number' street name, city, state and zip codes
   * street number must be positive and State must be abbreviated as the USPS.
   * The zip code must be 5 digit string
   */



  public class Address Address implements Comparable {
      /**
       * Method Address
       *
       */
      private String streetN; //street name
      private String ct; // city
      private String st; // state
      private String zip; // 5 digit zip code
      private int number; //street number


      /**
       * default construstor to set customer address
       * Method StreetName
       * Method Zipcode
       * Method city
       * Method state
       * set default data
        */


       public Address() { //constructor
           number = 0;
           streetN = "No Data";
           zip = "00000";
           ct = "No Data";
           st = "XX";

       }

       /**
        * Method StreetName
        * parameterize
        * Create and address with street number, zip code, and states
        */
       public Address(int number, String streetN, String ct, String st, String zip) {
          this();
          setNumber( number  );
          setStreetN( streetN );
          setZip( zip );
          setCity( ct );
          setState( st );
          setZip( zip );

      }

      /**
       *  Mutators
       * set street number
       */

      public void setNumber(int n) {

          if (n > 0)
              number = n;
      }

      /*
       * set street name
       */

      public void setStreetN(String s) {
          if (s.trim().length() > 0)
              streetN = s;
      }

      /*
      *set city
       */

      public void setCity(String c) {
          if (c.trim().length() > 0)
              ct = c;
      }

      /*
       *set state
      */
      public void setState(String s) {

          if (s.length() == 2 &&
              Character.isLetter(s.charAt(0)) &&
              Character.isLetter(s.charAt(1)))
              st = s.toUpperCase();
     }

      /*
       *set zip code
       */
      public void setZip(String z) {
          boolean valid = true; //zip code validity
          //check the string lenght
          if (z.trim().length() == 5) {
              //check for each character to make sure it's a digit
              for (int i = 0; i < z.length(); i++)
                  if (!Character.isDigit(z.charAt(i)))
                      // Found a non-digit is it a valid zip code
                      valid = false;

          } else {
              valid = false;
         }
          //if valid is still true, then this string is a zip code
          if (valid)
              zip = z;

      }

      //accessor method
      public int getNumber() {
          return number;
     }

     public String getStreetN() {
         return streetN;

      }

      public String getCity() {
          return ct;

      }

     public String getState() {
          return st;
      }

     public String getZipcode() {
          return zip;

      }

      public boolean equals(Object o) {
             if ( o instanceof Address){
              return this.toString().equals((( Address ) o).toString());
     {
 	          else
     }
               return false;
     }
     }
      public int compareTo(Object o) {
      return this.toString().equals((( Address ) o).toString());  
      }

      //to String
     
  }
}
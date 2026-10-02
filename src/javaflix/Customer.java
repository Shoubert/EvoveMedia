package project3;


  /**
   * Shubert Charlotin<kgshuby@msn.com>
   * CMP 218 M1
   * Project 2: Customer Account
   * Due 3/28/07 11:59 PM
   * Customer.java
   *
   * This class is to store a customer's address:
   * number' street name, city, state and zip codes
   * street number must be positive and State must be abbreviated as the USPS.
   * The zip code must be 5 digit string
   */

  /**
   * Method Customers
   */
  public class Customer {

      private char middle; // store middle initials
      private Address address; // customer's address
      private String first; // store first name
      private String last; // store last name
      private int CustId; //customer id is unique
      private boolean valid; //check for customer validity
      private static int count = 0; //how many customers that exist
     /*
       * default constructor
       * create customer object with defaul data
       * customer is not valid
       */

      public Customer() {
          middle = '\0';
          first = "No Data";
          last = "No Data";
          CustId = ++count;
          address = new Address();
         valid = false;

      }

      /**
      * Customer
      *
       * @param string first
       * @param c char
       * @param string last
       * @param address Address
   */

      public Customer(String first, char middle, String last, Address addr) {
          this();
          setMiddle(middle);
          setAddress( address );
          setFirst(first);
          setLast(last);
          /**
           * the spec created here is to say the customer account is  only valid if:
           * first name is not empty string
          * last name is not an empty string
          * MI is a letter or '\0'
           *
           */
          valid = first.trim().length() > 0 && last.trim().length() > 0;
      }
      /**
      *
       * @param first String
       * @param last String
       * @param addr Address
       */

     public Customer(String first, String last, Address addr) {
          this(first, '\0', last, addr);
      }
      /**
      *  set first name
      * @param f String
      */

      public void setFirst(String f) {
          if (f.trim().length() != 0)
              first = f;
      }
      /**
       * set customer last name
       * @param l String
       */
     public void setLast(String l) {
          if (l.trim().length() != 0)
              last = l;
      }
      /**
       * set customer middle initials
       * @param m char
       */
      public void setMiddle( char m ) {
          if ( Character.isLetter(m) )
              middle = Character.toUpperCase( m );
          else if ( m
           == '\0')
              middle = m;

      }
      /**
       * set address
       * @param a Address
       */
      public void setAddress(Address a) {
          address = a;
      }
      /**
       *  set valid
       * @param v boolean
       */
      public void setValid(boolean v) {
          valid = v;
      }


      /**
       *  get first
       * @return String
       */
      public String getFirst() {
          return first;
      }
      /**
       *  get last
       * @return String
       */
      public String getLast() {
          return last;
      }

      public char getMiddle() {
          return middle;
      }
      /**
       *  get address
       * @return Address
       */
     public Address getAddress() {
          return address;
      }
      /**
       *  get customer Id
       * @return int
       */
      public int getCustomerID() {
          return CustId;
      }
      /**
       * compere two customer data to verified that they are equal
       * @param o Object
       * @return boolean
       */
      public boolean equals(Object o) {
         Customer temp = (Customer) o;
          if (this.first == (temp.first) && this.middle == (temp.middle) &&
              this.last == (temp.last) && this.address == (temp.address))
              return true;

         else
              return false;
      }
     /**
       * compare each customer data to see if they match
       * @param o Object
       * @return int
       */
      public int compareTo(Object o) {
          Customer temp = (Customer) o; // explicit casting
         if (this.first == (temp.first))
              return 1;
          else if (this.middle == (temp.middle))
             return 1;
          else if (this.last == (temp.last))
              return 1;
          else if (this.address == (temp.address))
             return 1;

          else return 0;
      }
      /**
       *  return customer info
       * @return String
       */
      public String toString() {
       return CustId + ":" + " " + first + " " +
                  (middle == '\0' ? "" : middle + ".") + last + "\n" + address +
                  "\n " + (valid ? "Valid" : "Invalid");
      }


  }

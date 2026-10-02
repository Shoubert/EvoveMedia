package exercises;


/**
 * <P>Title: Inventory here</p>
 * <p>Descriptin: an InventoryItem class which you will define making it implement the Comparable 
 * interface and test using a method that sorts an array of type Comparable.</P>
 * @author (Shoubert charlotin) 
 * @version (Assignment 13)
 */
public class Inventory implements Comparable<Inventory>
{
    // instance variables - replace the example below with your own
    public String InventID; // InventoryID the id unique and used as the key=field
    public int Quantity;
    public double price;

    /**
     *Default Constructor --- initialize the ID, quatity, and price for the inventory
     *to an empty string, 0, and 0.0 respectively
     */
    public Inventory()
    {
        // initialise instance variables
       InventID = new String();
       Quantity = 0;
       price = 0.0;
    }

    /**
     * prameterized constructor -- initialize id, quantity, and price to the user-specified values
     * @Param is to be store in inventoryID
     * @param  itemQuatity to be stored in quatity
     * @return  itemPrice to be stored in price
     */
    public Inventory(String ID, int itemQuantity, double itemPrice)
    {
        // put your code here
        InventID = ID;
        Quantity = itemQuantity;
        price = itemPrice;
        
    }
    
    /**
     * setID method == stores the user specified value in inventoryID
     * @param id is to be stored
     *
     */
    
    public void setID(String ID)
    {
        InventID = new String(ID);
    }
    
    /**
     * setQuantity method method == stores the user specified value in quatitity
     * @param itemQuantiy the quantiy to be stored 
     *
     */
    
    public void setQuatity(int itemQuantity)
    {
         Quantity  = itemQuantity;
    }
    
    /**
     * setPrice method method == stores the user specified value in price
     * @param itemPrice the pricew to be stored 
     *
     */
    
    public void setPrice(double itemPrice)
    {
        price  = itemPrice;
    }
    
     /**
     * getID method method == get the id
     * @param return the product id
     *
     */
    
    public String  getID()
    {
        return new String(InventID);
    }
    
    /**
     * getQuantity method method == get the Quantiy
     * @param return the product itmeQuantity
     *
     */
    
    public int getQuantity()
    {
        return Quantity;
    }
    
    
    
    /**
     * getPrice method method == get thePrice
     * @param return the product price
     *
     */
    
    public double getPrice()
    {
        return  price;
    }
    
    /**
     * equals method-- determeines if two products have the same inventory id 
     * @param otherItem is a reference to a inventory object
     * return true if the two object contain the same inventory id; false otherwise
     */
    public boolean equals(Object otherItem)
    {
        if (!(otherItem instanceof Inventory))
        {
            return false;
        }
        Inventory temp = (Inventory)otherItem;
        return (InventID.equals(temp.InventID));
    }

    /**
     * hashCode consistent with equals (same inventory id -> same hash)
     */
    public int hashCode()
    {
        return InventID.hashCode();
    }
    /**
     * to String method--- creates and returns a string which represent the state of the object
     * return a string containing the current values of the inventID quantity, amd price
     */
    public String toString()
    {
        return String.format("Inventory ID: %s  Quantity: %d  Price: $%.2f", InventID, Quantity, price);
    }
    
    /**
     * CompareTo() method--- orders items by inventory id (the key field):
     * negative if this id sorts first, 0 if the ids are equal, positive otherwise.
     * (It used to compare the strings with ==, which is never true for copies, so it always
     * returned -1 and sorting did nothing useful.)
     * @param compareItem Inventory
     * @return int
     */
    public int compareTo(Inventory compareItem)
    {
        return InventID.compareTo(compareItem.InventID);
    }
}

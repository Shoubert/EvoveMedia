
/**
 * <P>Title: Inventory here</p>
 * <p>Descriptin: an InventoryItem class which you will define making it implement the Comparable 
 * interface and test using a method that sorts an array of type Comparable.</P>
 * @author (Shoubert charlotin) 
 * @version (Assignment 13)
 */
public class Inventory implements Comparable
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
        Inventory temp = (Inventory)otherItem;
        return (InventID.equals(temp.InventID));
    }
    /**
     * to String method--- creates and returns a string which represent the state of the object
     * return a string containing the current values of the inventID quantity, amd price
     */
    public String toString()
    {
        return "Inventory ID:" + InventID + "Quantity:" + Quantity + "Price:" + price; 
    }
    
    /**
     * CompareTo() method--- checks for the quality of the objects
     * if they are equal, return '0' else return '-1'
     * @param compareItem Object
     * @return Int
     */
    public int compareTo(Object compareItem)
    {
        Inventory Invent = (Inventory) compareItem;
        if (this.getID() == Invent.getID())
        {
            return 0;
            
        }
        return -1;
    }
}

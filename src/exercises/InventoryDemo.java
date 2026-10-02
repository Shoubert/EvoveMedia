package exercises;


/** Assignment 13 demo: sort an array of Inventory items (Comparable) and total the stock value.
 *  Run: java -cp out exercises.InventoryDemo */
public class InventoryDemo {
    /** Selection sort on Comparable[], as Assignment 13 asks for. */
    @SuppressWarnings({"rawtypes", "unchecked"})
    static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) if (a[j].compareTo(a[min]) < 0) min = j;
            Comparable t = a[i]; a[i] = a[min]; a[min] = t;
        }
    }

    public static void main(String[] args) {
        Inventory[] items = {
            new Inventory("DVD-104", 12, 19.99), new Inventory("DVD-101", 3, 14.50),
            new Inventory("GAM-201", 7, 59.99), new Inventory("DVD-103", 0, 9.99),
            new Inventory("CON-301", 5, 24.95)};
        System.out.println("Before sort:"); for (Inventory i : items) System.out.println("  " + i);
        sort(items);
        System.out.println("After sort (by ID):"); for (Inventory i : items) System.out.println("  " + i);
        Inventory copy = new Inventory("GAM-201", 1, 1.0);
        System.out.println("equals same ID: " + new Inventory("GAM-201", 7, 59.99).equals(copy) + " / compareTo same ID: " + new Inventory("GAM-201", 0, 0).compareTo(copy));
        double value = 0; for (Inventory i : items) value += i.getQuantity() * i.getPrice();
        System.out.printf("Stock value: $%,.2f%n", value);
    }
}

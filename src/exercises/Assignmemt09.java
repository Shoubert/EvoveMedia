
/**
 *  class Assignmemt09.
 * 
 * @author (Shoubert Charlotin) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Assignmemt09
{
    // instance variables - replace the example below with your own
    public static void main(String[] args)
    {
        
        
             try // try block does not throw an exception
       {
           //int month; // 1-12
             final int[] daysPerMonth =
         { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a Day");
            int day = keyboard.nextInt();
            System.out.println("Enter a Month");
            int month = keyboard.nextInt();
            System.out.println("Enter a Year");
            int year = keyboard.nextInt();
            if (day <= 0 ||
            (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day +
               ") out-of-range for the specified month and year");
 
         // check for leap year if month is 2 and day is 29
            
            if (month <= 0 || month > 12)
            throw new IllegalArgumentException(
               "month (" + month + ") must be 1-12");
            
            
           System.out.println("Method doesNotThrowException");
             System.out.printf("Date:"+ day +  "Month:" + month + "\n"+ "Year:" + year);
       }
        catch (Exception exception) // does not execute
        {
           System.err.println(exception);
        }
        finally // executes regardless of what occurs in try...catch 
     {                                                           
            System.err.println(                                      
             "Finally executed in doesNotThrowException");         
       }                                                           


           
           
        
        
    }
}

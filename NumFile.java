
/**
 * Write a description of class Numbers here.
 * 
 * @author (Shoubert Charlotin) 
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class NumFile { 
    public static void main (String [] args) throws FileNotFoundException { 
        Scanner keyboard = new Scanner(System.in);
        String line = null;
        String fileName = null;
        System.out.println("Enter a line of numbers");
        line = keyboard.nextLine();
        
         // Sum of all digits in the txt file 
          
            try{
           
            BufferedReader inputStream = new BufferedReader(new FileReader("Number.txt")); 
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("NumberDouble.txt"));

           // The line that is read in the txt file 
            
            int counter = 0; // Counter for number of numbers in the txt file 
            double sum = 0;
            double average = 0;
       // String line = inputStream.readLine();
            while(line != null)
            {
            counter ++;
            outputStream.println(counter + "" + line);
             sum += Double.parseDouble(line); 

           //line = inputStream.readLine();
            
            }
             average = sum/counter; 
           // inputStream.close();
            outputStream.close();
            
           
            System.out.println("The average of the numbers is: " + format(average)); 
            System.out.println("The sum of the numbers is: " + sum); 
            System.out.println("The number of digits is " + counter); 
        }
        catch(FileNotFoundException e)
        {
            
        }
      
    } 

    public static String format(double number) { 
        DecimalFormat d = new DecimalFormat("0.00"); 
        return d.format(number); 
    } 
}


/**
 * Write a description of class Temperature here.
 * 
 * @author (Shoubert Charlotin) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.text.NumberFormat;


public class Temperature
{
private double value;
private String scale;
public double degreesC;
public double degreesF;
 
 


public Temperature()  // default constructor
{
  this.value = 0;
  this.scale = "C";
  this.degreesF = 0;
  this.degreesC = 0;
}

public Temperature(double newValue, double newDegreesF, double newDegreesC, String newScale )
{
 this.value = newValue;
 this.scale = newScale; 
 this.degreesF = newDegreesF;
 this.degreesC = newDegreesC;
}

public double getValue()
{
 return this.value;
}

 public String getScale()
 {
 return this.scale;
 }
public double getDegreesF()
{
 return this.degreesF;
}
public double getDegreesC()
{
 return this.degreesC;
}
 public static double toCelsius(double degreesF)
 {

 
     return 5*(degreesF - 32)/9;
 }
 
 // end getCelcius
 public boolean equals(Temperature otherTemperature)
 {
     return (degreesC == otherTemperature.degreesC);
 }

 public double getFaren()
 {
 if (scale.equalsIgnoreCase ("F"))
 {
     return this.value;
 }
 else if (scale.equalsIgnoreCase("C"))
 {
     double celsius = ((this.value * 1.8) + 32);
     return celsius;
 }
 else
 {
     double kelvin = ((this.value * 1.8) - 459.67);
     return kelvin;
 }
 } // ene getFaren

 public double getKelvin()
 {
 if (scale.equalsIgnoreCase("K"))
 {
     return this.value;
 }
 else if (scale.equalsIgnoreCase("C"))
 {
     double celsius = (this.value + 0.0);
     return celsius;
 }
 else
 {
     double faren = ((this.value + 459.67) * (5/9));
     return faren;
 }
 } // end getKelvin

 public void setTemperature(Temperature t)
 {
 this.value = t.value;
 }

 public void setType(double degree, String measure)
 {
 this.value = degree;
 this.scale = measure;
 }

 

 
 public double convertToKelvin()
 {
 this.scale = "C";
 return this.value = getKelvin();
 }


 public boolean equals()
 {
 return this.value == this.value && this.scale == this.scale; 
 }

 public String toString()
 {
 String temps = ("The temperature is " + this.value + "(" + this.scale + ")");
 return temps;
 }

 }

    // instance variables - replace the example below with your own
   /*private double value;
   private String scale;
   private double DegreeC;
   private double DegreeF;

   

    public Temperature() // default constructor
    {
      value = 0;
      scale = "C";
    }

    public Temperature(double newValue, String newScale)
    {
       value = newValue;
        scale = newScale;
        
    }

  // Accessor and Mutators for each variables
   public void setNumber(double newValue) {
      value = newValue;
   }

   public double getValue() {
      return value;
   }
     public void setScale(String newScale) {
      scale = newScale;
    }

   public String getScale() {
      return scale;
   }
   public double getDegreeC()
   {
       if (scale.equalsIgnoreCase("C"))
       {
           return value;
           
       }
       else if (scale.equalsIgnoreCase("F"))
       {
           double DegreeF = ((value * 1.8) + 32 );
        }

      
    
   /*public void setValue(double newDegreeC, double newDegreeF )
   {
       DegreeC = newDegreeC;
       DegreeF = newDegreeF;
       
   }
   public double getValue()
   {  
       return DegreeF;
   }

  public String toString()
  {
      return "Temperature" + scale + ", " + number + "," + DegreeC + "," + DegreeF;
  }
   */
  

  
    


/******************************************************************

   Fraction Class : 
       invariant: numerator and a denominator are kept in reduced form
            if defined is false, numerator or denominator could be
            anything.
         two undefined fractions are considered equal.

   your job is to add an equals method and a hashCode method.
 ********************************************************************/

public class Fraction
{
    private int numerator;
    private int denominator;
    private boolean defined;


    public Fraction()
    {
        defined = false;
    }

    public Fraction (int num, int den)
    {
        if (den == 0)
            defined = false;
        else 
        {
           defined = true;
           numerator = num;
           denominator = den;
           reduce();
        }
    }


    public void resetFraction (int num, int den)
    {
        if (den == 0)
            defined = false;
        else 
        {
           defined = true;
           numerator = num;
           denominator = den;
           reduce();
        }
    }

    private void reduce()
    {
        int divisor;
        if (!defined)
            return;
        if (denominator < 0)
        {
            denominator = -denominator;
            numerator = -numerator;
        }
        divisor = gcd(numerator, denominator);
        numerator = numerator / divisor;
        denominator = denominator / divisor;
    } 

    private static int gcd (int num1, int num2)
    {
        int hold;
        if (num1 < 0)
           num1 = -num1;
        if (num2 < 0)
           num2 = -num2;
        while (num2 > 0)
        {
            hold = num2;
            num2 = num1 % num2;  
            num1 = hold;
        }
        return num1;
    }
            
    public void add(Fraction fraction1, Fraction fraction2)
    {
        if (!fraction1.defined || !fraction2.defined)
            defined = false;
        else
        {
           defined = true;
           denominator = fraction1.denominator * fraction2.denominator;
           numerator = fraction1.numerator * fraction2.denominator +
                    fraction2.numerator * fraction1.denominator;
           reduce();
        }
    }

    public void subtract(Fraction fraction1, Fraction fraction2)
    {
        if (!fraction1.defined || !fraction2.defined)
            defined = false;
        else
        {
            defined = true;
            denominator = fraction1.denominator * fraction2.denominator;
            numerator = fraction1.numerator * fraction2.denominator -
                    fraction2.numerator * fraction1.denominator;
            reduce();
        }
    }

    public void multiply(Fraction fraction1, Fraction fraction2)
    {
        if (!fraction1.defined || !fraction2.defined)
            defined = false;
        else
        {
            defined = true;
            denominator = fraction1.denominator * fraction2.denominator;
            numerator = fraction1.numerator * fraction2.numerator; 
            reduce();
        }
    }

    public void divide(Fraction fraction1, Fraction fraction2)
    {
        if (!fraction1.defined || !fraction2.defined)
            defined = false;
        else {
           defined = true;
           numerator = fraction1.numerator * fraction2.denominator; 
           denominator = fraction1.denominator * fraction2.numerator;
           reduce();
        }
    }

    public void printFraction()
    {

       System.out.println(toString());
    }

    public String toString()
    {
        String newString = "";
        int amountLeft;
        int wholeNumber;
        int newNumerator;

        if (!defined)
            return "####";

        if (numerator < 0)
        {
            newString += "-";
            newNumerator = -numerator;
        }
        else
            newNumerator = numerator;

        if (newNumerator > denominator)
        {
            wholeNumber = newNumerator / denominator;
            amountLeft = newNumerator % denominator;
            if (amountLeft > 0)
                newString =  newString + wholeNumber + " " + 
                              amountLeft + "/" + denominator;
            else 
                newString =  newString + wholeNumber;
         }
         else
                newString = newString + newNumerator + "/" + denominator; 
         return newString;
    }
    /**
     * @author Chris Campell
     * @date 4/6/2015
     * Overridden hashCode method returns a Hash Code for an object of type 'Fraction'. 
     * @return int -the calculated Hash Code for 'this' object. 
     */
    @Override
    public int hashCode() {
    	Fraction reduction = new Fraction(this.numerator,this.denominator);
    	if (!this.defined) {
    		return Integer.MIN_VALUE;
    	} else {
    		reduction.reduce();
    		return reduction.numerator + (reduction.denominator * 10); 
    	}
    }
    /**
     * @author Chris Campell
     * @date 4/6/2015
     * Overriden equals method compares 'this' with any Java 'Object'.
     * @return boolean -true if equal, false otherwise.  
     */
    @Override
    public boolean equals(Object obj) {
    	Fraction target; 
    	if (this == obj) {
    		return true; 
    	}
    	else if (!(obj instanceof Fraction)) {
    		return false; 
    	} else {
    		//Typecast to expected.  
    		target = ((Fraction) obj);
    		//check if both are invalid fractions
    		if (target.defined == false && this.defined == false) {
    			return true; 
    		} else if (target.defined == true && this.defined == false) {
    			return false; 
    		} else if (target.defined == false && this.defined == true) {
    			return false; 
    		} else {
    			//Both are valid fractions that are defined. 
    			//reduce the target for the equality check. 
    			target.reduce();
    			this.reduce(); 
    			if (target.numerator == this.numerator) {
    				return (target.denominator == this.denominator);
    			} else {
    				return false; 
    			}
    		}
    	}
    }
}


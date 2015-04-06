import java.util.Arrays;

/*********************************************************
   MyString is a wrapper class for a String, written so
   you can practice writing a hashCode() method.

   your job is to implement an equals method and a hashCode method.
 
 *********************************************************/

public class MyString
{
     private String myString;

     
     public MyString ()
     {
            myString = "";
     }

     public MyString (String str)
     {
            myString = str;
     }
 
     public void setString (String str)
     {
          myString = str;
     }

     public String getString()
     {
         return myString;
     }
     /**
      * Creates a Hash Code representation for 'this'.
      * Adapted from: Josh Bloch's "Effective Java 2nd Edition"
      */
     @Override
     public int hashCode() {
    	 //TODO: Resolve error that 2 runs of max size 20609
    	 	// produce 2 different results. One exceptional, and one terrible. 
    	 
    	 //Java Library Hash Code:
    	 	//s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
    	 //My Hash Code:
    	 //Store lowest prime number in result. 
    	 int result = 2;
    	 //Create a temp var to house the hashcode of the array. 
    	 int hc = 0; 
    	 //Create a hashcode for the char array. 
    	 hc = Arrays.hashCode(myString.toCharArray());
    	 //combine the hash code with a prime modifier:
    	 result = 31 * result + hc; 
    	 return result; 
     }
     @Override
     public boolean equals(Object obj) {
    	 //Q: Why does the statement: if (obj instanceof this){} not work? 
    	 
    	 if (obj == this) {
    		 return true; 
    	 }
    	 else if (!(obj instanceof MyString)) {
    		 return false; 
    	 } else {
    		 //Perform field check:
    		 return (((MyString) obj).myString).equals(myString); 
    	 }
     }
}

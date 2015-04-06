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
    	 //Store lowest prime number in result. 
    	 int result = 2; 
    	 //create a temp var to house the current hashcode. 
    	 int hc = 0; 
    	 //Create a hashcode for the char array. 
    	 for (char c : myString.toCharArray()) {
    		 hc = (int) c; 
    		 if (hc != 0) {
    			  result = 31 * hc + hc; 
    		 } else {
    			 //do nothing. NULL character. 
    		 }
    	 }
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

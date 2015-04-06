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
    	 int result = 1; 
    	 //Create a hashcode for the char array. 
    	 for (char c : myString.toCharArray()) {
    		 result = 31 * result + c; 
    	 }
    	 return result; 
     }
     /**
      * An appropriate equals method overridden from Object. 
      * @param obj -Any java Object to check for equality against. 
      * @return boolean -True if equal, false otherwise. 
      */
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

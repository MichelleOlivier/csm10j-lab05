//package lab05;

import java.util.Scanner;
/**
 *
 * @author Michelle
 */
public class Lab05 
{   
    static Scanner console = new Scanner(System.in);
    static String firstNumEntered, secondNumEntered;
    
    public static void main(String[] args) {
         //asks users for input and stores as variables firstNumEntered and secondNumEntered
        System.out.print("Enter the first number: ");
        firstNumEntered = console.next();
      
        System.out.print("Enter the second number: ");
        secondNumEntered = console.next();
        //converting input into char arrays
        char[] firstCharArray = firstNumEntered.toCharArray();
        char[] secondCharArray = secondNumEntered.toCharArray();
        // created a ternary to check which char array length is larger, and to store larger char array length as largestArrayLength
        int largestArrayLength = firstCharArray.length > secondCharArray.length ? firstCharArray.length : secondCharArray.length;
        // creating int arrays, + 1 needed in order to carry a digit later down the line
        int[] firstIntArray = new int[largestArrayLength + 1];
        int[] secondIntArray = new int[largestArrayLength + 1];
        // creating for loop 
        for (Integer index = firstCharArray.length - 1; index >= 0; index--)
            firstIntArray[index + (firstIntArray.length - firstCharArray.length)] = Integer.parseInt(String.valueOf(firstCharArray[index])); 
        // creating for loop
        for (Integer index = secondCharArray.length - 1; index >= 0; index--)
            secondIntArray[index + (secondIntArray.length - secondCharArray.length)] = Integer.parseInt(String.valueOf(secondCharArray[index])); 
       //additonArray to store sums 
       int[] additionArray = new int[largestArrayLength + 1];
       // creating for loop to carry sums over 9
       for (int index = largestArrayLength; index >= 0; index--)
       {
           int sum = firstIntArray[index] + secondIntArray[index];
           if (sum >= 10)
           {
               additionArray[index] = sum - 10;
               firstIntArray[index - 1]++;
           }
           else 
           {
               additionArray[index] = sum; 
           }
       }
            // printing first char array
           String printFirstCharArray = new String(firstCharArray); 
           System.out.println("     " + printFirstCharArray);
            // printing second char array
           String printSecondCharArray = new String(secondCharArray); 
           System.out.println("+    " + printSecondCharArray);
           
           //initializing theSum to "=      "
           String theSum = "=    ";
           // for loop to convert addition, taking into account that we don't want to print a 0 if the [0] element
           for (Integer index = 0; index < additionArray.length; index++)
           {
               String test = String.valueOf(additionArray[index]);
               if (index.equals(0))
               {
                   if (additionArray[0] != 0)
                    theSum += String.valueOf(additionArray[index]);
               }
               else 
                   theSum += String.valueOf(additionArray[index]);
           } 
           //printing sum
           System.out.println(theSum);
    }
}

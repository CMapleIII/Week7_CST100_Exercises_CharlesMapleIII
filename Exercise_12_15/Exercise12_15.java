/** 
*Program: Write and read Data
*File: Exercise12_15.java
*Summary: program to create a file named 
*Exercise12_15.txt if it does not exist. 
*Write 100 integers created randomly into 
*the file using text I/O. Integers are 
*separated by spaces in the file. Read the 
*data back from the file and display the 
*data in increasing order.
*Author: Charles Maple III
*Date: 8-4-2016 
**/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Exercise12_15 
{
	public static void main(String[] args) throws IOException 
	{
		String namedFile = "Exercise12_15.txt";
		
		java.io.File theFile = new java.io.File(namedFile);
            try (java.io.PrintWriter output = new java.io.PrintWriter(theFile))
            {
                for (int i = 1; i <= 100; i++) 									
                {
                    output.print(randomNumbers() + " ");
                }
            }
		readFile(namedFile);
	}
	
	public static int randomNumbers() 
	{
		Random randNum = new Random();
		int  randInt = randNum.nextInt(500) + 1;
		
		return randInt;
	}
	
	public static void readFile(String namedFile) throws IOException 
	{
		java.io.File theNewFile = new java.io.File(namedFile);
            try (Scanner input = new Scanner(theNewFile)) 
            {
                ArrayList<Integer> numbers = new ArrayList<>();
                
                while (input.hasNext())
                {
                    String number = input.next();
                    numbers.add(Integer.parseInt(number));
                }
                
                Collections.sort(numbers);
                
                numbers.stream().forEach((counter) -> {
                    System.out.println(counter);
                });
            }
	}
}
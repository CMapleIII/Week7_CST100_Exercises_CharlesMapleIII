/** 
*Program: Count Words
*File: Exercise12_19.java
*Summary: program that counts the 
*number of words in a text file.
* In addition to counting the words 
* in the text file, it converts the 
* words to lower case, removes any 
* punctuation and stores the words 
* with length <= 3 in an ArrayList.
*Author: Charles Maple III
*Date: 8-4-2016 
**/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise12_19 
{
	private static final ArrayList<String> smallWords = new ArrayList<>();
	private static final String beowulfFile = "BEOWULF.txt";
	private static int countChars = 0;
	private static int countWords = 0;
	
    public static void main(String[] args) throws IOException
    {
    	java.io.File fileName = new java.io.File(beowulfFile);
            try (Scanner input = new Scanner(fileName)) 
            {
                while (input.hasNext())
                {
                    String word = input.next();
                    word = word.toLowerCase();
                    word = word.replaceAll("\\W",  "");
                    countChars += word.length();
                    countWords++;
                    
                    if(word.length() <=3 && word.length() >= 1)
                        smallWords.add(word);
                }
            }

        System.out.println("Total word count = " + countWords);
        System.out.println("Total Letters: " + countChars);
        
        smallWords.stream().forEach((word) -> {
            System.out.println(word);
        });
    }

}
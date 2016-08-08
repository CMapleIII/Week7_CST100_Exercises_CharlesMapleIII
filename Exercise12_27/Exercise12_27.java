/** 
*Program: CountWords
*File: Exercise12_27.java
*Summary: Suppose you have a lot of files in a directory that contain    
* words Exercisei_j, where i and j are digits. Write a program that pads a 0     
* before i if i is a single digit and 0 before j if j is a single digit. For 
* example, the word Exercise2_1 in a file will be replaced by Exercise02_01. In  
* Java, when you pass the symbol * from the command line, it refers to all files
* in the directory.
*Author: Charles Maple III
*Date: 8-6-2016 
**/

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise12_27 
{
	
	public static void main(String[] args) throws Exception 
        {
		if (args.length < 1) 
                {
			System.out.println("Usage: java Exercise12_27 *");
			System.exit(1);
		}

		ArrayList<File> list = new ArrayList<>();

		addFiles(list, args);

		replaceWords(list);
	}
	public static void replaceWords(ArrayList<File> file) 
			throws FileNotFoundException 
        {

            file.stream().forEach((File file1) -> {
                ArrayList<String> list = new ArrayList<>();
                try ( final Scanner input = new Scanner(file1))
                {
                    while (input.hasNext())
                    {
                        String word = input.nextLine();
                        if (word.contains("Exercise"))
                        {
                            list.add(pad(word));
                        }
                        else
                            list.add(word);
                    }
                } 
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(Exercise12_27.class.getName()).log(Level.SEVERE, null, ex);
                }
                try (final PrintWriter output = new PrintWriter(file1))
                {
                    list.stream().forEach((list1) ->
                    {
                        output.println(list1);
                    });
                }
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(Exercise12_27.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
	}


	public static String pad(String word)
        {
		ArrayList<String> str = new ArrayList<>(Arrays.asList(word.split(" ")));

		for (int i = 0; i < str.size(); i++)
                {
			if (str.get(i).matches("Exercise\\d_\\d")) 
                        {
				StringBuilder newStr = new StringBuilder(str.get(i));
				newStr.insert(newStr.length() - 1, 0 + ""); 
				newStr.insert(8, '0');
				str.remove(i);
				str.add(i, newStr.toString());
			}
		}

		String s = "";
                s = str.stream().map((str1) -> str1 + " ").reduce(s, String::concat);
		return s;
	}
	public static void addFiles(ArrayList<File> list, String[] args)
        {
            for (String arg : args) 
            {
                if (!arg.equals("Exercise_12_27.java") && !arg.equals("Exercise_12_27.class")) 
                {
                    list.add(new File(arg));
                }
            }
	}
}
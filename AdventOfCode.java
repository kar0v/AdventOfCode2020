package learning;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files

public class AdventOfCode
{
   public static void main(String[] args)
   {
      ArrayList<Integer> arrayList = new ArrayList<>();
      // Reading file to array
      try
      {
         File file = new File("C:\\Users\\KrasimirKarov\\Desktop\\adventofcode.txt");
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine())
         {
            arrayList.add(Integer.parseInt(scanner.nextLine()));
         }
         scanner.close();
      } catch (FileNotFoundException e) {
         System.out.println("Check file path");
         e.printStackTrace();
      }

      Collections.sort(arrayList); // sort the array for meta-binary-search implementation
      boolean found = false; // loop control variable

      // result variables
      int a = 0;
      int b = 0;
      int c = 0;

      for (int i = 0; i < arrayList.size(); i++) {
         for (int j = arrayList.size() - 1; j >= 0; j--) {
            if (arrayList.get(i) + arrayList.get(j) == 2020)
            {
               found = true;
               System.out.println(arrayList.get(i) + " " + arrayList.get(j));
               a = arrayList.get(i);
               b = arrayList.get(j);
               break;
            }
         }
         if (found) break;
      }

      int res = a*b;
      System.out.println(res);

      // same search but looking for result of 2020 - n-th element. Optimization possible.
      found = false;
      for (int div = 0; div < arrayList.size(); div++)
      {
         for (int i = 0; i < arrayList.size(); i++) {
            for (int j = arrayList.size() - 1; j >= 0; j--) {
               if (arrayList.get(i) + arrayList.get(j) == 2020 - arrayList.get(div))
               {
                  found = true;
                  System.out.println(arrayList.get(i) + " " + arrayList.get(j) + " " + arrayList.get(div));
                  a = arrayList.get(i);
                  b = arrayList.get(j);
                  c = arrayList.get(div);
                  break;
               }
            }
            if (found) break;
         }
         if (found) break;
      }

      res = a*b*c;
      System.out.println(res);

   } // main
} // class

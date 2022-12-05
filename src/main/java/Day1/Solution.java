package Day1;

import java.io.*;
import java.util.*;


public class Solution {

    static String FILE_PATH = "./src/main/java/Day1/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int max = 0;
        int current = 0;
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            if (data.equals("")){
                if (current > max){
                    max = current;
                }
                current = 0;
            }
            else {
                current += Integer.parseInt(data);
            }
        }
        reader.close();
        System.out.println(max);
    }
}
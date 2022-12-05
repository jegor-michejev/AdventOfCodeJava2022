package Day1;

import java.io.*;
import java.util.*;


public class SolutionPart2 {

    static String FILE_PATH = "./src/main/java/Day1/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int max = 0;
        int second = 0;
        int third = 0;
        int current = 0;
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            if (!data.equals("")) {
                current += Integer.parseInt(data);
            }
            if (data.equals("") || !(reader.hasNextLine())){
                if (current > max){
                    third = second;
                    second = max;
                    max = current;
                }
                else if (current > second){
                    third = second;
                    second = current;
                }
                else if (current > third){
                    third = current;
                }
                current = 0;
            }
        }
        reader.close();
        System.out.println(max + second + third);
    }
}
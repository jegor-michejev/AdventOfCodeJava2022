package Day6;

import java.io.*;
import java.util.*;

public class Solution {

    static String FILE_PATH = "./src/main/java/Day6/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        String data = reader.nextLine();
        char first = data.charAt(0);
        char second = data.charAt(1);
        char third = data.charAt(2);
        int answer = 0;
        for (int i = 3; i < data.length(); i++){
            HashSet<Object> set = new HashSet<>();
            set.add(first);
            set.add(second);
            set.add(third);
            set.add(data.charAt(i));
            if (set.size() < 4){
                first = second;
                second = third;
                third = data.charAt(i);
            }
            else {
                answer = i + 1;
                break;
            }
        }

        System.out.println(answer);
        reader.close();
    }
}

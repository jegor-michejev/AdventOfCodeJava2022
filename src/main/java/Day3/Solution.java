package Day3;

import java.io.*;
import java.util.*;

public class Solution {

    static String FILE_PATH = "./src/main/java/Day3/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int answer = 0;
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            String one = data.substring(0,data.length()/2);
            String two = data.substring(data.length()/2, data.length());
            answer += findDuplicate(one, two);
        }

        System.out.println(answer);


        reader.close();
    }

    public static int findDuplicate(String s1, String s2){
        int dupe = 0;
        for (int i = 0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                if (s1.charAt(i) == s2.charAt(j)){
                    dupe = s1.charAt(i);
                    if (dupe < 'a') {
                        return dupe - 38;
                    }
                    else{
                        return dupe - 96;
                    }
                }
            }
        }
        return dupe;
    }
}

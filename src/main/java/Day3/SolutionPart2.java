package Day3;

import java.io.*;
import java.util.*;

public class SolutionPart2 {

    static String FILE_PATH = "./src/main/java/Day3/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int answer = 0;
        while (reader.hasNextLine()){
            String one = reader.nextLine();
            String two = reader.nextLine();
            String three = reader.nextLine();
            answer += findDuplicate(one, two, three);
        }

        System.out.println(answer);


        reader.close();
    }

    public static int findDuplicate(String s1, String s2, String s3){
        int dupe = 0;
        for (int i = 0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                for (int z = 0; z <s3.length(); z++){
                    if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(z)) {
                      dupe = s1.charAt(i);
                      if (dupe < 'a') {
                            return dupe - 38;
                        } else {
                            return dupe - 96;
                        }
                    }
                }
            }
        }
        return dupe;
    }
}

package Day4;

import java.io.*;
import java.util.*;

public class SolutionPart2 {

    static String FILE_PATH = "./src/main/java/Day4/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int answer = 0;
        while (reader.hasNext()) {
            String data = reader.nextLine();
            String[] pairs = data.split(",");
            String[] range1 = pairs[0].split("-");
            String[] range2 = pairs[1].split("-");
            if (Integer.parseInt(range1[0]) == Integer.parseInt(range2[0]) ||
                    Integer.parseInt(range1[0]) == Integer.parseInt(range2[1]) ||
                            Integer.parseInt(range1[1]) == Integer.parseInt(range2[0]) ||
                                    Integer.parseInt(range1[1]) == Integer.parseInt(range2[1]) ||
                    (Integer.parseInt(range1[0]) > Integer.parseInt(range2[0]) &&
                            Integer.parseInt(range1[0]) < Integer.parseInt(range2[1])) ||
                    (Integer.parseInt(range1[1]) > Integer.parseInt(range2[0]) &&
                            Integer.parseInt(range1[1]) < Integer.parseInt(range2[1])) ||
                    (Integer.parseInt(range2[0]) > Integer.parseInt(range1[0]) &&
                            Integer.parseInt(range2[0]) < Integer.parseInt(range1[1])) ||
                    (Integer.parseInt(range2[1]) > Integer.parseInt(range1[0]) &&
                            Integer.parseInt(range2[1]) < Integer.parseInt(range1[1]))
            ) {
                answer++;
            }
        }

        System.out.println(answer);
        reader.close();
    }
}

package Day6;

import java.io.*;
import java.util.*;

public class SolutionPart2 {

    static String FILE_PATH = "./src/main/java/Day6/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        String data = reader.nextLine();
        int answer = 0;
        for (int i = 0; i < data.length() - 14; i++){
            HashSet<Object> set = new HashSet<>();
            for (int j = i; j < i + 14; j++){
                set.add(data.charAt(j));
            }
            if (set.size() == 14){
                answer = i + 14;
                break;
            }
        }

        System.out.println(answer);
        reader.close();
    }
}

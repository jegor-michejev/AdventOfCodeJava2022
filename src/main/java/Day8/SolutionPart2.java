package Day8;

import java.io.*;
import java.util.*;

public class SolutionPart2 {

    static String FILE_PATH = "./src/main/java/Day8/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        ArrayList<ArrayList<Object>> lines = new ArrayList<>();

        while (reader.hasNextLine()){
            String data = reader.nextLine();
            ArrayList<Object> columns = new ArrayList<>();
            for (int i = 0; i < data.length(); i++){
                columns.add(data.charAt(i));
            }
            lines.add(columns);
        }

        int answer = 0;

        int length = lines.size();
        int width = lines.get(0).size();

        for (int x = 1; x < length - 1; x++){
            for (int y = 1; y < width - 1; y++){
                int sonicNumber = 0;
                int topNumber = 0;
                int bottomNumber = 0;
                int leftNumber = 0;
                int rightNumber = 0;
                char tree = (char) lines.get(x).get(y);
                for (int i = x + 1; i < length ; i++){
                    rightNumber++;
                    if (tree <= (char) lines.get(i).get(y)) {
                        break;
                    }
                }
                for (int i = x - 1; i >= 0; i--){
                    leftNumber++;
                    if (tree <= (char) lines.get(i).get(y)) {
                        break;
                    }
                }
                for (int i = y + 1; i < width; i++){
                    bottomNumber++;
                    if (tree <= (char) lines.get(x).get(i)) {
                        break;
                    }
                }
                for (int i = y - 1; i >= 0; i--){
                    topNumber++;
                    if (tree <= (char) lines.get(x).get(i)) {
                        break;
                    }
                }
                sonicNumber = topNumber * bottomNumber * leftNumber * rightNumber;
                if (sonicNumber > answer){
                    answer = sonicNumber;
                }
            }
        }

        System.out.println(answer);
        reader.close();
    }
}

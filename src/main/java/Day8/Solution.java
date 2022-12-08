package Day8;

import java.io.*;
import java.util.*;

public class Solution {

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

        int answer = (lines.size() * 2) + (lines.get(0).size() * 2) - 4;

        int length = lines.size();
        int width = lines.get(0).size();

        for (int x = 1; x < length - 1; x++){
            for (int y = 1; y < width - 1; y++){
                boolean isVisibleTop = true;
                boolean isVisibleBottom = true;
                boolean isVisibleLeft = true;
                boolean isVisibleRight = true;
                char tree = (char) lines.get(x).get(y);
                for (int i = x + 1; i < length ; i++){
                    if (tree <= (char) lines.get(i).get(y)) {
                        isVisibleRight = false;
                        break;
                    }
                }
                for (int i = x - 1; i >= 0; i--){
                    if (tree <= (char) lines.get(i).get(y)) {
                        isVisibleLeft = false;
                        break;
                    }
                }
                for (int i = y + 1; i < width; i++){
                    if (tree <= (char) lines.get(x).get(i)) {
                        isVisibleBottom = false;
                        break;
                    }
                }
                for (int i = y - 1; i >= 0; i--){
                    if (tree <= (char) lines.get(x).get(i)) {
                        isVisibleTop = false;
                        break;
                    }
                }
                if (isVisibleBottom || isVisibleLeft ||
                isVisibleTop || isVisibleRight) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        reader.close();
    }
}

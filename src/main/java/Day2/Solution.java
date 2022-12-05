package Day2;

import java.io.*;
import java.util.*;

public class Solution {

    static String FILE_PATH = "./src/main/java/Day2/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int score = 0;
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            char opponent = line.charAt(0);
            char player = line.charAt(2);
            switch (player){
                case 'X':
                    score += 1;
                    break;
                case 'Y':
                    score += 2;
                    break;
                case 'Z':
                    score += 3;
                    break;
            }
            score += calculateResult(player, opponent);
        }
        reader.close();
        System.out.println(score);
    }

    public static int calculateResult(char player, char opponent){
        if ((player == 'X' && opponent == 'C') ||
                (player == 'Y' && opponent == 'A') ||
                (player == 'Z' && opponent == 'B')){
            return 6;
        }
        else if ((player == 'X' && opponent == 'A') ||
                (player == 'Y' && opponent == 'B') ||
                (player == 'Z' && opponent == 'C')){
            return 3;
        }
        else {
            return 0;
        }
    }
}

package Day2;

import java.io.*;
import java.util.*;

public class SolutionPart2 {

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
                    score += 0;
                    break;
                case 'Y':
                    score += 3;
                    break;
                case 'Z':
                    score += 6;
                    break;
            }
            score += calculateResult(player, opponent);
        }
        reader.close();
        System.out.println(score);
    }

    public static int calculateResult(char player, char opponent){
        if ((player == 'X' && opponent == 'B') ||
                (player == 'Y' && opponent == 'A') ||
                (player == 'Z' && opponent == 'C')){
            return 1;
        }
        else if ((player == 'X' && opponent == 'C') ||
                (player == 'Y' && opponent == 'B') ||
                (player == 'Z' && opponent == 'A')){
            return 2;
        }
        else {
            return 3;
        }
    }
}

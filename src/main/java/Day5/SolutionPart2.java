package Day5;

import java.io.*;
import java.util.*;

public class SolutionPart2 {

    static String FILE_PATH = "./src/main/java/Day5/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        StringBuilder answer = new StringBuilder();
        int columnAmount = 0;
        ArrayList<ArrayList<Object>> levels = new ArrayList<>();

        //Initial Data Harvest
        while (reader.hasNext()){
            String data = reader.nextLine();
            if (data.equals("")){
                break;
            }
            ArrayList<Object> columns = new ArrayList<>();
            int currentColumns = 0;
            for (int i = 1; i < data.length(); i += 4){
                currentColumns++;
                if(currentColumns > columnAmount){
                    columnAmount = currentColumns;
                }
                columns.add(data.charAt(i));
            }
            levels.add(columns);
        }


        //Buffering
        for (ArrayList<Object> level : levels) {
            while (level.size() < columnAmount) {
                level.add(' ');
            }
        }

        ArrayList<ArrayList<Object>> columns = new ArrayList<>();
        for (int i = 0; i < columnAmount; i++){
            ArrayList<Object> crates = new ArrayList<>();
            for (ArrayList<Object> level : levels) {
                if ((char) level.get(i) != ' ') {
                    crates.add(level.get(i));
                }
            }
            columns.add(crates);
        }

        //Execution
        reader.next();
        while (reader.hasNext()){
            String[] command = reader.nextLine().split(" ");
            int amount = Integer.parseInt(command[1]);
            int from = Integer.parseInt(command[3]) - 1;
            int to = Integer.parseInt(command[5]) - 1;
            for (int i = 0; i < amount; i++){
                columns.get(to).add(i, columns.get(from).get(0));
                columns.get(from).remove(0);
            }
        }



        //Answer Output building
        for (int i = 0; i < columnAmount; i++){
            answer.append(columns.get(i).get(0));
        }

        reader.close();
        System.out.println(answer);
    }
}

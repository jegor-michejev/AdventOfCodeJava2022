package Day7;

import java.io.*;
import java.util.*;

public class Solution {

    static String FILE_PATH = "./src/main/java/Day7/input.txt";

    public static void main(String[] args) throws FileNotFoundException{
        File inputFile = new File(FILE_PATH);
        Scanner reader = new Scanner(inputFile);
        int answer = 0;
        ArrayList<Directory> directories = new ArrayList<Directory>();
        directories.add(new Directory());
        Directory currentDir = directories.get(0);
        while (reader.hasNext()) {
            String line = reader.nextLine();
            String[] vars = line.split(" ");
            if (vars[0].equals("$")){
                if (vars[1].equals("cd")){
                    switch (vars[2]) {
                        case "/" -> currentDir = directories.get(0);
                        case ".." -> currentDir = currentDir.getParent();
                        default -> {
                            currentDir = new Directory(vars[2], currentDir);
                            currentDir.getParent().addChild(currentDir);
                            directories.add(currentDir);
                        }
                    }
                }
            }
            else if (!vars[0].equals("dir")){
                currentDir.addSize(Integer.parseInt(vars[0]));
            }

        }
        for (Directory d:directories){
            if (d.getName().equals("/")){
                continue;
            }
            if (d.getSize() <= 100000){
                answer += d.getSize();
            }
        }
        System.out.println(answer);
        reader.close();
    }

    private static class Directory {

        String name;
        Directory parent;
        ArrayList<Directory> children;
        int size;

        public Directory(String name, Directory parent){
            this.name = name;
            this.parent = parent;
            children = new ArrayList<Directory>();
            this.size = 0;
        }

        public Directory(){
            this.name = "/";
            children = new ArrayList<Directory>();
            this.size = 0;
        }

        public void addSize(int size){
            this.size += size;
        }

        public String getName() {
            return name;
        }

        public Directory getParent() {
            return parent;
        }

        public ArrayList<Directory> getChildren() {
            return children;
        }

        public int getSize() {
            int fullSize = size;
            for (Directory d:children){
                fullSize += d.getSize();
            }
            return fullSize;
        }

        public void setSize(int size){
            this.size = size;
        }

        public void addChild(Directory child) {
            children.add(child);
        }
    }
}

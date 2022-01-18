/*
*   Design and write a Java program to read the file system beneath a particular folder, and store it in a tree data structure.
*
*   THE PROGRAM ACCOMPLISHES TWO TASKS:
*   1- LOOKS AT A FOLDER AND ITS SUBFOLDERS
*   2- REPRESENTS THE FILES IN A TREE DATA STRUCTURE
*   OUTPUT the tree in a way that shows the tree hierarchy
*   (e.g., one line per tree node, and indent each node appropriately)
*
*   USE RECURSION both in the scanning part of your program, and the part that outputs the tree
*/

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileSysReader {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the path of the file without quotations:");
        String filePath = s.nextLine();

        Path currentPath = Paths.get(filePath);
        Tree firstTree = new Tree(currentPath);
    } // End of main
}

/*
*   Design and write a Java program to read the file system beneath a particular folder, and store it in a tree data structure.
*
*   THE PROGRAM ACCOMPLISHES TWO TASKS:
*   1- LOOK AT A FOLDER AND ITS SUBFOLDERS
*   2- REPRESENTS THE FILES IN A TREE DATA STRUCTURE
*   OUTPUT the tree in a way that shows the tree hierarchy
*   (e.g., one line per tree node, and indent each node appropriately)
*
*   USE RECURSION both in the scanning part of your program, and the part that outputs the tree
*/

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileSysReader {
    public static String spacesToPrint(int depth) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < depth; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

    public static void scanDirectory(Path path, int depthLevel) throws Exception {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

        if(attributes.isDirectory()) {
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);

            System.out.println(spacesToPrint(depthLevel) + " > " + path.getFileName());

            for(Path tempPath: paths) {
                scanDirectory(tempPath, depthLevel + 1);
            }
        }
        else {
            System.out.println(spacesToPrint(depthLevel) + " -- " + path.getFileName());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the path of the file without quotations:");
        String filePath = s.nextLine();

        Path currentPath = Paths.get(filePath);
        scanDirectory(currentPath, 0);

//        Tree firstTree = new Tree();
    } // End of main






}

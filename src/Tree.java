/*
    EACH NODE = folder in the file system
    NODE'S DATA = the number of files, the total size of the files, the folder's name, and a list of child folders
*/

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Tree {
    class Node {
        // Data in Node
        long fileSize;
        String folderName;

        // Children
        ArrayList<Node> childrenFiles;

        Node(Path pathAddress) {
            try {
                this.fileSize = Files.size(pathAddress);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path pathFolderName = pathAddress.getFileName();
            this.folderName = pathFolderName.toString();

            childrenFiles = new ArrayList<>();
        } // Node constructor
    } // End of Node class

    private Node root;
    private final int rootDepthLevel = 0;

    Tree(Path pathProvided) throws Exception {
        this.root = scanDirectory(pathProvided, rootDepthLevel);
    } // End of Tree constructor

    public static String spacesToPrint(int depth) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < depth; i++) {
            builder.append("  ");
        }
        return builder.toString();
    } // End of spacesToPrint()

    public Node scanDirectory(Path parentFolder, int depthLevel) throws Exception {
        Node currentNode = new Node(parentFolder);
        BasicFileAttributes attributes = Files.readAttributes(parentFolder, BasicFileAttributes.class);

        if(attributes.isDirectory()) {
            DirectoryStream<Path> paths = Files.newDirectoryStream(parentFolder);
            System.out.println(spacesToPrint(depthLevel) + "(Folder) > " + currentNode.folderName);

            for(Path tempPath: paths) {
                Node childNode = scanDirectory(tempPath, depthLevel + 1);
                currentNode.childrenFiles.add(childNode);
            }
        } else {
            System.out.println(spacesToPrint(depthLevel) + " (File) -- " + currentNode.folderName + " (" + currentNode.fileSize + " Bytes)");
        }

        return currentNode;
    } // End of scanDirectory()
} // End of Tree class

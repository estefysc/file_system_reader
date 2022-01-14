// EACH NODE = folder in the file system
// NODE'S DATA = the number of files, the total size of the files, the folder's name, and a list of child folders


import java.util.ArrayList;
import java.util.Scanner;

public class Tree {
    class Node {
        // Data in Node
//        int numberOfFiles;
//        long fileSize;
        String folderName;
        ArrayList<String> fileNames;

        // Children
        ArrayList<Node> childFolders;

        Node(/*int amountOfFiles, long sizeOfFile,*/ String name) {
//            this.numberOfFiles = amountOfFiles;
//            this.fileSize = sizeOfFile;
            this.folderName = name;

            childFolders = new ArrayList<>();
        } // Node constructor
    } // End of Node class

    private Node root;

    Tree() {
        Scanner s = new Scanner(System.in);
        this.root = constructTree(s, null, 0);
    } // Tree constructor

    // i = current node level
    private Node constructTree(Scanner s, Node parentNode, int i) {
        // if parentNode is null, then it is the root node.
        if (parentNode == null) {
            System.out.println("Enter the name for the root node");
        } else {
            System.out.println("Enter the name for the " + i + "th child of " + parentNode.folderName);
        }

        String nodeName = s.nextLine();
        Node currentNode = new Node(nodeName);

        System.out.println("Enter the number of children for " + currentNode.folderName);
        int n = s.nextInt(); // todo CODE BREAKS WHEN THIS IS 0
        /* s.nextLine() below is needed because the Scanner.nextInt method does not read the newline character in the input created by hitting "Enter"
        and so the call to Scanner.nextLine returns after reading that newline. If not used, the program will not register the child's node name when the
        recursion starts.
        */
        s.nextLine();

        if(n != 0) {
            for(int j = 0; j < n; j++) {
                Node childNode = constructTree(s, currentNode, j);
                currentNode.childFolders.add(childNode);
            }
        }

        return currentNode;
    }



}

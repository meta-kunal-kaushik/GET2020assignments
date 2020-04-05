package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used to perform command prompt operations.
 */
public class CommandPrompt {
    Node root = new Node("root");
    Node currentDirectory = root;

    /**
     * This method is used to create new directory
     * 
     * @param directoryName
     * @return
     */ 
    boolean makeDirectory(String directoryName) {
        boolean result = false;
        if (!searchDirectory(directoryName, this.currentDirectory)) { 
            Node newDirectory = new Node(directoryName);
            newDirectory.parentNode = currentDirectory;
            currentDirectory.subDirectory.add(newDirectory);
            result = true;
        } else {
            System.out.println("Directory is already available.");
        }
        return result;
    }

    /**
     * This method is used to search a directory.
     * 
     * @param directoryName
     * @param currentDirectory 
     * @return
     */
    boolean searchDirectory(String directoryName, Node currentDirectory) {
        boolean result = false;
        for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
            if (currentDirectory.subDirectory.get(i).directoryName
                    .equals(directoryName)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * This method is used to give all folder name with their creation date and
     * time along with their first level of subfolders.
     * 
     * @return
     */
    List<List<String>> listAllDirectory() {
        List<List<String>> allDirectory = new ArrayList<List<String>>();
        List<String> currentFolders = new ArrayList<String>();
        List<String> subFolders = new ArrayList<String>();
        for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
            Node folder = currentDirectory.subDirectory.get(i);
            currentFolders.add(folder.directoryName + "  "
                    + folder.creationDate);
            for (int j = 0; j < folder.subDirectory.size(); j++) {
                subFolders.add(folder.subDirectory.get(j).directoryName + "  "
                        + folder.subDirectory.get(j).creationDate);
            }
        }
        allDirectory.add(currentFolders);
        allDirectory.add(subFolders);
        System.out.println(allDirectory);
        return allDirectory;
    }

    /**
     * This method is used to change the directory.
     * 
     * @param directoryName
     *            
     */
    void changeDirectory(String directoryName) {
        boolean find = false;
        for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
            if (currentDirectory.subDirectory.get(i).directoryName
                    .equals(directoryName)) {
                currentDirectory = currentDirectory.subDirectory.get(i);
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("No Such Directory Exists");
        }
    }

    /**
     * This method return paths of a directory name presents in whole tree.
     * 
     * @param directoryName
     *          
     * @return
     */

    List<String> findDirectory(String directoryName) {
        List<String> paths = new ArrayList<String>();
        findDirectoryPath(directoryName, root, paths);
        return paths;
    }

    /**
     * This method is used to calculate path for given directory.
     * 
     * @param directoryName
     *            name of directory that wants to find.
     * @param directory
     *            represent current directory in which find the directory.
     * @param paths
     *            represents a list to store paths.
     */
    void findDirectoryPath(String directoryName, Node directory,
            List<String> paths) {
        for (int index = 0; index < directory.subDirectory.size(); index++) {
            if (directory.subDirectory.get(index).directoryName
                    .equals(directoryName)) {
                String path = "";
                Node pathFolder = directory.subDirectory.get(index).parentNode;
                while (pathFolder.parentNode != null) {
                    
                    path = pathFolder.directoryName + "\\" + path;
                    System.out.println("path--->" +path);
                    pathFolder = pathFolder.parentNode;
                }
                
                paths.add("root\\" + path);

            } else {
                findDirectoryPath(directoryName, directory.subDirectory.get(index),
                        paths);
            }
        }
    }

    /**
     * This method is used to go to parent directory from current directory.
     */
    void backToParentDirectory() {
        if (currentDirectory.parentNode == null) {
            System.out.println("You are in root directory");
        } else {
            currentDirectory = currentDirectory.parentNode;
        }
    }

    /**
     * This method is used to display tree structure of directories.
     * 
     * @param node
     *            directory to represents its structure.
     */
    void displayDirectoryStructure(Node node) {
        try {
            if (node.subDirectory.size() == 0) {
                System.out.println();
                return;
            }
            for (Node i : node.subDirectory) {
                System.out.println(" " + i.directoryName);
                displayDirectoryStructure(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is used to display tree structure by calling function.
     */
    void displayDirectoryStructure() {
        displayDirectoryStructure(root);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String commandInput;
        String[] command;
        CommandPrompt cp = new CommandPrompt();
        while (true) {
            try {
                System.out
                        .println("Enter Command:\tmkdir\tls\tcd\tbk\tfind\ttree\texit");
                commandInput = sc.nextLine();
                command = commandInput.split(" ");

                switch (command[0]) {
                case "mkdir":
                    cp.makeDirectory(command[1]);
                    break;

                case "ls":
                    List<List<String>> allFolders = cp.listAllDirectory();
                    List<String> currentFolders = allFolders.get(0);
                    List<String> subFolders = allFolders.get(1);
                    System.out.println("Current Directory: "
                            + cp.currentDirectory.directoryName);
                    System.out.println("Current Folders: ");
                    for (int index = 0;index < currentFolders.size(); index++) {
                        System.out.println(currentFolders.get(index));
                    }
                    System.out.println("Sub Folders: ");
                    for (int index = 0; index < subFolders.size(); index++) {
                        System.out.println(subFolders.get(index));
                    }
                    break;

                case "cd":
                    cp.changeDirectory(command[1]);
                    break;

                case "bk":
                    cp.backToParentDirectory();
                    break;

                case "find":
                    List<String> paths = cp.findDirectory(command[1]);
                    if (paths.size() == 0) {
                        System.out.println("Directory not available");
                    } else {
                        for (int i = 0; i < paths.size(); i++) {
                            System.out.println(paths.get(i));
                        }
                    }
                    break;

                case "tree":
                    cp.displayDirectoryStructure();
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Command Not Exists");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Command");
            }
//            sc.close();
        }

    }

}
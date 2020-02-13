package part3.demo1;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        File dir = new File("");
        printDir(dir);
    }

    private static void printDir(File dir) {
        //get sub-files and dir
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                //if it is file ,then print it's absolute path
                System.out.println("file name: " + file.getAbsolutePath());
            } else {
                printDir(file);
            }
        }
    }
}

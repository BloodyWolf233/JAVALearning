package part3.demo2;

import java.io.File;
import java.util.Collections;

public class FileDir {
    public static void main(String[] args) {
        File dir = new File("D:");
        printDir(dir, 0);

    }

    private static void printDir(File dir, int deep) {
        File[] files = dir.listFiles();

        for (File file : files) {
            String s = new String().join("", Collections.nCopies(deep, " "));
            if (file.isFile()) {
                System.out.println(s + "  " + file.getName());
            } else {
                System.out.println(s + "+" + file.getName());
                printDir(file, deep++);
            }
        }
    }
}

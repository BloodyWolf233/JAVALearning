package part3.demo1;

import java.io.File;

public class FileFilter {
    public static void main(String[] args) {
        File dir = new File("D:");
        //printDir2(dir);
        printDir3(dir);
    }


    private static void printDir2(File dir) {
        File[] files = dir.listFiles(
                new java.io.FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().endsWith(".java")||pathname.isDirectory();
                    }
                }
        );

        for (File file :files) {
            if (file.isFile()){
                System.out.println("File name: "+ file.getAbsolutePath());
            }else{
                printDir2(file);
            }
        }
    }

    private static void printDir3(File dir) {
        File[] files = dir.listFiles(
                file -> {return file.getName().endsWith(".java")|| file.isDirectory();}
        );

        for (File file :files) {
            if (file.isFile()){
                System.out.println("file name: "+file.getAbsolutePath());
            }else {
                printDir3(file);
            }
        }
    }
}

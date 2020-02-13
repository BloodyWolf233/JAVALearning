package part3.demo6;

import java.io.*;
import java.util.ArrayList;

public class serTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath = "src\\part3\\demo6\\";

        //1. set a list to store Student object
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Alice", "Washington DC", 18));
        list.add(new Student("Bob", " LA", 11));
        list.add(new Student("Caesar", "Roma", 32));

        //2. create ObjectOutputStream object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath+"list.txt"));

        //3. write
        oos.writeObject(list);

        //4.create ObjectInputStream object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath+"list.txt"));

        //4. read
        Object o = ois.readObject();
        //5. print
        ArrayList<Student> list2 = (ArrayList<Student>) o;
        for (Student s : list2) {
            System.out.println(s);
        }
        //6. close
        oos.close();
        ois.close();
    }
}

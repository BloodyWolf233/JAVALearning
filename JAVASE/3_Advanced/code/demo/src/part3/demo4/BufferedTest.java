package part3.demo4;

import java.io.*;
import java.util.HashMap;

public class BufferedTest {
    public static void main(String[] args) throws IOException {
        String filepath = "src\\part3\\demo4\\";

        //create map to store the data; number is the key, and word are the value
        HashMap<String, String> lineMap = new HashMap<>();

        //create steam object
        BufferedReader br = new BufferedReader(new FileReader(filepath+"in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath+"out.txt"));

        //read data
        String line = null;
        while ((line = br.readLine())!=null){
            String[] split = line.split("\\.");
            lineMap.put(split[0],split[1]);
        }
        //release
        br.close();

        for (int i = 1;i<=lineMap.size();i++){
            String key = String.valueOf(i);
            String value = lineMap.get(key);
            //write
            bw.write(key+"."+value);
            bw.newLine();
        }
        bw.close();
    }
}

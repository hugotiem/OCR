package model;

import java.io.*;
import java.util.ArrayList;

public class TxTReader {

    private static File file;

    public static ArrayList<String> getData(String name) throws FileNotFoundException, IOException {

        ArrayList<String> data = new ArrayList<>();
        //String fileName = getFileName(name);
        file = new File(name+".txt");

        FileReader fr = new FileReader(file.getAbsoluteFile());
        BufferedReader br = new BufferedReader(fr);

        String ligne;

        while((ligne = br.readLine()) != null){
            data.add(ligne);
        }
        br.close();

        return data;
    }
}


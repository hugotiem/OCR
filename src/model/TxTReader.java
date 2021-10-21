package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TxTReader {

    private static File file;

    public static ArrayList<ArrayList<String>> read(String name) throws FileNotFoundException, IOException {

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        file = new File(name);

        FileReader fr = new FileReader(file.getAbsoluteFile());
        BufferedReader br = new BufferedReader(fr);

        String ligne;

        while((ligne = br.readLine()) != null){
            if(ligne.isBlank()) {
                result.add(data);
                data = new ArrayList<>();
            } else {
                data.add(ligne);
            }
        }
        br.close();

        return result;
    }

    public static void write(HashMap<String, Boolean> values) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        System.out.println(values);
        for(Entry<String, Boolean> value : values.entrySet()) {
            String suffix = !value.getValue() ? "ERR" : "";
            writer.println(value.getKey() + " " + suffix);
        }
        
        writer.close();
    }
}


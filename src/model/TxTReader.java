package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class TxTReader {


    private static File file;


    //--Lecture du fichier txt d'entrée--// 
    public static ArrayList<ArrayList<String>> read(String name) throws FileNotFoundException, IOException {

        //--Initialisation--//
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        file = new File(name);
        FileReader fr = new FileReader(file.getAbsoluteFile());
        BufferedReader br = new BufferedReader(fr);
        String ligne;

        //--Detection nouveau code--//
        while((ligne = br.readLine()) != null){
            if(ligne.isBlank()) {
                result.add(data);
                data = new ArrayList<>();
            }
            else {
                data.add(ligne);
            }
        }
        br.close();
        return result;
    }


    //--Creation et ecriture d'un fichier txt--//
    public static void write(HashMap<String, Boolean> values) throws FileNotFoundException, UnsupportedEncodingException {

        //--Initialisation--//
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        String suffix;

        //--Déclaration état--//
        for(Entry<String, Boolean> value : values.entrySet()) {
            if(value.getKey().contains("?")) {
                suffix = "ILL";
            }
            else {
                suffix = !value.getValue() ? "ERR" : "";
            }
            writer.println(value.getKey() + " " + suffix);
        }
        writer.close();
    }
}


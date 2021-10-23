package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class TxTReader {


    private static File file;


    /**
     * Lecture du fichier txt d'entrée
     * @param name the path of the txt file
     * @return ArrayList of txt file line content
     * @throws FileNotFoundException if path doesn't match with a file
     * @throws IOException
     */

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


    /**
     * Creation et ecriture d'un fichier txt
     * @param values values to write in a txt file
     * @throws FileNotFoundException if the path does not match
     * @throws UnsupportedEncodingException if unsupported encoding are used to write in the file
     */

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


package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Launcher {
  public static void launch() throws Exception {
    Parser parser = new Parser();
            ArrayList<ArrayList<String>> data = TxTReader.read("src/txt/test.txt");
            HashMap<String, Boolean> result = new HashMap<>();
            
            for (ArrayList<String> arrayList : data) {

                //--Affichage console ArrayList--//
                // System.out.println(arrayList);//

                ArrayList<String> changed = parser.arrayReader(arrayList);
                ArrayList<Integer> tab = new ArrayList<Integer>();

                for (String item : changed) {
                    tab.add(parser.parse(parser.decode(item)));
                }

                boolean checksum = parser.checksum(tab);
                String output = parser.intToString(tab);
                
                result.put(output, checksum);
            }

            TxTReader.write(result);
  } 
}

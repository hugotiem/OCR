package model;

import java.util.ArrayList;
import java.util.HashMap;


public class Parser {

    //--Déclaration--//
    private HashMap<String, Integer> map;


    //--Valeurs de comparaisons--//
    public  Parser() {
        this.map = new HashMap<String, Integer>();
        map.put("010101111", 0);
        map.put("000001001", 1);
        map.put("010011110", 2);
        map.put("010011011", 3);
        map.put("000111001", 4);
        map.put("010110011", 5);
        map.put("010110111", 6);
        map.put("010001001", 7);
        map.put("010111111", 8);
        map.put("010111011", 9);
    }


    //--Transforme un tableau en un string--//
    public ArrayList<String> arrayReader(ArrayList<String> array) {
        ArrayList<String> results = new ArrayList<String>();
        //--Affichage tableau--//
        //System.out.println(array.get(0).length());//
        for(int j = 0; j < array.get(0).length(); j+=3) {
            String s = "";
            for(int i = 0; i< 3; i++) {
                s += array.get(i).charAt(j);
                s += array.get(i).charAt(j+1);
                s += array.get(i).charAt(j+2);
            }
            results.add(s);
        }
        return results;
    }


    //--Transformation des caractères en code Binaire--//
    public String decode(String stringToDecode) {
        String result = "";
        String[] decomposedString = stringToDecode.split("");
        for(String s: decomposedString) {
            if(s.equals(" ")) {
                result += "0";
            }
            else {
                result += "1";
            }
        }
        return result;
    }


    //--Comparaison entre les valeurs récuperées et nos Valeurs de comparaisons--//
    public int parse(String value) {
        System.out.println(value);
        if (map.containsKey(value)) {
            return map.get(value);
        }
        return -1;
    }


    //--Analyse Caractère Inconnu--
    public String intToString(ArrayList<Integer> values) {
        String result = "";
        for (int i : values) {
            if(i == -1) {
                result += "?";
            }
            else {
                result += String.valueOf(i);
            }
        }
        return result;
    }
    

    //--Checksum--//
    public boolean checksum(ArrayList<Integer> values) {
        int element = 0;
        for(int i = 1 ; i <= values.size() ; i++) {
            // System.out.println(i + " * " + values.get(values.size()-i));//
            element += i*values.get(values.size()-i);
        }
        return element % 11 == 0;
    }
}

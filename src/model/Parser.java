package model;

import java.util.HashMap;

public class Parser {

    private HashMap<String, Integer> map;

    public  Parser() {
        this.map = new HashMap<String, Integer>();
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

    public int parse(String value) {
        if (map.containsKey(value)) {
            return map.get(value);
        }
        return -1;
    }

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
}

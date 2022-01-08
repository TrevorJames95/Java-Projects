package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Index {
    HashMap<Integer, String> index;
    ArrayList<String> list;

    public Index(){
        index = new HashMap<>();
        list = new ArrayList<>();
    }

    public void print() {
        for (String s: index.values()) {
            System.out.println(s);
        }
    }

    public void buildMap(String fileName){
        try(BufferedReader file = new BufferedReader(new FileReader(fileName)))
        {
            String ln;
            int i = 0;
            while( (ln = file.readLine()) !=null) {
                index.put(i, ln);
                i++;
            }
        } catch (IOException e){
            System.out.println("File "+fileName+" not found. Skip it");
        }
    }


    public void findAll(String phrase){
        for (int i = 0; i < index.size(); i++) {
            String[] words = index.get(i).toLowerCase().split("\\s+");
            for (String word : words) {
                if (phrase.equalsIgnoreCase(word)) {
                    list.add(index.get(i));
                }
            }
        }

        if(list.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(list.size() + " persons found:");
            list.forEach(System.out::println);
        }
        list.clear();
    }

    public void findAny(String phrase){
        for (int i = 0; i < index.size(); i++) {
            boolean found = true;
            for (String word : phrase.split(" ")) {
                if(index.get(i).toLowerCase().contains(word)) {
                    list.add(index.get(i));
                    break;
                }
            }
        }

        if(list.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(list.size() + " persons found:");
            list.forEach(System.out::println);
        }
        list.clear();
    }

    public void findNone(String phrase){
        for (int i = 0; i < index.size(); i++) {
            boolean found = false;
            for (String word : phrase.split(" ")) {
                if(index.get(i).toLowerCase().contains(word)) {
                    found = true;
                    break;
                }
            }
            if(found == false) {
                list.add(index.get(i));
            }
        }

        if(list.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(list.size()  + " persons found:");
            list.forEach(System.out::println);
        }
        list.clear();
    }
}

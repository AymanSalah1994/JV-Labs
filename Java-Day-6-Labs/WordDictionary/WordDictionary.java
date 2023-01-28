import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordDictionary {
    public static void main(String[] args) {
        ArrayList<String> randomNames = new ArrayList<>();
        randomNames.add("Salah");
        randomNames.add("Tawfik");
        // TODO : for Random Names insert List
        MyDictionary dict = new MyDictionary();
        dict.getAllData();
        dict.getSingleData('K');
        dict.insertWord("Kemo");
        dict.insertWord("Ayman");
        dict.insertWord("Ali");
        dict.insertWord("Azma");
        dict.insertWord("Abman");
        dict.insertList(randomNames);
        dict.getAllData();
        dict.getSingleData('A');

    } // End of Main
} // End Of Main Class

class MyDictionary {
    Map<Character, ArrayList<String>> allData = new TreeMap<>();

    public void insertWord(String insertedName) {
        Character key_Char = insertedName.charAt(0);
        if (this.allData.get(key_Char) == null) {
            ArrayList<String> dictEntry = new ArrayList<String>();
            dictEntry.add(insertedName);
            allData.put(key_Char, dictEntry);
        } else {
            this.allData.get(key_Char).add(insertedName);
        }
    }

    public void getAllData() {
        if (allData.isEmpty()) {
            System.out.println("Please Enter Data , there is not Data At All ");
        } else {
            // System.out.println(this.allData.toString());
            this.allData.forEach((k, v) -> {
                System.out.println("Key : " + k);
                System.out.println("Data : ");
                v.sort(Comparator.naturalOrder());
                System.out.println(v);
            });
        }
    }

    public void getSingleData(Character key) {
        ArrayList<String> requestedData = this.allData.get(key);
        if (requestedData == null) {
            System.err.println("Record is Empty for this key");
        } else {
            requestedData.sort(Comparator.naturalOrder());
            // Collections.sort() ; ??
            System.out.println(requestedData);
        }
        // Should i Use Try, Catch Or Check if it is NULL ?
        // Exception Catch the Error But Print Null , Why ?
        // try {
        // // Why it Prints NULL ?
        // System.out.println(this.allData.get(key));
        // } catch (NullPointerException e) {
        // System.err.println("Empty");
        // }
    }

    public void insertList(ArrayList<String> listOfStrings) {
        // Append a List to the Corresponding list
        listOfStrings.forEach((element) -> {
            this.insertWord(element);
        });
    }

} // End of Dictionary Class

package com.sparrow;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileWriter;

public class Tag {

    private String name;
    BufferedReader br;
    LinkedList<String> stringList;
    
    /**
     * Creates the objefct
     * @param n string representation of desired tag
     */
    public Tag(String n) {
        name = "<! -- " + n + " -->";
        stringList.add(name);
    }

    /**
     * Adds tags by appending them to the beginning of the markdown file
     * @param je Target journal entry
     * @return true if success, false if not
     */
    public boolean addTag(JournalEntry je) {
        String filepath = "input/" + je.getTitle() + ".md";
        try {
            // copies contents to stringList
            br = new BufferedReader(new FileReader(filepath));
            String currentLine = br.readLine();
            stringList.add(currentLine);
            while (currentLine != null) {
                currentLine = br.readLine();
                stringList.add(currentLine);
            }
            // clears text file
            FileWriter deletus = new FileWriter(filepath, false);
            deletus.close(); 
            // writes contents back in with tag
            FileWriter fw = new FileWriter(filepath);
            for (String s:stringList) {
                fw.write(s);
            }
            br.close();
            fw.close();
            wipe(true);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Removes tags by truncating the markdown file with the tag
     * @param tag the string representation of the tag
     * @param je Target journal entry
     * @return true if the tag exists in the file, false if not
     */
    public boolean removeTag (JournalEntry je, String tag) {
        String filepath = "input/" + je.getTitle() + ".md";
        try {
            // empties stringList
            String temp = stringList.getFirst();
            stringList.removeFirst();
            // copies contents to stringList
            br = new BufferedReader(new FileReader(filepath));
            String currentLine = br.readLine();
            stringList.add(currentLine);
            while (currentLine != null) {
                currentLine = br.readLine();
                stringList.add(currentLine);
            }
            
            // determines if tag exists
            int spare = 0;
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.get(i).equals("<! -- " + tag + " -->")) {
                    spare = i;
                }
            }
            if (spare == 0) {
                wipe(false);
                stringList.add(temp);
                return false;
            }
            stringList.remove(spare);

            // clears text file
            FileWriter deletus = new FileWriter(filepath, false);
            deletus.close(); 
            // writes contents back in without tag
            FileWriter fw = new FileWriter(filepath);
            for (String s:stringList) {
                fw.write(s);
            }
            br.close();
            fw.close();
            wipe(false);
            stringList.add(temp);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Wipes the Linkedlist used while leaving the tag
     * @param leave true leaves the first element untouched
     *              false wipes the list completely
     */
    private void wipe(boolean leave) {
        String temp = stringList.getFirst();
        stringList = new LinkedList<String>();
        if (leave) {
            stringList.add(temp);
        }
    }

    /**
     * Modifies a pre-existing tag within a journal entry
     * @param je
     * @return
     */
    public boolean modifyTag(JournalEntry je, String tag) {
        String filepath = "input/" + je.getTitle() + ".md";
        try {
            // empties stringList
            String temp = stringList.getFirst();
            stringList.removeFirst();
            // copies contents to stringList
            br = new BufferedReader(new FileReader(filepath));
            String currentLine = br.readLine();
            stringList.add(currentLine);
            while (currentLine != null) {
                currentLine = br.readLine();
                stringList.add(currentLine);
            }
            
            // determines if tag exists
            int spare = 0;
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.get(i).equals("<! -- " + tag + " -->")) {
                    spare = i;
                }
            }
            if (spare == 0) {
                wipe(false);
                stringList.add(temp);
                return false;
            }
            String placeHolder = stringList.get(spare);
            placeHolder = placeHolder.substring(placeHolder.indexOf("--") + 3, placeHolder.indexOf("-->") - 1);
            stringList.set(spare, placeHolder);

            // clears text file
            FileWriter deletus = new FileWriter(filepath, false);
            deletus.close(); 
            // writes contents back in with modified tag
            FileWriter fw = new FileWriter(filepath);
            for (String s:stringList) {
                fw.write(s);
            }
            br.close();
            fw.close();
            wipe(false);
            stringList.add(temp);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
 
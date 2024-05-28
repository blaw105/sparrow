package com.sparrow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// declare all the fields and do some calculations to  assign them values.

public class SettingManager
{
    private String mode;
    private String order;
    private String direction;
    private ArrayList<LocalDate> dset=new ArrayList<LocalDate>();
    private ArrayList<JournalEntry> jset= EntryCollection.getEntries();
    private ArrayList<String> tset= new ArrayList<String>();
    public SettingManager(Path path){
        for(JournalEntry i:jset){
            dset.add(i.getEntryDate());
            tset.add(i.getTitle());
        }
        direction = "ascending";
        try {
            mode = (new String(Files.readAllBytes(path), StandardCharsets.UTF_8)).strip();
        } catch (IOException e) {
            mode = "light";
        }
    }
    public void switchMode(){
        if (mode.equals("light")) {
            mode = "dark";
        } else {
            mode = "light";
        }
    }
    public void switchOrder(){
        if(order.equals("date")){
            DateOrder();
        }
        else if(order.equals("title")){
            TitleOrder();
        }
    }
    public void DateOrder(){
        if(direction=="ascending")
        Collections.sort(dset);
        else if(direction=="descending"){
            Collections.sort(dset,Comparator.reverseOrder());
        }
        else{
            System.out.println("The order doesn't exist.");
        }
    }
    public void TitleOrder(){
        if(direction=="ascending")
            Collections.sort(tset);
        else if(direction=="descending"){
            Collections.sort(dset,Comparator.reverseOrder());
        }
        else{
            System.out.println("The order doesn't exist.");
        }
    }
    public ArrayList<LocalDate> getDateSet(){
        return dset;
    }
    public ArrayList<String> getTitleSet(){
        return tset;
    }
    public void changeDirection(String  a){
        direction=a;
    }
    public void changeMode(String  a){
        mode=a;
    }
    public void changeOrder(String  a){
        order=a;
    }
    public String getMode(){
        return mode;
    }
    public String getOrder(){
        return order;
    }
    public String getDirection(){
        return direction;
    }

}

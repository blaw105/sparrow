import java.util.*;

// declare all the fields and do some calculations to  assign them values.

public class SettingManager
{
    private String mode;
    private String order;
    private String direction;
    private ArrayList<Date> dset=new ArrayList<Date>();
    private ArrayList<JournalEntry> jset= EntryCollection.getEntries();
    private ArrayList<String> tset= new ArrayList<String>();
    for(JournalEntry i:jset){
        dset.add(i.getEntryDate());
        tset.add(i.getTitle());
    }
    public SettingManager(String mode1, String order1, String direction1 ){
        mode=mode1;
        order=order1;
        direction=direction1;
    }
    public void switchMode(){
        Theme theme1= new Theme();
        if(mode.equals("dark")){
            theme1.modifyBG("white");
            theme1.modifyTextColor("black");
        }
        else if(mode.equals("light")){
            theme1.mpdifyBG("black");
            theme1.modifyTextColor("white");
        }
        else{
            System.out.println("The mode doesn't exist.");
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
    public ArrayList<Date> getDateSet(){
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



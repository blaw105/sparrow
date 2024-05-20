import java.util.Scanner;

// declare all the fields and do some calculations to  assign them values.

public class SettingManager
{
    private String mode;
    private String order;
    private ArrayList<Date> dset=new ArrayList<Date>();
    private ArrayList<JournalEntry> jset= EntryCollection.getEntries();
    for(JournalEntry i:jset){
        dset.add(i.getEntryDate());
    }
    public SettingManager(String mode1, String order1){
        mode=mode1;
        order=order1;
    }
    public void switchMode(){
        Theme theme1= new Theme();
        if(order.equals("dark")){
            theme1.modifyBG("white");
            theme1.modifyTextColor("black");
        }
        else if(order.equals("light")){
            theme1.mpdifyBG("black");
            theme1.modifyTextColor("white");
        }
        else{
            System.out.println("The mode doesn't exist.");
        }
    }
    public void switchOrder(){
        if(mode.equals("date")){
            DateOrder();
        }
        else if(mode.equals("title")){
            TitleOrder();
        }
    }
    public void DateOrder(){
        Collections.sort(dSet);
    }
    public void TitleOrder(){
        Collections.sort
    }
}
    // public static void main( String[] args )
    // {

    // }


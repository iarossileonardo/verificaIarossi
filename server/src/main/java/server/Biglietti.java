package server;

import java.util.ArrayList;

public class Biglietti {
    ArrayList<String> gold = new ArrayList<String>();
    ArrayList<String> pit = new ArrayList<String>();
    ArrayList<String> parterre = new ArrayList<String>();
    public Biglietti() {
        for (int i = 0; i < 25; i++) {
            gold.add("" + i);
            pit.add("" + i);
            parterre.add("" + i);
        }
    }
    public ArrayList<String> getGold() {
        return gold;
    }
    public ArrayList<String> getPit() {
        return pit;
    }
    public ArrayList<String> getParterre() {
        return parterre;
    }


    
    
}

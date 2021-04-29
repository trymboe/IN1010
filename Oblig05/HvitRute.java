import java.util.*;
class HvitRute extends Rute{
    public HvitRute(int kolonne, int rad){
        super(kolonne, rad);
    }

    public  char tilTegn(){
        return '.';
    }

    //Om ruten er hvit skal den legge den til i strenge, samt kalle på alle naboruter
    public void gaa(Rute komFra, String sti, Lenkeliste<String> ut){
        sti += "(" + kolonne + ", " + rad + ") --> ";
        for (Rute r : naboer){
            //hvis naboruten finnes og ikke er ruten den kom fra kjøres gaa() igjen
            if(r != null &&  r != komFra){
                r.gaa(this, sti, ut);
            }
        }
        sti = "";
    }
}

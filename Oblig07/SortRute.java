import java.util.*;
class SortRute extends Rute{
    public SortRute(int kolonne, int rad){
        super(kolonne, rad);
    }

    public char tilTegn(){
        return '#';
    }

    //En sort rute skal ikke gjøre noe i gaa()
    public void gaa(Rute komFra, String sti, Lenkeliste<String> ut){
    }
}

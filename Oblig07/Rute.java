import java.util.*;
import java.io.*;

abstract class Rute{
    public int rad;
    public int kolonne;
    public Labyrint labyrint;
    abstract char tilTegn();
    abstract void gaa(Rute komFra, String sti, Lenkeliste<String> ut);
    //Dette arrayet brukes til å lagre alle nabeoen, n s oe v
    public Rute[] naboer = new Rute[4];
    public String sti = "";
    public JavaFX.Knapp knapp;


    public Rute(int kolonne, int rad){
        this.kolonne = kolonne;
        this.rad = rad;
    }

    //klasen tar imot alle naboene pluss en referanse om hvilken labyrint ruten tilhører
    public void giInfo(Rute nord, Rute sor, Rute ost, Rute vest, Labyrint labyrint){
        naboer[0] = nord;
        naboer[1] = sor;
        naboer[2] = ost;
        naboer[3] = vest;

        this.labyrint = labyrint;
    }

    //finnUtvei clearer sti-strengen, fjerner alle tidligere strenger fra lenkelisten og kaller gaa()
    //Den tar også med en lenkeliste som den sender videre
    public void finnUtvei(Lenkeliste<String> ut){
        sti = " ";
        while(ut.stoerrelse != 0){
            ut.fjern();
        }
        //gaa tar this, sti-strengen og lenkelisten med sti-strengene som parameter
        gaa(this, sti, ut);
    }

    public void giKnapp(JavaFX.Knapp knapp){
        this.knapp = knapp;
    }

}

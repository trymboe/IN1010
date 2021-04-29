import java.util.*;
import java.io.*;

abstract class Rute{
    public int rad;
    public int kolonne;
    public Labyrint labyrint;
    abstract char tilTegn();
    abstract void gaa(Rute komFra, String sti);
    //Dette arrayet brukes til å lagre alle nabeoen, n s oe v
    public Rute[] naboer = new Rute[4];
    public String sti = "";

    //metoden returnerer gyldige naboer
    public int hentGyldige(Rute komFra){
        int gyldige = 0;
        for (Rute r : naboer){
            if(r != null &&  r != komFra && r instanceof HvitRute){
                gyldige++;
            }
        }
        return gyldige;
    }

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
    public void finnUtvei(){
        sti = " ";
        while(labyrint.monitor.ut.stoerrelse != 0){
            labyrint.monitor.ut.fjern();
        }
        //gaa tar this og sti-strengen som parameter
        gaa(this, sti);
    }


}

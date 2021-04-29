import java.util.*;

class HvitRute extends Rute{
    public HvitRute(int kolonne, int rad){
        super(kolonne, rad);
    }

    public char tilTegn(){
        return '.';
    }

    //Om ruten er hvit skal den legge den til i strenge, samt kalle på alle naboruter

    public void gaa(Rute komFra, String sti){
        sti += "(" + kolonne + ", " + rad + ") --> ";
        int teller = 0;
        for (Rute r : naboer){
            if(r != null &&  r != komFra && r instanceof HvitRute){
                teller++;
                //her sjekkes det om det finnes flere enn 1 gyldig nabo. Finnes det lages det ny tråd før
                //hovedtråden fortsetter.

                /*Som svar på oppgaven: Hadde det rekusive kallet fortsatt før tråden ble laget
                ville hovedtråden kjørt videre helt til den sluttet, kanskje ville den funnet en løsning
                og da hadde programmet vært ferdig før disse trådene ble laget*/

                if(teller < hentGyldige(komFra)){
                    Thread t = new Thread(new Traad(r, this, sti));
                    t.start();
                }
                //er det bare én tråd igjen kalles gaa() rekusivt.
                else{
                    r.gaa(this, sti);
                }
            }
        }
        sti = "";
    }

}

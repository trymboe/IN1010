import java.util.*;
class Aapning extends HvitRute{
    public Aapning(int kolonne, int rad){
        super(kolonne, rad);
    }

    //Kommer man til en åpning stopper rekusjonen, ruten legges til i strenge, og strengen legges til i lista
    public void gaa(Rute komFra, String sti, Lenkeliste<String> ut){
        sti += "(" + String.valueOf(kolonne) + ", " + String.valueOf(rad) + ")\n";
        ut.leggTil(sti);
    }
}

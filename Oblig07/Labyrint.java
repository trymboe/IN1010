import java.util.*;
import java.io.*;

class Labyrint{
    public Rute[][] labArray;
    public int rad;
    public int kolonne;
    public Lenkeliste<String> ut = new Lenkeliste<String>();


    //Metoden kjører på finnUtvei i den gitte cellen og returnerer lenkelisten med utveier
    public Lenkeliste<String> finnUtveiFra(int kol, int rad){
        //System.out.print(toString());
        labArray[kol][rad].finnUtvei(ut);
        return ut;
    }

    private Labyrint(Rute[][] array, int kolonne, int rad){
            this.rad = rad;
            this.kolonne = kolonne;
            labArray = array;
            //giInfo() kjøres når labyrinten lages
            giInfo();
    }

    public static Labyrint lesFraFil(File fil) throws FileNotFoundException{
        Labyrint navn;

        Scanner les = new Scanner(fil);
        int mRad = les.nextInt();
        int mKolonne = les.nextInt();
        //mArray er navnet på labyrintarrayet når det holder på å lages
        Rute[][] mArray = new Rute[mKolonne][mRad];
        les.nextLine();

        //det loopes gjennom hver rad og kolonne
        for(int rad = 0; rad < mRad; rad++){
            String s = les.nextLine();
            for(int kolonne = 0; kolonne < mKolonne; kolonne++){
                //Det sjekkes hvilke tegn arrayet er bygget av, # gir svart rute, . gir hvit
                if(Character.toString(s.charAt(kolonne)).contains("#")){
                    mArray[kolonne][rad] = new SortRute(kolonne, rad);
                }
                if(Character.toString(s.charAt(kolonne)).contains(".")){
                    //hvis det er på kanten blir ruten en åpning
                    if(rad == 0 || rad == mRad-1 || kolonne == 0 || kolonne == mKolonne-1){
                        mArray[kolonne][rad] = new Aapning(kolonne, rad);
                    }
                    else{
                        mArray[kolonne][rad] = new HvitRute(kolonne, rad);
                    }
                }
            }
        }
        navn = new Labyrint(mArray, mKolonne, mRad);
        return navn;

    }

    //metoden kjøres rett etter labyrinten er laget og gir rutene naboer og labyrintreferanse
    public void giInfo(){
        Rute nord;
        Rute sor;
        Rute ost;
        Rute vest;

        //naboer blir delt ut
        for(int r = 0; r < rad; r++){
            for(int k = 0; k < kolonne; k++){
                if(!(k == 0)){
                    vest = labArray[k-1][r];
                }
                else{
                    vest = null;
                }
                if(!(r == rad-1)){
                    sor = labArray[k][r+1];
                }
                else{
                    sor = null;
                }
                if(!(r == 0)){
                    nord = labArray[k][r-1];
                }
                else{
                    nord = null;
                }
                if(!(k == kolonne-1)){
                    ost = labArray[k+1][r];
                }
                else{
                    ost = null;
                }
                labArray[k][r].giInfo(nord, sor, ost, vest, this);
                }
            }
        }

    public String toString(){
        String tekst = "";
        for (int r = 0; r < rad; r++){
            for (int k = 0; k < kolonne; k++){
                tekst += labArray[k][r].tilTegn();
            }
            tekst += "\n";
        }
        return tekst;
    }
}

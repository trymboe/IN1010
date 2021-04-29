import java.util.*;
import javafx.application.Application;

class Spill{
    private static String status;
    private static String spoersmaal;
    private static String[] alternativer;
    private static int maksSpillere = 4;
    private static int maksRunder = 20;
    private static Boolean robot = false;
    private static Terreng terreng;
    private static VeiValgSpiller[] spillere;
    private static int antallRunder;
    private static int spillernummer = 1;
    private static String[] spillernavn;
    public static int[] formue;
    private static int antallSpillere;

    public static void main(String[] args){
        Terreng terreng = new Terreng();

        status = "velkommen til eksamenspillet!\n";
        terreng.giStatus(status);
        //I denne versjonen blir brukeren spurt om hvor mange spillere som skal delta
        //Spillet har vaert optimert for flerspill fra starten, saa dette er eneste endring
        spoersmaal = "Hvor mange spillere?";
        alternativer = new String[maksSpillere];
        for(int i = 1; i<maksSpillere+1; i++){
            alternativer[i-1] = (i) + ") " + (i);
        }
        antallSpillere = terreng.beOmKommando(spoersmaal, alternativer);


        spoersmaal = "Hvor mange roboter?";
        alternativer = new String[antallSpillere+1];
        alternativer[0] = "0) 0";
        for(int i = 1; i<antallSpillere+1; i++){
            alternativer[i] = (i) + ") " + (i);
        }
        int antallRoboter = terreng.beOmKommando(spoersmaal, alternativer);



        alternativer = new String[maksRunder/5];
        spoersmaal = "Hvor mange runder?";
        for(int i = 5; i<=20; i+=5){
            alternativer[(i/5)-1] = i/5 + ") " + i;
        }
        antallRunder = terreng.beOmKommando(spoersmaal, alternativer)*5;

        spillere = new VeiValgSpiller[antallSpillere];

        for(int i = 0; i < antallSpillere; i++){
            if(i < antallRoboter){
                robot = true;
            }
            else{
                robot = false;
            }


            if(!vv){
                Sted start = terreng.hentStart();
                Spiller spiller = new Spiller(start, terreng, antallRunder, robot, antallSpillere);
            }
            else{
                VeiValgSted vvstart = terreng.hentStartvv();
                VeiValgSpiller spiller = new VeiValgSpiller(vvstart, terreng, antallRunder, robot, antallSpillere);
            }
            spillere[i] = spiller;
        }

        spillRundene();
        Thread t = new Thread(new Traad());
        t.start();
        Application.launch(GUI.class, args);



    }

    public static void spillRundene(){
        formue = new int[antallSpillere];
        for(int j = 0; j < antallRunder; j++){
            for(int i = 0; i < spillere.length; i++){
                formue[i] = spillere[i].nyttTrekk();
            }
        }
    }

}

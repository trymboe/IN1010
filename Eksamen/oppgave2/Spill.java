import java.util.*;

class Spill{
    private static String status;
    private static String spoersmaal;
    private static String[] alternativer;
    private static int maksSpillere = 4;
    private static int maksRunder = 20;
    private static Boolean robot = false;
    private static Terreng terreng;
    private static Spiller[] spillere;
    private static int antallRunder;
    private static int spillernummer = 1;
    private static String[] spillernavn;
    public static int[] formue;
    private static int antallSpillere = 1;

    public static void main(String[] args){
        Terreng terreng = new Terreng();

        status = "velkommen til eksamenspillet!\n";
        terreng.giStatus(status);

        //Man velger om man vil spille med robot
        spoersmaal = "Hvor mange roboter?";
        alternativer = new String[antallSpillere+1];
        alternativer[0] = "0) 0";
        for(int i = 1; i<antallSpillere+1; i++){
            alternativer[i] = (i) + ") " + (i);
        }
        int antallRoboter = terreng.beOmKommando(spoersmaal, alternativer);


        //man velger hvor mange runder. Hvert steg er med en faktor på 5
        alternativer = new String[maksRunder/5];
        spoersmaal = "Hvor mange runder?";
        for(int i = 5; i<=20; i+=5){
            alternativer[(i/5)-1] = i/5 + ") " + i;
        }
        antallRunder = terreng.beOmKommando(spoersmaal, alternativer)*5;

        //et spillerarray lages, spillere lages og legges i arrayet
        spillere = new Spiller[antallSpillere];

        for(int i = 0; i < antallSpillere; i++){
            if(i < antallRoboter){
                robot = true;
            }
            else{
                robot = false;
            }
            Sted start = terreng.hentStart();
            Spiller spiller = new Spiller(start, terreng, antallRunder, robot, antallSpillere);
            spillere[i] = spiller;
        }

        spillRundene();
    }
    //spillet kjører like mange ganger som brukeren valgte
    public static void spillRundene(){
        formue = new int[antallSpillere];
        for(int j = 0; j < antallRunder; j++){
            for(int i = 0; i < spillere.length; i++){
                //på hvert trekk oppdateres formuen
                formue[i] = spillere[i].nyttTrekk();
            }
        }

        System.out.println();
        //til slutt skrives formuen ut i terminalen
        for(int i = 0; i < antallSpillere; i++){
            System.out.println("formue: " + formue[i]);
        }

    }

}

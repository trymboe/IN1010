import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;

class Terreng implements Brukergrensesnitt{
    //Arraylist er valgt pga. mest mulig brukervenlighet for programereren. Dermed blir programmet mer fleksibelt
    public static ArrayList<Gjenstand> gjenstandsliste = new ArrayList<Gjenstand>();
    public static ArrayList<Sted> stedsliste = new ArrayList<Sted>();
    private Robot robot = new Robot();

    Terreng(){
        lagGjenstander();
        lagSteder();
    }

    public void lagGjenstander(){
        try{//gjenstanderfilen blir lest gjennom og gjenstander lages og legges i arraylisten
            File minFil = new File("gjenstander.txt");
            Scanner leser = new Scanner(minFil);
            while(leser.hasNextLine()){

                String[] a = leser.nextLine().trim().split(" ");
                Gjenstand g = new Gjenstand(a[0], Integer.parseInt(a[1]));
                gjenstandsliste.add(g);
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public void lagSteder(){
        try{//stederfilen blir lest gjennom, steder blir laget og lagt til arraylisten
            File minFil = new File("steder.txt");
            Scanner leser = new Scanner(minFil);
            while(leser.hasNextLine()){
                String linje = leser.nextLine();
                Sted s = new Sted(linje);
                stedsliste.add(s);
            }//neste blir satt til alle stedene likt bortsett fra det siste, som faar startstedet som sitt neste
            for(int i = 0; i<stedsliste.size()-1; i++){
                stedsliste.get(i).settNeste(stedsliste.get(i+1));
            }
            stedsliste.get(stedsliste.size()-1).settNeste(stedsliste.get(0));

        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }


    //Metodene fra Brukergrensesnitt skrives her.
    public void giStatus(String status){
        System.out.print("\n" +status);
    }

    public int beOmKommando(String spoersmaal, String[] alternativer){
        System.out.print(spoersmaal + "\n");
        for(int i = 0; i < alternativer.length; i++){
            System.out.println(alternativer[i]);
        }
        Scanner ip = new Scanner(System.in);
        Terminal terminal = new Terminal(ip);
        int svar = terminal.leverSvar();
        System.out.println();
        return svar;
    }
    //hvis robot==true brukes robotobjektet, ellers kalles beOmKommando() som bruker et terminalobjekt
    public int beOmKommando(String spoersmaal, String[] alternativer, Boolean robotBoolean){
        if(robotBoolean){
            System.out.print(spoersmaal + "\n");
            for(int i = 0; i < alternativer.length; i++){
                System.out.println(alternativer[i]);
            }
            int svar = robot.leverSvar(alternativer.length);
            System.out.println();
            return svar;
        }
        else{
            return beOmKommando(spoersmaal, alternativer);
        }
    }


    public Sted hentStart(){
        return stedsliste.get(0);
    }
}

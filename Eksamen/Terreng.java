import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;

class Terreng implements Brukergrensesnitt{
    public static ArrayList<Gjenstand> gjenstandsliste = new ArrayList<Gjenstand>();
    public static ArrayList<VeiValgSted> stedsliste = new ArrayList<VeiValgSted>();
    private Robot robot = new Robot();

    Terreng(){
        lagGjenstander();
        lagSteder();
    }

    public void lagGjenstander(){
        try{
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
        try{
            File minFil = new File("steder.txt");
            Scanner leser = new Scanner(minFil);
            while(leser.hasNextLine()){
                String linje = leser.nextLine();
                VeiValgSted s = new VeiValgSted(linje);
                stedsliste.add(s);
            }
            for(int i = 0; i<stedsliste.size(); i++){
                stedsliste.get(i).giVeier();
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

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
    public VeiValgSted hentStartvv(){
        return stedsliste.get(0);
    }
}

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.ArrayList;

class VeiValgTerreng extends Terreng{

    VeiValgTerreng(){
        lagGjenstander();
        lagSteder();
    }

    //i denne overrida metoden blir VeiValgSted-objekter laget og lagt i en veiValgStedsliste
    @Override
    public void lagSteder(){
        try{
            File minFil = new File("steder.txt");
            Scanner leser = new Scanner(minFil);
            while(leser.hasNextLine()){
                String linje = leser.nextLine();
                VeiValgSted s = new VeiValgSted(linje);
                veiValgStedsliste.add(s);
            }
            for(int i = 0; i<veiValgStedsliste.size(); i++){
                veiValgStedsliste.get(i).giVeier();
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }


    @Override
    public VeiValgSted hentStart(){
        return veiValgStedsliste.get(0);
    }
}

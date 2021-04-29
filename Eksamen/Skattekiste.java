import java.util.Random;
import java.util.ArrayList;

class Skattekiste{

    public int antallGjenstander = 3;
    private double slingringsmon;
    public ArrayList<Gjenstand> innhold = new ArrayList<Gjenstand>();

    public Skattekiste(Boolean ryggsekk){
        if(!ryggsekk){
            for(int i = 0; i < antallGjenstander; i++){
                double data = Math.random()*Terreng.gjenstandsliste.size();
                int valg = (int)Math.floor(data);
                innhold.add(Terreng.gjenstandsliste.get(valg));
            }
        }
    }

    public String visGjenstander(){
        String streng = "";
        for(int i = 0; i < innhold.size(); i++){
            streng += innhold.get(i) + "\n";
        }
        return streng;
    }

    public Gjenstand taUt(){
        double data = Math.random()*antallGjenstander;
        int valg = (int)Math.floor(data);
        return innhold.get(valg);
    }

    public void settInn(Gjenstand vare){
        innhold.add(vare);
    }

    public int selg(Gjenstand vare){
        slingringsmon = Math.random()*0.5+0.75;
        double data = Math.round(slingringsmon*vare.pris);
        int pris = (int)Math.round(data);
        return pris;
    }

}

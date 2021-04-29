import java.util.Random;

class VeiValgSted extends Sted{
    protected Sted hoeyre;
    protected Sted venstre;
    protected Sted frem;
    protected double data;
    protected int valg;

    VeiValgSted(String beskrivelse){
        super(beskrivelse);
    }

    public void giVeier(){
        data = Math.random()*Terreng.stedsliste.size();
        valg = (int)Math.floor(data);
        hoeyre = Terreng.stedsliste.get(valg);
        data = Math.random()*Terreng.stedsliste.size();
        valg = (int)Math.floor(data);
        venstre = Terreng.stedsliste.get(valg);
        data = Math.random()*Terreng.stedsliste.size();
        valg = (int)Math.floor(data);
        frem = Terreng.stedsliste.get(valg);
    }

    public Sted hentHoeyre(){
        return hoeyre;
    }
    public Sted hentVenstre(){
        return venstre;
    }
    public Sted hentFrem(){
        return frem;
    }
}

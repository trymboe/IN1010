import java.util.Random;

class VeiValgSted extends Sted{
    protected VeiValgSted hoeyre;
    protected VeiValgSted venstre;
    protected VeiValgSted frem;
    protected double data;
    protected int valg;

    VeiValgSted(String beskrivelse){
        super(beskrivelse);
    }
    //I denne subklassen blir 3 pekere gitt til hvert sted.
    public void giVeier(){
        data = Math.random()*Terreng.stedsliste.size();
        valg = (int)Math.floor(data);
        hoeyre = Terreng.veiValgStedsliste.get(valg);
        data = Math.random()*Terreng.stedsliste.size();
        valg = (int)Math.floor(data);
        venstre = Terreng.veiValgStedsliste.get(valg);
        data = Math.random()*Terreng.stedsliste.size();
        valg = (int)Math.floor(data);
        frem = Terreng.veiValgStedsliste.get(valg);
    }

    public VeiValgSted hentHoeyre(){
        return hoeyre;
    }
    public VeiValgSted hentVenstre(){
        return venstre;
    }
    public VeiValgSted hentFrem(){
        return frem;
    }
}

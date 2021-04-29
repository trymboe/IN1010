class Sted{
    public Skattekiste kiste;
    public String beskrivelse;
    public Sted neste;
    protected VeiValgSted hoeyre;
    protected VeiValgSted venstre;
    protected VeiValgSted frem;

    Sted(String beskrivelse){
        this.beskrivelse = beskrivelse;
        lagKiste();
    }

    public void lagKiste(){
        kiste = new Skattekiste(false);
    }

    public Skattekiste hentKiste(){
        return kiste;
    }

    public String hentBeskrivelse(){
        return beskrivelse;
    }

    public void settNeste(Sted sted){
        neste = sted;
    }

    public Sted hentNeste(){
        return neste;
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

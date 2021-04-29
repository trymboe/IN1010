class Sted{
    public Skattekiste kiste;
    public String beskrivelse;
    public Sted neste;

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
}

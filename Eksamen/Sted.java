class Sted{
    public Skattekiste kiste;
    public String beskrivelse;

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

}

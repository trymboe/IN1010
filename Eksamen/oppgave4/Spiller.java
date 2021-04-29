class Spiller{
    protected static Sted sted;
    protected Terreng terreng;
    protected Skattekiste ryggsekk = new Skattekiste(true);
    protected int formue;
    protected String status;
    protected String spoersmaal;
    protected String[] alternativer;
    protected int antallRunder;
    protected static int antallRunderSpilt = 1;
    protected boolean robot;
    protected static int spillernummer = 1;
    protected int antallSpillere;

    Spiller(Sted startsted, Terreng terreng, int antallRunder, Boolean robot, int antallSpillere){
        this.sted = startsted;
        this.terreng = terreng;
        this.antallRunder = antallRunder;
        this.robot = robot;
        this.antallSpillere = antallSpillere;
        
    }


    public void ikkeTaMedTomRyggsekk(){
        status = "Du har ingenting aa selge, du maa ta noe fra skattekista\n";
        status += sted.hentKiste().visGjenstander();
        terreng.giStatus(status);
        spoersmaal = "\nvil du plukke opp en tilfeldig gjenstand?";
        alternativer = new String[1];
        alternativer[0] = "1) ja";
        if(terreng.beOmKommando(spoersmaal, alternativer, robot) == 1){
            ta();
        }
    }

    public void selge(){
        status = "Du plukket ikke opp noe. ";
        spoersmaal = "Hva vil du selge fra ryggsekken din?";
        alternativer = new String[ryggsekk.innhold.size()];
        for(int i = 0; i<ryggsekk.innhold.size(); i++){
            alternativer[i] = i+1 + ") " + ryggsekk.innhold.get(i).toString();
        }
        terreng.giStatus(status);
        int salgsvarenummer = terreng.beOmKommando(spoersmaal, alternativer, robot);
        //velger aa selge
        Gjenstand salgsvare = ryggsekk.innhold.get(salgsvarenummer-1);
        int pris = ryggsekk.selg(salgsvare);
        ryggsekk.innhold.remove(salgsvarenummer-1);
        formue += pris;
        status = "Du solgte " + salgsvare + " for " + pris + ". Du har nå " + formue + " kroner totalt";
        terreng.giStatus(status);
    }

    public void ta(){
        if(ryggsekk.innhold.size() < ryggsekk.antallGjenstander){
            Gjenstand valgt = sted.hentKiste().taUt();
            ryggsekk.settInn(valgt);
            int ledigPlass = ryggsekk.antallGjenstander-ryggsekk.innhold.size();
            status = "Du fikk " + valgt + " og har nå " + ledigPlass + " plasser igjen i ryggsekken din";
            terreng.giStatus(status);
        }
        else{
            status = "Ryggsekken din er full, selg heller noe";
            terreng.giStatus(status);
            selge();
        }
    }

    public void moeteDoera(){
        String ord = "u";
        if (antallSpillere>1){
            ord = "ere";
        }
        status = "\nD" + ord +" ser nå på en doer(er)";
        spoersmaal = "Vil d" + ord + " gaa videre";
        alternativer = new String[2];
        alternativer[0] = "1) ja";
        alternativer[1] = "2) nei";
        terreng.giStatus(status);
        int valg = terreng.beOmKommando(spoersmaal, alternativer, robot);
        while(valg == 2){
            status = "D" + ord +" maa nesten gaa videre, spillet er ikke ferdig enda";
            valg = terreng.beOmKommando(spoersmaal, alternativer, robot);
        }
        status = "Du gaar gjennom doeren";
        terreng.giStatus(status);
        sted = sted.hentNeste();
        antallRunderSpilt++;
        spillernummer = 1;
    }

    public int nyttTrekk(){
        status = "Runde " + antallRunderSpilt + "/" + antallRunder + ". Spiller: " + spillernummer + "\n" + sted.hentBeskrivelse() + "\nForran deg er det en skattekiste, den inneholder: \n\n";
        status += sted.hentKiste().visGjenstander();
        spoersmaal = "\nvil du plukke opp en tilfeldig gjenstand?";
        alternativer = new String[2];
        alternativer[0] = "1) ja";
        alternativer[1] = "2) nei";
        terreng.giStatus(status);
        //velger aa ikke ta ut
        if(terreng.beOmKommando(spoersmaal, alternativer, robot) == 2){
            //velger aa ikke ta ut og har tom ryggsekk
            if(ryggsekk.innhold.size() == 0){
                ikkeTaMedTomRyggsekk();
            }
            //velger aa ikke ta ut, men kan selge
            else{
                selge();
            }
        }
        //Velger aa ta en gjenstand
        else{
            ta();
        }

        if(spillernummer >= antallSpillere){
                moeteDoera();
        }
        else{
            spillernummer++;
        }
        return formue;

    }
}

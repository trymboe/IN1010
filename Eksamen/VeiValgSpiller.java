class VeiValgSpiller extends Spiller{
    VeiValgSpiller(VeiValgSted startsted, Terreng terreng, int antallRunder, Boolean robot, int antallSpillere){
        super(startsted, terreng, antallRunder, robot, antallSpillere);
    }

    public giSted(sted){
        this.startsted = sted
    }

    @Override
    public void moeteDoera(){
        String ord = "u";
        if (antallSpillere>1){
            ord = "ere";
        }
        status = "\nD" + ord +" ser nå på en doer(er)";
        spoersmaal = "Hvilken rettning vil d" + ord + " gaa videre?";
        alternativer = new String[3];
        alternativer[0] = "1) hoeyre";
        alternativer[1] = "2) venstre";
        alternativer[2] = "3) rett fram";
        terreng.giStatus(status);
        int valg = terreng.beOmKommando(spoersmaal, alternativer, robot);

        if (valg == 1){
            status = "D" + ord + " gaar til hoeyre";
            sted = sted.hentHoeyre();
        }
        if (valg == 2){
            status = "D" + ord + " gaar til venstre";
            sted = sted.hentVenstre();
        }
        if (valg == 3){
            status = "D" + ord + " gaar rett frem";
            sted = sted.hentFrem();
        }
        terreng.giStatus(status);

        antallRunderSpilt++;
        spillernummer = 1;
    }
}

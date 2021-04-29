class HvitResept extends Resept{
  public HvitResept(Legemidler legemiddel, Lege lege, int pasientId, int reit){
    super(legemiddel, lege, pasientId, reit);
  }
  public String farge(){
    return "Hvit";
  }

  protected double prisAaBetale(){
    return legemiddel.hentPris();
  }

  protected String hentType(){
    return "Hvit resept";
  }
}

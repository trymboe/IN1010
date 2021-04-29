class BlaaResept extends Resept{

  public BlaaResept(Legemidler legemiddel, Lege lege, int pasient, int reit){
    super(legemiddel, lege, pasient, reit);
  }

  public double prisAaBetale(){
    return legemiddel.hentPris()*0.25;
  }

  public String farge(){
    return "Blaa";
  }

  public String hentType(){
    return "Blaa resept";
  }
}

class Militærresept extends HvitResept{
  public Militærresept(Legemidler legemiddel, Lege lege, int pasientId, int reit){
    super(legemiddel, lege, pasientId, reit);
  }

  public double prisAaBetale(){
    return 0;
  }

  public String hentType(){
    return "Militærresept";
  }
}

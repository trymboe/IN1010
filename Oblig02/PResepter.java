class PResepter extends HvitResept{

  public PResepter(Legemidler legemiddel, Lege lege, int pasientId){
    super(legemiddel, lege, pasientId, 3);
  }

  
  public double prisAaBetale(){
    if (legemiddel.hentPris() < 108){
      return 0;
    }
    else{
      return legemiddel.hentPris() - 108;
    }
  }

  public String hentType(){
    return "P-resept";
  }
}

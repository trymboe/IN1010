abstract class Resept{
  protected static int idTeller;
  protected int id;
  protected Legemidler legemiddel;
  protected Lege lege;
  protected int pasientId;
  protected int reit;

  protected abstract double prisAaBetale();
  protected abstract String farge();
  //Her leger jeg til en abstrakt metode for å finne ut hvilken type resept
  //objektet er. Det brukes til utskriften i toString()
  protected abstract String hentType();

  public Resept(Legemidler legemiddel, Lege utskrevendeLege, int pasientId, int reit){
    this.legemiddel = legemiddel;
    lege = utskrevendeLege;
    this.pasientId = pasientId;
    this.reit = reit;

    idTeller++;
    id = idTeller;
  }

  public int hentId(){
    return id;
  }

  public Legemidler hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return lege;
  }

  public int hentPasientId(){
    return pasientId;
  }

  public int hentReit(){
    return reit;
  }

  public boolean bruk(){
    if (reit > 0){
      reit--;
      return true;
    }
    else{
      return false;
    }
  }


  public String toString(){

    //Her returneres det ut en oversiktlig print av all informasjon om legemiddel, leger og resepten.
    return "\nLEGEMIDDEL:\n" + legemiddel.toString()
    + "\n\nLEGE:\n"+ lege.toString() +

     "\n\nRESEPT:\nId: " + id + " | Type: " + hentType() + " | Farge: " + farge()  + " | PasientId: " + pasientId + " | Reit: " + reit + " | pris aa betale: " + prisAaBetale();
  }

}

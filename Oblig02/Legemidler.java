abstract class Legemidler{
  protected String navn;
  protected double pris;
  protected double virkestoff;
  protected static int idTeller;
  protected int id;
  protected int styrke;

  //Her leger jeg til en abstrakt metode for å finne ut hvilken type legemiddel
  //objektet er. Det brukes til utskriften i toString()
  protected abstract String hentType();


  public Legemidler(String navn, double pris, double virkestoff){
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    idTeller++;
    id = idTeller;
  }



  public int hentId(){
    return id;
  }

  public String hentNavn(){
    return navn;
  }

  public double hentPris(){
    return pris;
  }

  public double hentVirkestoff(){
    return virkestoff;
  }

  public void settNyPris(double nyPris){
    pris =nyPris;
  }

  public String toString(){
    //Her skrives ut all informasjon om legemidlene. Jeg sjekker hvilken type det er for å
    //vite om vi skal skrive ut styrken.
    if(hentType() == "Vanlig"){
      return "Navn: " + navn + " | Type: " + hentType() + " | Pris: " + pris + "| Menged virkestoff: "+ virkestoff;
    }
    else{
      return "Navn: " + navn + " | Type: " + hentType() + " | Pris: " + pris + " | Menged virkestoff: "+ virkestoff + " | Styrke: " + styrke;
    }
  }

}

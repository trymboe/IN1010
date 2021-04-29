class Motorsykkel{
  private int kilometerstand;
  private String registreringsnummer;
  private int produksjonsnummer;
  private static int teller = 0;


  public Motorsykkel(String regnr){
    this.kilometerstand = 0;
    this.registreringsnummer = regnr;
    this.produksjonsnummer = this.teller;
    this.teller++;
  }

  public int hentKilomterstand(){
    return this.kilometerstand;
  }

  public int hentProduksjonsnummer(){
    return this.produksjonsnummer;
  }

  public void kjoer(int antallKilometer){
    this.kilometerstand += antallKilometer;
  }
}

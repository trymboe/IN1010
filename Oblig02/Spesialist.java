class Spesialist extends Lege implements Godkjenningsfritak{
  protected int KontrollId;

  public Spesialist(String navn, int KontrollId){
    super(navn);
    this.KontrollId = KontrollId;
  }

  public int hentKontrollId(){
    return KontrollId;
  }

  //Her skrives toString-metoden fra lege over
  @Override
  public String toString(){
    return "Type: Spesialist" + " | Navn: " + navn + " | Kontrollid: " + KontrollId;
  }
}

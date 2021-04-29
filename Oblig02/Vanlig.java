class Vanlig extends Legemidler{

  public Vanlig(String navn, double pris, double virkestoff){
    super(navn, pris, virkestoff);
  }

  public String hentType(){
    return "Vanlig";
  }
}

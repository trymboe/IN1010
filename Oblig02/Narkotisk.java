class Narkotisk extends Legemidler{

  public Narkotisk(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentNarkotiskStyrke(){
    return styrke;
  }

  public String hentType(){
    return "Narkotisk";
  }
}

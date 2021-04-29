class Vanedannende extends Legemidler{

  public Vanedannende(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentVanedannendeStyrke(){
    return styrke;
  }

  public String hentType(){
    return "Vanedannende";
  }
}

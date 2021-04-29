class MotorsykkelProgram{
  public static void main (String[] args){
    Motorsykkel s1 = new Motorsykkel("RK12345678");

    int i = 0;
    while (i < 10){
      s1.kjoer(10);
      i++;
    }

    System.out.println(s1.hentKilomterstand());

    Motorsykkel s2 = new Motorsykkel("RK87654321");

    System.out.println(s1.hentProduksjonsnummer());
  }
}

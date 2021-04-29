class Hovedprogram{
  public static void main(String[] args){
    //Her lages tre legemidler
    Legemidler sovemedisin = new Vanedannende("Sovemedisin", 400, 10, 2);
    Legemidler pPiller = new Vanlig("P-piller", 200, 5);
    Legemidler benzod = new Narkotisk("Benzodiazepiner", 650, 14, 4);

    //To leger
    Lege Torgersen = new Lege("Trond-Viggo Torgersen");
    Lege King = new Spesialist("Dr. Martin Luther King jr.", 1);

    //og tre resepter med legemidler og leger med.
    Resept r1 = new Militærresept(sovemedisin, Torgersen, 1, 5);
    Resept r2 = new PResepter(pPiller, King, 2);
    Resept r3 = new BlaaResept(benzod, King, 3, 1);
    Resept r4 = new HvitResept(pPiller, Torgersen, 4, 12);

    
    System.out.println(r1.toString());
    System.out.println("\n\n" + r2.toString());
    System.out.println("\n\n" + r3.toString());
    System.out.println("\n\n" + r4.toString());
  }
}

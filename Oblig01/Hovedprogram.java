import java.io.FileNotFoundException;

class Hovedprogram{
  public static void main (String[] args) throws FileNotFoundException {
    try{
      Dataklynge abel = new Dataklynge("filnavn.txt");

      System.out.println("Noder med minst 32GB: " + abel.noderMedNokMinne(32));
      System.out.println("Noder med minst 64GB: " + abel.noderMedNokMinne(64));
      System.out.println("Noder med minst 128GB: " + abel.noderMedNokMinne(128));

      System.out.println("\nAntall prosessorer: " + abel.antProsessorer());
      System.out.println("Antall racks: " + abel.antRacks());
    }

    catch (FileNotFoundException ex) {
      System.out.println("Du har et problem med filen din: 1");
    }


  }
}

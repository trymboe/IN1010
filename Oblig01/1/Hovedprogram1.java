import java.io.FileNotFoundException;

class Hovedprogram1{
  public static void main (String[] args) {

    Dataklynge1 abel = new Dataklynge1(12);
    for (int i = 0; i<650;  i++){
      Node node = new Node(64, 1);
      abel.settInnNode(node);
    }

    for (int i = 0; i<16;  i++){
      Node node = new Node(1024, 2);
      abel.settInnNode(node);
    }

    System.out.println("Noder med minst 32GB: " + abel.noderMedNokMinne(32));
    System.out.println("Noder med minst 64GB: " + abel.noderMedNokMinne(64));
    System.out.println("Noder med minst 128GB: " + abel.noderMedNokMinne(128));

    System.out.println("\nAntall prosessorer: " + abel.antProsessorer());
    System.out.println("Antall racks: " + abel.antRacks());

  }
}

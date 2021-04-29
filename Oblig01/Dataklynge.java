import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Dataklynge{
  private int noderPerRack;
  //Lager en ArrayList. Dette velger dette fordi det er lettere med dynamikken, og siden
  //det ikke er satt noen begrensning på lengden til RackArray.
  private ArrayList<Rack> RackArray;

  //Denne konstruktøren kjører en FileNotFoundException
  public Dataklynge(String filnavn) throws FileNotFoundException {
    //hvis filen er funnet kjøres denne koden
    try{
      //Filen åpnes som et Scannerobjekt og den første linjen blir lagret som
      //NoderPerRack
      Scanner les = new Scanner(new File("filnavn.txt"));
      noderPerRack = les.nextInt();

      //Et rack blir laget som i det forgje Dataklyngeprogrammet
      Rack rack = new Rack(noderPerRack);
      //Lager en ny ArrayList og legger til rack-objektet
      RackArray = new ArrayList<Rack>();
      RackArray.add(rack);


      //Så lenge der er flere linjer igjen kjører denne koden
      while (les.hasNextInt()){
        //Hvert tall blir lagret på sine respektive variabler
        int antallNoder = les.nextInt();
        int minnePerNode = les.nextInt();
        int prosessorPerNode = les.nextInt();

        //Nodene blir laget og settInnNode-metoden kjøres
        for (int i = 0; i < antallNoder; i++){
          Node node = new Node(minnePerNode, prosessorPerNode);
          settInnNode(node);
        }

      }
    }
    //hvis filen ikke finnes kjøres feilmeldingen
    catch (FileNotFoundException ex){
        System.out.println("Du har et problem med filen din: 2");
    }
  }


  public void settInnNode(Node node){
    //Her sjekkes det siste objektet i arraylisten. Om det er ledig plass settes
    //Noden inn racket, ellers lages det et nytt rack før noden plaseres i det nye racket
    if(RackArray.get(RackArray.size() - 1).getAntNoder() < noderPerRack) {
      RackArray.get(RackArray.size() - 1).settInn(node);
    }
    else{
      Rack rack = new Rack(noderPerRack);
      RackArray.add(rack);
      RackArray.get(RackArray.size()-1).settInn(node);
    }
  }

  //De 3 neste metodene returnerer forskjellige verdier.
  //De 2 neste looper gjennom arrayListen og kjører metoder fra Rack.java
  public int antProsessorer(){
    int antP = 0;
    for (int i = 0; i<RackArray.size(); i++){
      antP += RackArray.get(i).antProsessorer();
    }
    return antP;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int antN = 0;
    for (int i = 0; i<RackArray.size(); i++){
      antN += RackArray.get(i).noderMedNokMinne(paakrevdMinne);
    }
    return antN;
  }

  public int antRacks(){
    return RackArray.size();
  }

}

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Dataklynge1{
  private int noderPerRack;
  //Lager en ArrayList. Dette velger dette fordi det er lettere med dynamikken, og siden
  //det ikke er satt noen begrensning på lengden til RackArray.
  private ArrayList<Rack> RackArray;

  public Dataklynge1(int noderPerRack){
    this.noderPerRack = noderPerRack;
    //Lager et rack-objekt
    Rack rack = new Rack(noderPerRack);
    //Lager en ny ArrayList og legger til rack-objektet
    RackArray = new ArrayList<Rack>();
    RackArray.add(rack);
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

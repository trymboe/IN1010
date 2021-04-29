class Rack{
  Node[] mittArray;

  //I konstruktøren lages det et array til noder
  public Rack(int antallNoder){
    mittArray = new Node[antallNoder];
  }

  //denne metoden setter inn noder i arrayet med noder
  public void settInn(Node node){
    //Det loopes igjennom hele arrayet, legger inn objektet første plass som ikke
    //her verdien "null"
    for (int i = 0; i < mittArray.length; i++) {
      if(mittArray[i] == null){
        mittArray[i] = node;
        //Her må jeg bruke break
        break;
      }
    }
  }

  //Metoden looper gjennom arrayet og sjekker om hver plass ikke har verdi null
  //om plassen ikke har verdi null øker en teller som til slutt returneres
  public int getAntNoder(){
    int teller = 0;
    for (int i = 0; i < mittArray.length; i++) {
      if (mittArray[i] != null){
        teller++;
      }
    }
    return teller;
  }

  //De to neste metodene fungerer som getAntNoder
  public int antProsessorer(){
    int antP = 0;
    for (int i=0; i<mittArray.length; i++){
      if(mittArray[i] != null){
        antP += mittArray[i].antProsessorer();
      }
    }
    return antP;
  }

  public int noderMedNokMinne(int paakrevdMinne){
    int antN = 0;
    for(int i=0; i<mittArray.length; i++){
      if(mittArray[i] != null && mittArray[i].nokMinne(paakrevdMinne)){
        antN++;
      }
    }
    return antN;
  }

}

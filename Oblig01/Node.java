//Denne klassen danner Node-objekter, samt har to metoder som returnerer
//henholdsvis antallProsessorer og om noden har mer minne enn en gitt parameter

class Node{
  private int prosessor;
  private int minne;

  //Her bruker jeg this.minne fordi både instans -og parameter-verdien har samme navn
  public Node(int minne, int antallProsessorer){
    this.minne = minne;
    prosessor = antallProsessorer;
  }

  public int antProsessorer(){
    return prosessor;
  }

  //returnerer bolsk verdi på om Noden har mer minne enn paakrevdMinne
  public boolean nokMinne(int paakrevdMinne){
    return minne >= paakrevdMinne;
  }


}

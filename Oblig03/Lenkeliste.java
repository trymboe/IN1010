class Lenkeliste<T extends Comparable<T>> implements Liste<T>{
    public int teller = 0;
    public Node start, slutt;

  //Lager klasse node med forrige -og neste-peker
  class Node{
    public Node neste, forrige;
    public T innhold;

    public Node(T innhold){
      this.innhold = innhold;
    }
    //compareTo-metode for å sammenligne noder
    public int compareTo(Node other){
        return innhold.compareTo(other.innhold);
    }
  }

  public Lenkeliste(){
    start = new Node(null);
    slutt = new Node(null);
    slutt.forrige = start;
    start.neste = slutt;
  }

  public int stoerrelse(){
    return teller;
  }

  public void leggTil(int pos, T x){
    if(pos > teller || pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{
      Node ny = new Node(x);
      int i = 0;
      Node tellenode = start;
      while(i < pos){
        tellenode = tellenode.neste;
        i++;
      }
      //Setter nye pekere
      ny.neste = tellenode.neste;
      ny.forrige = tellenode;

      ny.forrige.neste = ny;
      ny.neste.forrige = ny;
      teller++;
    }
  }

  public void leggTil(T x){
    Node ny = new Node(x);
    //Setter nye pekere
    ny.forrige = slutt.forrige;
    ny.forrige.neste = ny;
    ny.neste = slutt;
    slutt.forrige = ny;
    teller++;
  }
  public void sett(int pos, T x){
    if(pos >= teller || pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{
      Node tellenode = start;
      for(int i = 0; i < pos; i++){
        tellenode = tellenode.neste;
      }
      tellenode.neste.innhold = x;
    }

  }
  public T hent(int pos){
    Node tellenode = start;
    if(pos >= teller || pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{
      //Finner gjeldene node
      for(int i = 0; i < pos; i++){
        tellenode = tellenode.neste;
      }
    }
    return tellenode.neste.innhold;
  }

  public T fjern(int pos){
        Node p = start;
        Node x;
        if(pos >= teller || pos < 0){
          throw new UgyldigListeIndeks(pos);
        }
        else{
          for(int i=0; i< pos;i++){
              p = p.neste;
          }
          //Setter nye pekere
          x = p.neste;
          p.neste = x.neste;
          p.neste.forrige = p.neste.forrige.forrige;
          teller--;
        }
        return x.innhold;
    }

  public T fjern(){
        Node m = start;
        Node x = m.neste;
        if(teller>0){
          //setter nye pekere
            m.neste = m.neste.neste;
            m.neste.forrige = m.neste.forrige.forrige;
            teller--;
        }
        else{
          throw new UgyldigListeIndeks(-1);
        }
        return x.innhold;
    }


}

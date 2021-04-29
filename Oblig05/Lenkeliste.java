import java.util.*;
import java.io.*;

public class Lenkeliste<T> implements Liste<T> {
  public int stoerrelse;
  public Node start, slutt;

  public class Node {
    public T data;
    public Node neste, forrige;

    public Node(T data){
      this.data = data;
    }
  }

  public Lenkeliste() {
    stoerrelse = 0;
    start = new Node(null);
    slutt = new Node(null);
    start.neste = slutt;
    slutt.forrige = start;
  }

  private class LenkeIterator implements Iterator<T> {
    Node gjeldende;

    public LenkeIterator() {
      gjeldende = start;
    }

    @Override
    //fordi start og slutt er null-noder vil siste element i lenken vaere slutt.forrige
    public boolean hasNext() {
      return gjeldende != slutt.forrige;
    }
    @Override
    public T next() {
      gjeldende = gjeldende.neste;
      return gjeldende.data;
    }

  }

  public Iterator<T> iterator() {
        return new LenkeIterator();
      }

  public int stoerrelse() {
    return stoerrelse;
  }
// Legger til på siste plassen.
  public void leggTil(T x) {
    Node ny = new Node(x);
    ny.forrige = slutt.forrige;
    ny.forrige.neste = ny;
    ny.neste = slutt;
    slutt.forrige = ny;
    stoerrelse ++;
  }

  public void leggTil(int pos, T x){
    if (pos < 0 || pos > stoerrelse){
      throw new UgyldigListeIndeks(pos);
      }
    Node ny = new Node(x);
    Node bak = start;
    for (int i=0; i < pos; i++){
      bak = bak.neste;
    }
    ny.neste = bak.neste;
    ny.neste.forrige = ny;
    ny.forrige = bak;
    ny.forrige.neste = ny;
    stoerrelse ++;
  }

//Overskriver ny data på en plass der det allerede er gammel data.
  public void sett(int pos, T x){
    if (pos < 0 || pos >= stoerrelse){
      throw new UgyldigListeIndeks(1);
      }
    Node ny = new Node(x);
    Node erstatt = start;
    for (int i=0; i <= pos; i++){
      erstatt = erstatt.neste;
    }
    erstatt.data = ny.data;

  }

  public T hent(int pos){
    if (pos < 0 || pos >= stoerrelse){
      throw new UgyldigListeIndeks(pos);
      }
    Node node = start;
    for (int i=0; i <= pos; i++){
      node = node.neste;
    }
    return node.data;
  }

// Fjerner første element i lista. Returnerer objektet som ble fjernet.
  public T fjern(){
    if (stoerrelse == 0){
      throw new UgyldigListeIndeks(1);
      }
    Node fjern = start.neste;
    start.neste = fjern.neste;
    fjern.neste.forrige = start;
    stoerrelse --;
    return fjern.data;
  }

  public T fjern(int pos){
    if (pos < 0 || pos >= stoerrelse){
      throw new UgyldigListeIndeks(pos);
      }
    Node fjern = start;
    for (int i=0; i <= pos; i++){
      fjern = fjern.neste;
    }
    fjern.forrige.neste = fjern.neste;
    fjern.neste.forrige = fjern.forrige;
    stoerrelse --;
    return fjern.data;
  }

// Skriver ut fra første til siste element i lista.
  public void skrivUtFrem(){
    Node n = start.neste;
    while (n.data != null){
      System.out.println(n.data + "\n");
      n = n.neste;
    }
  }

}

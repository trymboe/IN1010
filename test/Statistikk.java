import java.util.Scanner;
import java.io.File;

class Statistikk{
  public static void main (String[] args){

    int maksAlder;
    String eldsteNavn;

    File innfil = new File("alder.txt");
    Scanner lesfil = new Scanner(innfil);
    //while(lesfil.hasNextline()){
    String[] biter = lesfil.nextLine().split(" ");
    String navn = biter[0];
    int alder = Integer.parseInt(biter[1]);
  /*  if (alder > maksAlder){
      maksAlder = alder;
      eldsteNavn = navn;
    //}*/
  }
}

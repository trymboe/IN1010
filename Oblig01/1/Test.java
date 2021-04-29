import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


class Test{
  public static void main(String[] args) throws FileNotFoundException {

    /*String test = "    1salidj\n1390182 2.4";
    Scanner les = new Scanner(test);
    System.out.println(les.next());
    System.out.println(les.nextInt());*/

    try{
      Scanner les = new Scanner(new File("filnavn.txt"));

      int maxAntallNoder = les.nextInt();
      while (les.hasNextInt()){
        int antallNoder = les.nextInt();
        int minnePerNode = les.nextInt();
        int prosessorPerNode = les.nextInt();
        System.out.println(maxAntallNoder + antallNoder + minnePerNode + prosessorPerNode);

      }

    }

    catch (FileNotFoundException ex){
        System.out.println("Du har et problem med filen din");
    }
  }
}

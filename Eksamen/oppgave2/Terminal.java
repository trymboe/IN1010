import java.util.Scanner;

//terminal kalles paa og faar inn en scanner som den prosesserer og returnerer inputet
class Terminal{
    private Scanner sc;
    Terminal(Scanner sc){
        this.sc = sc;
    }

    public int leverSvar(){
        int input = sc.nextInt();
        return input;
    }

    public String leverNavn(){
        String input = sc.nextLine();
        return input;
    }
}

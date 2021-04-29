import java.util.Scanner;

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

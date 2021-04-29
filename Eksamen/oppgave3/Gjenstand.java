class Gjenstand{
    //Les fra gjenstander.txt og gi verdier til instansvariabler
    public int pris;
    public String navn;

    Gjenstand(String navn, int pris){
        this.navn = navn;
        this.pris = pris;
    }

    @Override
    public String toString(){
        return navn + ", " + pris;
    }

}

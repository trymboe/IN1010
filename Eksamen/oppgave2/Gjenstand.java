class Gjenstand{
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

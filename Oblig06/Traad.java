class Traad implements Runnable{
    public Rute denne;
    public Rute forrige;
    public String sti;

    //informasjonen som trengs for å kjøre gaa() lagres i objektet
    public Traad(Rute denne, Rute forrige, String sti){
        this.denne = denne;
        this.forrige = forrige;
        this.sti = sti;
    }

    //gaa() kjøres
    public void run(){
        denne.gaa(forrige, sti);
    }
}

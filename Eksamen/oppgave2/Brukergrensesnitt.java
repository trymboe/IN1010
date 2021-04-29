public interface Brukergrensesnitt{

    public void giStatus(String status);

    public int beOmKommando(String spoersmaal, String[] alternativer);

    //Denne kjøres med robot = true om roboten skal brukes.
    public int beOmKommando(String spoersmaal, String[] alternativer, Boolean robot);
}

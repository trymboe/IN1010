public interface Brukergrensesnitt{

    public void giStatus(String status);

    public int beOmKommando(String spoersmaal, String[] alternativer);

    public int beOmKommando(String spoersmaal, String[] alternativer, Boolean robot);
}

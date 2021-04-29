class Stabel<T extends Comparable<T>> extends Lenkeliste<T>{
    public void leggPaa(T x){
        leggTil(x);
    }

    public T taAv(){
        return fjern(teller-1);
    }
}

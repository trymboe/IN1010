class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{
  //Denne klassen overrider de gitte klassene fra Lenkeliste
    @Override
    public void leggTil(T x){
        Node ny = new Node(x);
        Node tellenode = start;

        if(teller == 0){
            super.leggTil(0, x);
            return;
        }

        for(int i = 0; i < teller; i++){
            tellenode = tellenode.neste;

            if(ny.compareTo(tellenode) <=0){
                super.leggTil(i, x);
                break;
            }
        }

        if(ny.compareTo(tellenode)>0){
            super.leggTil(teller, x);
            return;
        }
    }

    //Fjerner det største objektet som også er det siste
    @Override
    public T fjern(){
        return fjern(teller-1);
    }

    //Kan ikke sette posisjon da listen er sortert etter størrelse
    @Override
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
    }

    //Kan ikke legge til i posisjon da listen er sortert etter størrelse
    @Override
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
    }
}

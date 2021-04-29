import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Monitor{
    //en lås og lenkelisten defineres
    private final Lock lock = new ReentrantLock();
    public Lenkeliste<String> ut = new Lenkeliste<String>();

    public Lenkeliste<String> hentListe() {
        return ut;
    }

    //her låses monitoren slik at det ikke blir kræsj i innleggingen
    public void leggTil(String sti) {
        lock.lock();
        try {
            ut.leggTil(sti);
        }
        finally {
            lock.unlock();
        }
    }
}

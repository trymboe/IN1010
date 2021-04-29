class ThreadsTest{
    public final Condition ferdig = new Condition();

    public static void main(String args[]){
        Thread t1 = new Thread(new Threads());
        t1.start();
    }
}

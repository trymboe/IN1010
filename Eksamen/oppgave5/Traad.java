import java.util.concurrent.TimeUnit;
import javafx.application.Platform;


class Traad implements Runnable{
    public void run(){
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        Platform.exit();
        System.exit(0);
    }
}

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import javafx.collections.ObservableList;

public final class JavaFX extends Application {
    //variabler som trenger å være global for hele klassen
    //f.eks. for å finne neste ved knappetrykk trenger jeg en referanse til labyrintobjektet og listen med utveier
    private Labyrint l = null;
    private int losningTeller = 0;
    private boolean[][] losning;
    private Lenkeliste<String> utveier = new Lenkeliste<String>();
    private Text infoText = new Text("Trykke på en rute for å finne utvei");

    //Jeg lager en Knapp som er subklasse av Button for å kunne lagre noen ting i hvert knappeobjekt
    class Knapp extends Button {
        Rute rute;
        GridPane rutenett;

        public Knapp(Rute rute, GridPane rutenett){
            this.rute = rute;
            this.rutenett = rutenett;
        }

        public int hentRad(){
            return rute.rad;
        }

        public int hentKolonne(){
            return rute.kolonne;
        }

        public GridPane hentRutenett(){
            return rutenett;
        }
    }

    //når en rute blir trykket på
    class Trykk implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            paaTrykk((Knapp)e.getSource());
        }
    }

    class NesteBehandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(utveier.stoerrelse > 1 && losningTeller < utveier.stoerrelse){
                //alle hvite ruter blir hvite
                restart();


                infoText.setText("Det er til sammen " + utveier.stoerrelse + " losninger. Dette er losning " + (losningTeller+1) + ".");
                losning = losningStringTilTabell(utveier.hent(losningTeller), l.kolonne, l.rad);
                losningTeller++;

                //alle rutene i neste løsning blir malt grønne
                for(int rad = 0; rad < l.rad; rad++){
                    for(int kolonne = 0; kolonne < l.kolonne; kolonne++){
                        if(losning[rad][kolonne]){
                            skiftFargeGronn(l.labArray[kolonne][rad].knapp);
                        }
                    }
                }
            }
        }
    }

    //denne EventHandleren fungerer som NesteBehandler ovenfor bare for forrige løsning
    class ForrigeBehandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if(utveier.stoerrelse > 1 && losningTeller > 1){
                restart();

                losningTeller-=2;
                infoText.setText("Det er til sammen " + utveier.stoerrelse + " losninger. Dette er losning " + (losningTeller+1) + ".");
                losning = losningStringTilTabell(utveier.hent(losningTeller), l.kolonne, l.rad);
                losningTeller++;

                for(int rad = 0; rad < l.rad; rad++){
                    for(int kolonne = 0; kolonne < l.kolonne; kolonne++){
                        if(losning[rad][kolonne]){
                            skiftFargeGronn(l.labArray[kolonne][rad].knapp);
                        }
                    }
                }
            }
        }
    }

    //skifter fargen til knappen til grønn
    private void skiftFargeGronn(Knapp knapp){
        knapp.setStyle("-fx-background-color: Green");
    }

    //skifter fargen til knappen til hvit
    private void skiftFargeHvit(Knapp knapp){
        knapp.setStyle("-fx-background-color: White");
    }

    static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
        boolean[][] losning = new boolean[hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            losning[y][x] = true;
        }
        return losning;
    }

    //Denne metoden går gjennom alle grønne ruter og maler de hvite igjen
    private void restart(){
        for(int rad = 0; rad < l.rad; rad++){
            for(int kolonne = 0; kolonne < l.kolonne; kolonne++){
                if(l.labArray[kolonne][rad].knapp.getStyle() == "-fx-background-color: Green")
                    skiftFargeHvit(l.labArray[kolonne][rad].knapp);
            }
        }
    }

    //dette skjer når en rute trykkes på
    private void paaTrykk(Knapp knapp){
        //hele brettet males hvit og svart igjen
        restart();
        //utveiene finnes og settes som global variabel utveier
        utveier = l.finnUtveiFra(knapp.hentKolonne(), knapp.hentRad());
        losningTeller = 0;

        if(utveier.stoerrelse > 0){
            if (utveier.stoerrelse == 1){
                //Finnes det én utvei gjøres den om til et løsningsArray
                losning = losningStringTilTabell(utveier.hent(losningTeller), l.kolonne, l.rad);
                infoText.setText("Det er til sammen " + utveier.stoerrelse + " losning.");
            }
            else{
                //finnes det flere løsninger, gjøres den første om til et løsningsArray
                losning = losningStringTilTabell(utveier.hent(losningTeller), l.kolonne, l.rad);
                infoText.setText("Det er til sammen " + utveier.stoerrelse + " losninger. Dette er losning " + (losningTeller+1) + ".");
                losningTeller++;
            }

            //Om rutene er i løsningen males de grønne
            for(int rad = 0; rad < l.rad; rad++){
                for(int kolonne = 0; kolonne < l.kolonne; kolonne++){
                    if(losning[rad][kolonne]){
                        skiftFargeGronn(l.labArray[kolonne][rad].knapp);
                    }
                }
            }
        }
        else{
            infoText.setText("Ingen utveier");
        }
    }

    private GridPane lagLabyrint(File fil){
        File labyrintfil = fil;

        Labyrint lab = null;
        try {
            lab = Labyrint.lesFraFil(labyrintfil);
        }
        catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", labyrintfil);
            System.exit(1);
        }
        //setter labyrinten som en global variabel
        l = lab;

        //Gridpanet lages og skaleres etter hvordan labyrinten ser ut.
        GridPane rutenett = new GridPane();
        rutenett.setGridLinesVisible(true);
        int size = 600;
        double sizeKolonne = size/l.kolonne;
        double sizeRad = size/l.rad;
        rutenett.setPrefSize(size, size);




        //Alle rutene lages som Knapp(buttons)-objekter, skaleres, gis farge og settes i rutenettet
        for(int rad = 0; rad < l.rad; rad++){
            for(int kolonne = 0; kolonne < l.kolonne; kolonne++){
                if(l.labArray[kolonne][rad] instanceof HvitRute){
                    Trykk trykk = new Trykk();
                    Knapp b = new Knapp(l.labArray[kolonne][rad], rutenett);
                    b.setFont(new Font(1)); b.setPrefSize(sizeKolonne, sizeRad);
                    b.setOnAction(trykk);
                    //Hvert Ruteobjekt har nå en referanse til JavaFXknappeobjektet. Det legges til her
                    l.labArray[kolonne][rad].giKnapp(b);
                    skiftFargeHvit(b);
                    rutenett.add(b, kolonne, rad);

                }
                if(l.labArray[kolonne][rad] instanceof SortRute){
                    Knapp b = new Knapp(l.labArray[kolonne][rad], rutenett);
                    b.setFont(new Font(1)); b.setPrefSize(sizeKolonne, sizeRad);
                    //Hvert Ruteobjekt har nå en referanse til JavaFXknappeobjektet. Det legges til her
                    l.labArray[kolonne][rad].giKnapp(b);
                    b.setStyle("-fx-background-color: Black");
                    rutenett.add(b, kolonne, rad);
                }
            }
        }
        return rutenett;
    }


    ////////////////////////////////////////////////////////

    @Override
    public void start(final Stage teater) {
        final FileChooser fileChooser = new FileChooser();
        final Button filKnapp = new Button("Velg labyrint");

        //Dette skjer når du velger fil
        //Her defineres alle tingene som vises på skjermen
        filKnapp.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File fil = fileChooser.showOpenDialog(teater);
                    GridPane labyrintRutenett = lagLabyrint(fil);
                    labyrintRutenett.setLayoutY(50);

                    final Button nesteKnapp = new Button("Neste losning");
                    NesteBehandler neste = new NesteBehandler();
                    nesteKnapp.setOnAction(neste);

                    final Button forrigeKnapp = new Button("Forrige losning");
                    ForrigeBehandler forrige = new ForrigeBehandler();
                    forrigeKnapp.setLayoutX(150);
                    forrigeKnapp.setOnAction(forrige);


                    infoText.setFont(new Font(20));
                    infoText.setLayoutY(47);

                    Pane kulisser2 = new Pane();
                    kulisser2.getChildren().add(labyrintRutenett);
                    kulisser2.getChildren().add(nesteKnapp);
                    kulisser2.getChildren().add(forrigeKnapp);
                    kulisser2.getChildren().add(infoText);
                    Scene scene2 = new Scene(kulisser2);
                    teater.setScene(scene2);
                    teater.show();
                }
            });


        teater.setTitle("Labyrint");
        Pane kulisser1 = new Pane();
        kulisser1.getChildren().add(filKnapp);
        Scene scene1 = new Scene(kulisser1);
        teater.setScene(scene1);

        teater.show();


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

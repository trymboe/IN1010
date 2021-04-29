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
import javafx.application.Platform;


public final class GUI extends Application {

    public void start(final Stage teater) {
        int[] formue = Spill.formue;
        String streng;
        Text infoText = new Text("");

        teater.setTitle("Resultater");
        Pane kulisser1 = new Pane();

        for(int i = 0; i < formue.length; i++){
            streng = "Spiller nummer " + (i+1) + ": " + formue[i] + " kr.";
            infoText = new Text(streng);
            infoText.setFont(new Font(20));
            infoText.setLayoutY((i+1)*25);
            kulisser1.getChildren().add(infoText);
        }

        final FileChooser fileChooser = new FileChooser();
        final Button avsluttKnap = new Button("Avlsutt");

        avsluttKnap.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        );


        avsluttKnap.setLayoutX(400);

        kulisser1.getChildren().add(avsluttKnap);

        Scene scene1 = new Scene(kulisser1);
        teater.setScene(scene1);


        teater.show();
    }
}

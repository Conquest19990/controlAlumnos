package controlalumnosfx;

import java.net.URL;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author mecob
 */
public class RegAlertBox {

    //public  static URL url;
    public void display(String title, String message) {

        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        //url = URL.getClass().getResource("");
        layout.getStylesheets().add("controlalumnosfx/CSS/alertBoxCss.css");

        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Scene scene = new Scene(layout);
        Scene scene = new Scene( layout, 400, 250);
        window.setResizable(false);
        
        //window.initOwner(window);
        //
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
        //
        
        Image applicationIcon = new Image(getClass().getResourceAsStream("Imagenes/logo.jpg"));
        window.getIcons().add(applicationIcon);

        window.setScene(scene);
        window.centerOnScreen();

        window.showAndWait();

        

    }
}

package controlalumnosfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {

    Modelo model;

    @FXML
    private BorderPane mainPane;
    
    @FXML
    private BorderPane mainPane2;

    ControlAlumnosFx ctlAl;

    public LoginController() {
        ctlAl = new ControlAlumnosFx();

    }
    @FXML
    private Button logRegButton;

    @FXML
    private PasswordField passField;

    @FXML
    private Label errorText;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userField;

    @FXML
    void loginPressed(ActionEvent event) throws Exception {
        System.out.println("login pressed");
        String user = userField.getText();
        String pass = passField.getText();
        if (user != "" && pass != "") {
            System.out.println(user + "jo");
            System.out.println(pass);
            boolean flag = model.validateUsers(user, pass);
            if (flag) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPage("mainApp");
                mainPane.setBottom(null);
                mainPane.setTop(null);
                mainPane.setLeft(null);
                mainPane.setRight(null);
                mainPane.setCenter(view);

            } else {
                errorText.setVisible(true);
            }
        } else {
            errorText.setVisible(true);
        }
    }

    @FXML
    void registerPressed(ActionEvent event) throws IOException, Exception {
        System.out.println("register pressed");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("registro");
        mainPane.setBottom(null);
        mainPane.setTop(null);
        mainPane.setLeft(null);
        mainPane.setRight(null);
        mainPane.setCenter(view);
        
        
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        model = new Modelo();
        
        mainPane2 = new BorderPane();
        /*
        try {
            
            //model.importExcelUsuarios();
        } catch (Exception ex) {
            System.out.println("Error con usuarios");
        }
         */
    }

    @FXML
    void regAnimEnt(MouseEvent event) {

        logRegButton.setStyle("-fx-background-color: #464C51");
    }

    @FXML
    void regAnimExit(MouseEvent event) {

        logRegButton.setStyle("-fx-background-color: #343A40");
    }

    @FXML
    void regPressed(MouseEvent event) {

        logRegButton.setStyle("-fx-background-color: #575C61");
    }
    
    ///
    
    @FXML
    void logPressed(MouseEvent event) {

        loginButton.setStyle("-fx-background-color: #575C61");
    }
    
    @FXML
    void logAnimEnt(MouseEvent event) {

        loginButton.setStyle("-fx-background-color: #464C51");
    }

    @FXML
    void logAnimExit(MouseEvent event) {

        loginButton.setStyle("-fx-background-color: #343A40");
    }
    @FXML
    void logReleased(MouseEvent event) {

        loginButton.setStyle("-fx-background-color: #343A40");
    }

    ///
    @FXML
    void leftPressed(MouseEvent event) {

        leftButton.setStyle("-fx-background-color: #575C61");
    }
    
    @FXML
    void leftAnimEnt(MouseEvent event) {

        leftButton.setStyle("-fx-background-color: #464C51");
    }

    @FXML
    void leftAnimExit(MouseEvent event) {

        leftButton.setStyle("-fx-background-color: #343A40");
    }
    @FXML
    void leftReleased(MouseEvent event) {

        leftButton.setStyle("-fx-background-color: #343A40");
    }
    
    @FXML
    void rigPressed(MouseEvent event) {

        rigButton.setStyle("-fx-background-color: #575C61");
    }
    
    @FXML
    void rigAnimEnt(MouseEvent event) {

        rigButton.setStyle("-fx-background-color: #464C51");
    }

    @FXML
    void rigAnimExit(MouseEvent event) {

        rigButton.setStyle("-fx-background-color: #343A40");
    }
    @FXML
    void rigReleased(MouseEvent event) {

        rigButton.setStyle("-fx-background-color: #343A40");
    }
    
    ///
    
    @FXML
    private Button rigButton;
    
    @FXML
    private Button leftButton;
    
    @FXML
    void onEnterPressed(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("login pressed");
            String user = userField.getText();
            String pass = passField.getText();
            if (user != "" && pass != "") {
                System.out.println(user + "jo");
                System.out.println(pass);
                boolean flag = model.validateUsers(user, pass);
                if (flag) {
                    FxmlLoader object = new FxmlLoader();
                    Pane view = object.getPage("mainApp");
                    mainPane.setBottom(null);
                    mainPane.setTop(null);
                    mainPane.setLeft(null);
                    mainPane.setRight(null);
                    mainPane.setCenter(view);

                } else {
                    errorText.setVisible(true);
                }
            } else {
                errorText.setVisible(true);
            }
        }
    }
    
    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;
    
    @FXML
    private ImageView image3;
    
    private int selectedImage = 1;
    
    @FXML
    void leftAction(ActionEvent event){
        if(selectedImage == 1){
            image1.setVisible(false);
            image2.setVisible(true);
            selectedImage++;
        }else if(selectedImage == 2){
            image2.setVisible(false);
            image3.setVisible(true);
            selectedImage++;
        }else if(selectedImage == 3){
            image3.setVisible(false);
            image1.setVisible(true);
            selectedImage = 1;
        }
    }
    
    @FXML
    void rigAction(ActionEvent event) {

        if(selectedImage == 1){
            image1.setVisible(false);
            image3.setVisible(true);
            selectedImage = 3;
        }else if(selectedImage == 3){
            image3.setVisible(false);
            image2.setVisible(true);
            selectedImage = 2;
        }else if(selectedImage == 2){
            image2.setVisible(false);
            image1.setVisible(true);
            selectedImage = 1;
        }
    }
    

}

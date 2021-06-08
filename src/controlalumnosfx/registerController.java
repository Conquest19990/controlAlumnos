package controlalumnosfx;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author mecob
 */
public class registerController implements Initializable{
    
    private Modelo model;
    
    @FXML
    private TextField aPField;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField usrNameField;

    @FXML
    private TextField aMField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField intField;
    
    @FXML
    private ChoiceBox pstoField;
    
    @FXML
    private Button backBtn;
    
    @FXML
    private Label errorText;
    
    @FXML
    void registerClick(ActionEvent event) throws IOException {
        String fields[] = new String[7];
        fields[0] = usrNameField.getText();
        fields[1] = passField.getText();
        fields[2] = intField.getText();
        fields[3] = nameField.getText();
        fields[4] = aPField.getText();
        fields[5] = aMField.getText();
        fields[6] = (String)pstoField.getValue();
        boolean flag = false;
        
        for (int i = 0; i < fields.length; i++) {
            if(fields[i]!= null){
                flag = true;
            }else{
                flag = false;
                break;
            }
            if(!fields[i].equals(null) || !fields[i].equals("")){
                flag = true;
            }
        }
        if(flag){
           System.out.println(Arrays.toString(fields));
            model.registroUsuario(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]); 
            
            RegAlertBox alertBox = new RegAlertBox();
            alertBox.display("Registro", "Registro completado!");
            
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("Principal");
            mainPane.setBottom(null);
            mainPane.setTop(null);
            mainPane.setLeft(null);
            mainPane.setRight(null);
            mainPane.setCenter(view);
        }else{
            errorText.setText("Por favor llene todos los datos");
            errorText.setVisible(true);
        }
        
    }
    
    @FXML
    private BorderPane mainPane;
    
    @FXML
    void onBack(ActionEvent event) throws IOException {
        System.out.println("back pressed");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Principal");
        mainPane.setBottom(null);
        mainPane.setTop(null);
        mainPane.setLeft(null);
        mainPane.setRight(null);
        mainPane.setCenter(view);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Modelo();
        pstoField.getItems().add("Coordinador");
        pstoField.getItems().add("Jefe Dpto.");
    }
    
    //FCFCF7
    //989B9C
    //666B6E
    @FXML
    void backPressed(MouseEvent event) {

        backBtn.setStyle("-fx-background-color: #666B6E");
    }
    
    @FXML
    void backAnimEnt(MouseEvent event) {

        backBtn.setStyle("-fx-background-color: #989B9C");
    }

    @FXML
    void backAnimExit(MouseEvent event) {

        backBtn.setStyle("-fx-background-color: #FCFCF7");
    }
    @FXML
    void backReleased(MouseEvent event) {

        backBtn.setStyle("-fx-background-color: #FCFCF7");
    }
    
}

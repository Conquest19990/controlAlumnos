/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlalumnosfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author mecob
 */
public class FXMLDocumentController implements Initializable {
    
    private ControlAlumnosFx ctlAl;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private void handleLoginButton(ActionEvent event) {
        System.out.println("You clicked me!");
        try{
             //ctlAl.goToMainApp();
        }catch(Exception e){
        }
       
        //loginButton.setText("Hello World!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

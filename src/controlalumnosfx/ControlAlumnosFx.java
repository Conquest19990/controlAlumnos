/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlalumnosfx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
/**
 *
 * @author mecob
 */
public class ControlAlumnosFx extends Application{
    
    private Stage window;
    LoginController logCtl;
    private Parent loginPa, appPa;
    private Scene loginScene, appScene;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //
        //logCtl = new LoginController();
        //
        window = stage;
        //gotoLogin();
        ////gotoLogin();
        window.setResizable(false);
        loginPa = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        //appScene = FXMLLoader.load(getClass().getResource("mainApp.fxml"));

        window.setTitle("TecNM Control de Alumnos");

        Image applicationIcon = new Image(getClass().getResourceAsStream("Imagenes/logo.jpg"));
        window.getIcons().add(applicationIcon);
        
        window.setScene(new Scene(loginPa));
        window.show();
        /*
        Modelo model = new Modelo();
        model.importExcelSeguimiento();
        model.importExcelUsuarios();
        model.printInfo();*/
        //
        
        //
        
    }
    
    private void gotoLogin(){
        try{
            replaceSceneContent("Principal.fxml");
        }catch(Exception ex){
            Logger.getLogger(ControlAlumnosFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gotoMainApp() throws IOException, Exception{
        //window.setScene(new Scene(appPa));
        try{
            replaceSceneContent("mainApp.fxml");
        }catch(Exception ex){
            Logger.getLogger(ControlAlumnosFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gotoParent() throws IOException, Exception{
        //window.setScene(new Scene(appPa));
        try{
            replaceSceneContent("FXMLParent.fxml");
        }catch(Exception ex){
            Logger.getLogger(ControlAlumnosFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(ControlAlumnosFx.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = window.getScene();
        if (scene == null) {
            scene = new Scene(page, 1280, 720);
            //scene.getStylesheets().add(ControlAlumnosFx.class.getResource("demo.css").toExternalForm());
            window.setScene(scene);
        } else {
            window.getScene().setRoot(page);
        }
        window.sizeToScene();
        return page;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

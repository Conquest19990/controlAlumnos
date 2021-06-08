package controlalumnosfx;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author mecob
 */
public class FxmlLoader {
    private Pane view;
    
    public Pane getPage(String fileName){
        try{
            URL fileUrl = ControlAlumnosFx.class.getResource("/controlalumnosfx/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file not found");
            }
            view = new FXMLLoader().load(fileUrl);
        }catch(Exception ex){
            System.out.println("No page "+fileName+" please check FxmlLoader.");
        }
        return view;
    }
    
}

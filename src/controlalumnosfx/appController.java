package controlalumnosfx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class appController implements Initializable {

    @FXML
    private Label semLabel;

    @FXML
    private Label resLabel;

    @FXML
    private Label estado;

    @FXML
    private Label espLabel;

    @FXML
    private Label edadLbel;

    @FXML
    private Label capLabel;

    @FXML
    private Label sexLabel;

    @FXML
    private Label nctlLabel;

    @FXML
    private Label renLabel;

    @FXML
    private Label carLabel;

    @FXML
    private Label proLabel;

    private Modelo model;

    @FXML
    private TableColumn<Alumnos, String> ageCol;

    @FXML
    private TableColumn<Alumnos, String> crPrCol;

    @FXML
    private MenuItem openFile;

    @FXML
    private TableColumn<Alumnos, String> cargaCol;

    @FXML
    private TableView<Alumnos> segTable;

    @FXML
    private TableColumn<Alumnos, String> nCtlCol;

    @FXML
    private TableColumn<Alumnos, String> nameCol;

    @FXML
    private TableColumn<Alumnos, String> PromCol;

    @FXML
    private TableColumn<Alumnos, String> semCol;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TableColumn<Alumnos, String> sexCol;

    @FXML
    private TableColumn<Alumnos, String> espCol;

    @FXML
    private Tab segTab;

    @FXML
    private TabPane tabPaneApp;

    @FXML
    void onOpenFile(ActionEvent event) {
        //
        if (tabPaneApp.getSelectionModel().isSelected(0)) {

            Stage window = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Importar excel de seguimiento");
            File file = fileChooser.showOpenDialog(window);
            System.out.println(file.getPath());
            //
            try {

                model.setSEGUIMIENTO_PATH_CHOOSE(file.getPath());
                segTable.setEditable(true);

                alumnosArrayList.addAll(model.importExcelSeguimiento());

                nCtlCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("nCtrl"));
                nameCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("nombre"));
                sexCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("sexo"));
                ageCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("edad"));
                semCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("sem"));
                crPrCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("crApr"));
                cargaCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("carga"));
                PromCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("promedio"));
                espCol.setCellValueFactory(new PropertyValueFactory<Alumnos, String>("especialidad"));

                segTable.setItems(observableList());
                segTable.setEditable(false);

            } catch (Exception ex) {
                System.out.println("Shale");
                Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Ajio");
        }

        segTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Stage window = new Stage();

                try {
                    /*

                    //window.initStyle(StageStyle.UNDECORATED);
                    window.setResizable(false);
                    window.initModality(Modality.APPLICATION_MODAL);
                    window.setMinWidth(400);
                    window.setMinHeight(250);
                    Image applicationIcon = new Image(getClass().getResourceAsStream("Imagenes/logo.jpg"));
                    window.getIcons().add(applicationIcon);
                    
                    
                    //FXMLLoader fxmlL = new FXMLLoader();
                            
                    //fxmlL.setController(new appController());
                    
                    //Parent loginPa = fxmlL.load(getClass().getResource("alumView.fxml"));;
                    FxmlLoader object = new FxmlLoader();
                    
                    //Pane view = object.getPage("registro");
                    Parent loginPa = object.getPage("alumView");
                   
                    window.setScene(new Scene(loginPa));
                    window.showAndWait();
                    
                    nctlLabel.setText(newSelection.getnCtrl());
                     */
                    System.out.println("profile  pressed");
                    FxmlLoader object = new FxmlLoader();
                    Pane view = object.getPage("aliView");
                    mainPane.setBottom(null);
                    mainPane.setTop(null);
                    mainPane.setLeft(null);
                    mainPane.setRight(null);
                    mainPane.setCenter(view);
                    
                } catch (Exception ex) {
                    System.out.println("sipipip");
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Simon");
            }
        });
        //

    }

    public ObservableList<Alumnos> observableList() {

        ObservableList<Alumnos> people = FXCollections.observableArrayList();
        people.addAll(alumnosArrayList);
        return people;
    }

    ArrayList<Alumnos> alumnosArrayList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Modelo();

    }

    @FXML
    private Button backButton;

    //Stage window;
    @FXML
    void onEditAlu(ActionEvent event) {
        Stage window = new Stage();
        try {

            //window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setMinWidth(400);
            window.setMinHeight(250);
            Image applicationIcon = new Image(getClass().getResourceAsStream("Imagenes/logo.jpg"));
            window.getIcons().add(applicationIcon);

            Parent loginPa = FXMLLoader.load(getClass().getResource("alumView.fxml"));

            window.setScene(new Scene(loginPa));
            window.showAndWait();
        } catch (IOException ex) {
            System.out.println("sipipip");
            Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //backButton.setOnAction(e -> window.close());

    }

    @FXML
    private BorderPane aluVIewPane;

    @FXML
    void onBackEdit(ActionEvent event) {
        System.out.println("U press me");
        //window.close();
    }

}

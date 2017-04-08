package comandaeletronica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeController implements Initializable {
    
    @FXML
    private StackPane principal;

    @FXML
    private TextField tfProcurar;

    @FXML
    private AnchorPane navList;

    @FXML
    private VBox vbSide;

    @FXML
    private ImageView imgMenu;

    @FXML
    private Button menu;
    
    @FXML
    private ListView<Menu> lvMenu;
    
    @FXML
    private Label Title;
    
    private boolean isDrawerOpen;
    TranslateTransition openNav;
    TranslateTransition closeNav;
    private ComandaEletronica main;
    
    ObservableList<Menu> items =FXCollections.observableArrayList ();
    Image homeI = new Image(getClass().getResource("imagens/icones/Home.png").toExternalForm());
    Image usuariosI = new Image(getClass().getResource("imagens/icones/Contacts.png").toExternalForm());
    Image relatoriosI = new Image(getClass().getResource("imagens/icones/Wallet.png").toExternalForm());
    Image sairI = new Image(getClass().getResource("imagens/icones/Exit.png").toExternalForm());
    
    @FXML
    private void TrocaTela(MouseEvent event) {
        switch(lvMenu.getSelectionModel().getSelectedIndex()){
            case 0:
                trocaTela(event,"Inicio.fxml",0);
                changeTitle(lvMenu.getSelectionModel().getSelectedIndex());
                break;
            case 1:
                trocaTela(event,"Usuarios.fxml",1);
                changeTitle(lvMenu.getSelectionModel().getSelectedIndex());
                break;
            case 2:
                trocaTela(event,"Relatorios.fxml",2);
                changeTitle(lvMenu.getSelectionModel().getSelectedIndex());
                break;
            case 3:
                trocaTela(event,"",3);
                break;
        }
    }

    private void changeTitle(int position){
        Title.setText(items.get(position).getLabel());
    }
    
    public HomeController(){
        items.addAll(
                new Menu("Home", homeI),
                new Menu("Usuarios", usuariosI),
                new Menu("Relatórios", relatoriosI),
                new Menu("Sair", sairI)
        );
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prepareSlideMenuAnimation();
        isDrawerOpen=false;
        lvMenu.setCellFactory(menuListView -> new MenuListViewCell());
        lvMenu.setItems(items);
        lvMenu.getSelectionModel().select(0);
        lvMenu.requestFocus();
    }    

    private void trocaTela(MouseEvent event, String url,int escolha){
        try {
            if(escolha!=3){
                Parent root = FXMLLoader.load(getClass().getResource(url));
                principal.getChildren().remove(0);
                principal.getChildren().add(0, root);
                navagationDrawer();
            }else{
                System.exit(0);
            }
        } catch (IOException ex) {
            System.out.println("Nao foi possivel trocar a tela"+ ex);
        }
    }
    
    private void prepareSlideMenuAnimation() {
        openNav=new TranslateTransition(new Duration(350), navList);
        openNav.setToX(0);
        closeNav=new TranslateTransition(new Duration(350), navList);
        menu.setOnAction((ActionEvent evt)->{
            navagationDrawer();
        });
        principal.setOnMouseClicked((MouseEvent evt)->{
            if(isDrawerOpen){
                navagationDrawer();
            }
        });
    }

    private void navagationDrawer(){
        if(navList.getTranslateX()!=0){
            openNav.play();
            navList.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,.5), 10, 0, 1, 1);");
            isDrawerOpen=true;
        }else{
            closeNav.setToX(-(navList.getWidth()));
            closeNav.play();
            navList.setStyle("-fx-effect: none;");
            isDrawerOpen=false;
        }
    }
    
}

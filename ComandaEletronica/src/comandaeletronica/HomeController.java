package comandaeletronica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeController implements Initializable {
    
    @FXML
    private BorderPane principal;
    @FXML
    private TextField tfProcurar;

    @FXML
    private ListView<Menu> lvMenu;

    @FXML
    private VBox vbSide;

    @FXML
    private ImageView imgMenu;
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
                break;
            case 1:
                trocaTela(event,"Usuarios.fxml",1);
                break;
            case 2:
                trocaTela(event,"Relatorios.fxml",2);
                break;
            case 3:
                trocaTela(event,"",3);
                break;
        }
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
        lvMenu.setCellFactory(menuListView -> new MenuListViewCell());
        lvMenu.setItems(items);
        lvMenu.getSelectionModel().select(0);
        lvMenu.requestFocus();
    }    

    private void trocaTela(MouseEvent event, String url,int escolha) {
        try {
            if(escolha!=3){
                Parent root = FXMLLoader.load(getClass().getResource(url));
                principal.setCenter(root);
            }else{
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        } catch (IOException ex) {
            System.out.println("Nao foi possivel trocar a tela"+ ex);
        }
    }
    
}

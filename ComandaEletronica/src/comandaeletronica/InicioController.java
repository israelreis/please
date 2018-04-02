package comandaeletronica;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InicioController implements Initializable {

    @FXML
    private TableView<Pedido> tabelaPedido;
    @FXML
    private TableColumn<Pedido, Integer> cMesa;
    @FXML
    private TableColumn<Pedido, String> cSituacao;
    LinkedList<Pedido> i = new LinkedList<>();
    private ObservableList<Pedido> Pedidos = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        preencheTabela();
    }    

    private void preencheTabela() {
        //Preenche a tabela
    }
    
}

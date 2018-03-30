package comandaeletronica;

import java.net.URL;
import java.util.ResourceBundle;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        preencheTabela();
    }    

    private void preencheTabela() {
        //Preenche a tabela
    }
    
}

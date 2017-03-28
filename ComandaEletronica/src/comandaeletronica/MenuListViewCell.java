package comandaeletronica;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MenuListViewCell extends ListCell<Menu>{
    
    @FXML
    private Label labelMenu;

    @FXML
    private ImageView iconeMenu;

    @FXML
    private HBox hBoxCell;
    private FXMLLoader mLLoader = null;
    
    public MenuListViewCell() {
        
    }
    
    @Override
    protected void updateItem(Menu menu, boolean empty) {
        super.updateItem(menu, empty);

        if(empty || menu == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            labelMenu.setText(menu.getLabel());
            iconeMenu.setImage(menu.getImagem());

            setText(null);
            setGraphic(hBoxCell);
        }

    }
}

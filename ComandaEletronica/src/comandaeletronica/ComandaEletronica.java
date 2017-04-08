package comandaeletronica;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComandaEletronica extends Application {
    
    public static Scene scene;
    public static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        this.stage = stage;
        scene = new Scene(root);
        this.stage.setFullScreen(true);
        this.stage.setScene(scene);
        this.stage.show();
    }

    public static void trocaJohnCena(String url) throws IOException{
        FXMLLoader loarder = new FXMLLoader();
        loarder.setLocation(ComandaEletronica.class.getResource(url));
        Parent root = loarder.load();
        scene.setRoot(root);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

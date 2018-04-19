package pictures;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        stage.setScene(new Scene(root, 800, 400));
        stage.setTitle("Pictures");
        stage.setMaximized(true);
        stage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}

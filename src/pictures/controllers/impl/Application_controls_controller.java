package pictures.controllers.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Application_controls_controller implements Initializable{

    @FXML
    private TextField result;

    @FXML
    private TextField search_text;

    @FXML
    private ImageView imageView;

    String name = "";
    Image image;
    HashMap<String, Image> imageMap = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void loadFileButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");
        Window window = ((Node) event.getTarget()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(window);
        if (file != null){
            try {
                image = new Image(new FileInputStream(file.getAbsolutePath()));
                name = file.getName();
                imageMap.put(name, image);
            } catch (FileNotFoundException e){
                System.out.println( e.getMessage());
            }
        }
    }
    public void searchPictureButtonAction(ActionEvent event){
        for(Map.Entry<String, Image> entry : imageMap.entrySet()) {
            String key = entry.getKey();
            Image value = entry.getValue();
            if (key.contains(search_text.getText())){
                result.setText(key);
                imageView.setImage(value);
                System.out.println(key);
                return;
            }
            result.setText("?");
            imageView.setImage(null);
        }
    }
}

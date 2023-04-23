package net.digimonworld.decode.editor;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class EditorLauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene root = FXMLLoader.load(getClass().getResource("/fxml/Editor.fxml"));
        
        stage.setScene(root);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
package net.digimonworld.decode.editor.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import net.digimonworld.decode.editor.EditorEnvironment;
import net.digimonworld.decodetools.core.FileAccess;
import net.digimonworld.decodetools.res.ResPayload;

public class EditorController {
    private final EditorEnvironment environment = EditorEnvironment.getInstance();
    
    @FXML
    private Scene root;
    
    @FXML
    private TabPane fileTabs;
    
    @FXML
    public void openFile(ActionEvent e) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("What file to open?");
        chooser.setInitialDirectory(environment.getLastPath());
        
        List<File> selected = chooser.showOpenMultipleDialog(root.getWindow());
        
        if (selected == null)
            return;
        
        for (var file : selected) {
            try (var access = new FileAccess(file)) {
                ResPayload payload = ResPayload.craft(access);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/KCAPView.fxml"));
                loader.setController(new KCAPEditor(payload));
                Tab tab = new Tab(file.getName(), loader.load());
                fileTabs.getTabs().add(tab);
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            environment.setLastPath(file.getParentFile());
        }
    }
}

module net.digimonworld.decode.editor {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires org.controlsfx.controls;
    requires net.digimonworld.decode.decode_tools;
    
    opens net.digimonworld.decode.editor to javafx.fxml;
    opens net.digimonworld.decode.editor.controller to javafx.fxml;
    
    exports net.digimonworld.decode.editor;
}

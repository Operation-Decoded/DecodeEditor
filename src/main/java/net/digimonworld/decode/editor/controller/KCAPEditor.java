package net.digimonworld.decode.editor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import net.digimonworld.decodetools.res.ResPayload;
import net.digimonworld.decodetools.res.ResPayload.Payload;
import net.digimonworld.decodetools.res.kcap.AbstractKCAP;

public class KCAPEditor {
    @FXML
    private TreeView<ResPayload> kcapTree;
    
    private ResPayload payload;
    
    public KCAPEditor(ResPayload payload) {
        this.payload = payload;
        
    }
    
    public void initialize() {
        kcapTree.setCellFactory(a -> new ResPayloadCell());
        kcapTree.setRoot(craftTree(payload));
    }
    
    private static TreeItem<ResPayload> craftTree(ResPayload payload) {
        var item = new TreeItem<>(payload);
        
        if (payload.getType() == Payload.KCAP)
            item.getChildren()
                .addAll(((AbstractKCAP) payload).getEntries().stream().map(KCAPEditor::craftTree).toList());
        
        return item;
    }
    
    private class ResPayloadCell extends TreeCell<ResPayload> {
        @Override
        protected void updateItem(ResPayload item, boolean empty) {
            super.updateItem(item, empty);
            if (empty)
                setText(null);
            else
                setText(String.format("%s", item.getType() == null ? "VOID" : item.getType().name()));
        }
    }
}

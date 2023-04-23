package net.digimonworld.decode.editor;

import java.io.File;

public class EditorEnvironment {
    private static final EditorEnvironment instance = new EditorEnvironment();
    
    private File lastPath = new File(".");
    
    public static EditorEnvironment getInstance() {
        return instance;
    }
    
    public File getLastPath() {
        return lastPath;
    }
    
    public void setLastPath(File lastPath) {
        this.lastPath = lastPath;
    }
    
}

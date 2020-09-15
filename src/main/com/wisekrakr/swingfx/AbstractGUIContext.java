package com.wisekrakr.swingfx;

import javafx.scene.Node;

public interface AbstractGUIContext {

    AbstractJFXPanel initialize(String fxmlPath);
    void addDraggability(AbstractGUI parentGUI, Node node);

}

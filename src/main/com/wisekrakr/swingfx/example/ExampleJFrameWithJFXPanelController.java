package com.wisekrakr.swingfx.example;


import com.wisekrakr.swingfx.AbstractGUI;
import com.wisekrakr.swingfx.AbstractJFXPanel;
import com.wisekrakr.swingfx.ControllerContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ExampleJFrameWithJFXPanelController extends AbstractJFXPanel implements ControllerContext {
    private final AbstractGUI gui;
    private String welcomeString;

    /**
     * Take the main pane (any pane) and set the fx:id to container (or any other name you'd like)
     */
    @FXML
    private AnchorPane container;

    /**
     * an example component that needs to be initialized immediately. Set the fx:id.
     */
    @FXML
    private Label test;

    public ExampleJFrameWithJFXPanelController(AbstractGUI gui, String welcomeString) {
        this.gui = gui;
        this.welcomeString = welcomeString;

    }

    /**
     * Initialize in the parent GUI
     */
    @Override
    public void initComponents() {
        test.setText(welcomeString);
    }

    @FXML
    @Override
    public void drag() {
        addDraggability(gui, container);
    }

    @FXML
    @Override
    public void close() {
        gui.hideGUI();
        System.exit(1);
    }


}

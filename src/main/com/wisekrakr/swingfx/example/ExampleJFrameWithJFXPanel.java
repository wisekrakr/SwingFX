package com.wisekrakr.swingfx.example;

import com.wisekrakr.swingfx.AbstractGUI;

import java.awt.*;

/**
 * A JFrame with JFXPanel attached.
 */
public class ExampleJFrameWithJFXPanel extends AbstractGUI {

    private static final int DESIRED_HEIGHT = 400;
    private static final int DESIRED_WIDTH = 400;

    public ExampleJFrameWithJFXPanel() {

    }


    @Override
    public void prepareGUI() {

        //Optional. This project has the ability to drag undecorated JFXPanels without a stage attached.
        setUndecorated(true);

        setPreferredSize(new Dimension(DESIRED_WIDTH, DESIRED_HEIGHT));
        setLocationRelativeTo(null);

        //Example of a parameter that can be passed to the controller.
        String welcomeString = "Hola Mundo!";

        //Load your fxml file from resources. Pass parameters to the controller.
        ExampleJFrameWithJFXPanelController controller = (ExampleJFrameWithJFXPanelController) new ExampleJFrameWithJFXPanelController(this, welcomeString).initialize("/example.fxml");
        //Init the components so that they are filled before the frame is shown,
        controller.initComponents();
        //Add the controller to the JFrame and set it in the center.
        add(controller, BorderLayout.CENTER);
    }

    @Override
    public void showGUI() {
        pack();
        setVisible(true);
    }

}

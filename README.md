![Master](https://github.com/ipphone/core/workflows/Master/badge.svg)
<img src="https://img.shields.io/badge/Java-build%20with%20Java-blue"/>
![version](https://img.shields.io/badge/version-0.0.1-cyan)

    
                                  Swing to JavaFX. Build JFrames with JFXPanels
                                 



<a href="https://twitter.com/intent/follow?screen_name=wisekrakr">
        <img src="https://img.shields.io/twitter/follow/wisekrakr?style=social&logo=twitter"
            alt="follow on Twitter"></a>
            
            

A tiny library for those who want to create Swing JFrames, but with the aesthetics of a JavaFX Pane.
With the help of a fxml file (or you can build out your pane in Screenbuilder), you can create and control
your app easily.

#### LICENSE

#### PREREQUISITES

This software has been developed using Oracle Java Development Kit
version 7.

#### DEPENDENCIES

These are no dependencies used in the project.

#### USAGE



> *STEP 1:  create a new "abstract gui". This is a basic JFrame with some extra methods attached.* :

 
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
    public void showWindow() {
        pack();
        setVisible(true);
    }



> *STEP 2:  create a new "controller". This is the JFXPanel that will hold all the components.* :

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

> *STEP 3:  Initialize the GUI, prepare the GUI (initializes the components in the controller) and show the window* :

    public static void main(String[] args) {
        ExampleJFrameWithJFXPanel exampleJFrameWithJFXPanel = new ExampleJFrameWithJFXPanel();
        exampleJFrameWithJFXPanel.prepareGUI();
        exampleJFrameWithJFXPanel.showGUI();
    }

## AUTHOR

David Buendia Cosano davidiscodinghere@gmail.com
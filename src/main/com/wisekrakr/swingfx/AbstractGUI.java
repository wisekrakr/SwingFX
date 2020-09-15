package com.wisekrakr.swingfx;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractGUI extends JFrame implements FrameContext {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Dimension getScreenSize() {
        return screenSize;
    }

    @Override
    public void hideGUI() {
        this.setVisible(false);
    }

    @Override
    public void prepareGUI() {
    }

    @Override
    public void showGUI() {
    }
}

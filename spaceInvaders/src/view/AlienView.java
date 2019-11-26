package view;

import model.GameInfoProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * A view of the model-view controller architecture separate from the main view class. This view is a frame used
 * to display a single space invader and the amount of space invaders left in the game.
 */
public class AlienView extends JFrame {
    /**
     * The height of the frame
     */
    public static final int HEIGHT = 250;

    /**
     * The width of the frame
     */
    public static final int WIDTH = 250;

    /**
     * Initialize the frame for the image of a space invader and the amount of space invaders left to be displayed in.
     */
    public AlienView() {
        setTitle("Aliens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Width and height passed in are those for the game panel, so add enough height for the
         * title bar and the information panel, and enough width for the border.
         */
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
    }

    /**
     * Set the frame visible showing the panel passed in, and set the focus in the Component
     * obtained from the panel.
     *
     * @param panel the panel to be shown in the view
     */
    public void displayPanel(ViewPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().validate();
        Component focusComponent = panel.getFocusComponent();
        if (focusComponent != null)
            focusComponent.requestFocusInWindow();
        setVisible(true);
    }

    public void showAlienPanel(GameInfoProvider gameInfoProvider, KeyListener keyListener) {
        ViewPanel overallPanel = new ViewPanel();
        /* A ViewPanel is used so that the component to have the focus can be set. */
        overallPanel.setLayout(new BorderLayout());

        AlienViewPanel panel = new AlienViewPanel(gameInfoProvider);
        panel.setPreferredSize(new Dimension(getWidth(), AlienViewPanel.HEIGHT));
        overallPanel.add(panel, BorderLayout.PAGE_START);

        displayPanel(overallPanel);

    }

}

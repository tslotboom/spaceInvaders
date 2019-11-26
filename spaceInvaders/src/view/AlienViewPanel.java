package view;

import model.GameInfoProvider;
import model.GameObserver;
import util.PropertiesDiskStorage;

import java.awt.*;

public class AlienViewPanel extends GraphicsPanel implements GameObserver {


    /**
     * The object that provides information about the game.
     */
    private GameInfoProvider gameInfo;

    public AlienViewPanel(GameInfoProvider gameInfo) {
        this.gameInfo = gameInfo;
        setDoubleBuffered(true);
    }

    public static final int TEXT_X_OFFSET = 20;
    public static final int TEXT_Y_OFFSET = 20;

    @Override
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D bufferedGraphics = (Graphics2D) g;
        setBackground(Color.BLACK);
        bufferedGraphics.setPaint(Color.GREEN);
        drawString(TEXT_X_OFFSET, TEXT_Y_OFFSET, ""+ gameInfo.getGameObjects(),
                GraphicsPanel.REG_FONT_SIZE, bufferedGraphics);


    }

    private void drawAlien() {
        String imageName = PropertiesDiskStorage.getInstance().getProperty("lives_indicator");
    }




    public synchronized void gameChanged() {
        repaint();
    }
}

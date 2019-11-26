package view;

import model.GameInfoProvider;
import model.GameObserver;

public class AlienViewPanel extends GraphicsPanel implements GameObserver {

    /**
     * The object that provides information about the game.
     */
    private GameInfoProvider gameInfo;

    public AlienViewPanel(GameInfoProvider gameInfo) {
        this.gameInfo = gameInfo;
        setDoubleBuffered(true);
    }



    public synchronized void gameChanged() {
        repaint();
    }
}

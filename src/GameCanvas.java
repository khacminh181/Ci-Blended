import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    public GameCanvas() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0,600,800);
    }
}

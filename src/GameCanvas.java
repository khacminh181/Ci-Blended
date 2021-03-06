import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;
    Image player;

    public GameCanvas() {
        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background,0,0,null);
        g.drawImage(player,x, y, null);
    }

    int x = 300 - 32;
    int y = 650 -40;

    public void keyPresses(KeyEvent e) {
        if (e.getKeyCode() ==  KeyEvent.VK_RIGHT) {
            x += 5;
            this.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 5;
            this.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += 5;
            this.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 5;
            this.repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Canvas handling key released");
    }
}

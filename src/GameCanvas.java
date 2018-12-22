import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;

    public static ArrayList<PlayerBullet> bs;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;



    public GameCanvas() {
        bs = new ArrayList<>();

        background = new Background(0, 0);
        player = new Player(300 - 32, 650 -40);

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    void keyPressed (KeyEvent e) {
        if (e.getKeyCode() ==  KeyEvent.VK_RIGHT) {
            KeyEventPress.rightPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            KeyEventPress.leftPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            KeyEventPress.downPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            KeyEventPress.upPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            KeyEventPress.xPressed = true;
        }
    }

    void keyReleased (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            KeyEventPress.rightPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            KeyEventPress.leftPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            KeyEventPress.downPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            KeyEventPress.upPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            KeyEventPress.xPressed = false;
        }
    }

    void run() {
        player.run();

        for (PlayerBullet b : bs) {
            b.run();
        }
    }

    void render() {
        background.render(backBufferGraphics);
        player.render(backBufferGraphics);
        for (PlayerBullet b : bs) {
            b.render(backBufferGraphics);
        }

        this.repaint();
    }
}

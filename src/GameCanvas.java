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
    Image background;
    Image player;

    ArrayList<PlayerBullet> bs;
    int x = 300 - 32;
    int y = 650 -40;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean xPressed = false;

    public GameCanvas() {
        bs = new ArrayList<>();
        background = ImageUtil.loadImage("images/background/background.png");
        player = ImageUtil.loadImage("images/player/MB-69/player1.png");

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    void keyPressed (KeyEvent e) {
        if (e.getKeyCode() ==  KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }
    }

    void keyReleased (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    void run() {
        if (rightPressed) {
            x += 5;
        }
        if (leftPressed) {
            x -= 5;
        }
        if (downPressed) {
            y += 5;
        }
        if (upPressed) {
            y -= 5;
        }
        for (PlayerBullet b : bs) {
            b.y -= 2;
        }

        if (xPressed && !shootDisabled) {
            PlayerBullet newBullet = new PlayerBullet();
            newBullet.x = x;
            newBullet.y = y;
            newBullet.image = ImageUtil.loadImage("images/bullet/player/mb69bullet1.png");

            bs.add(newBullet);
            shootDisabled = true;
        }

        if (shootDisabled) {
            count++;
            if (count > 30) {
                shootDisabled = false;
                count = 0;
            }
        }
    }

    boolean shootDisabled = false;
    int count;

    void render() {
        backBufferGraphics.drawImage(background,0,0,null);
        backBufferGraphics.drawImage(player,x, y, null);
        for (PlayerBullet b : bs) {
            backBufferGraphics.drawImage(b.image,b.x,b.y, null);
        }

        this.repaint();
    }
}

import java.awt.*;

public class Player {
    int x;
    int y;
    Image image;

    boolean shootDisabled = false;
    int count;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.loadImage("images/player/MB-69/player1.png");
    }

    public void run() {
        if (KeyEventPress.rightPressed) {
            this.x += 5;
        }
        if (KeyEventPress.leftPressed) {
            this.x -= 5;
        }
        if (KeyEventPress.downPressed) {
            this.y += 5;
        }
        if (KeyEventPress.upPressed) {
            this.y -= 5;
        }


        if (KeyEventPress.xPressed && !shootDisabled) {
            PlayerBullet newBullet = new PlayerBullet(this.x, this.y);
            GameCanvas.bs.add(newBullet);
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

    public void render(Graphics g) {
        g.drawImage(this.image,this.x, this.y, null);
    }
}

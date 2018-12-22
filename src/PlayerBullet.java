import java.awt.*;

public class PlayerBullet {
    int x;
    int y;
    Image image;

    public PlayerBullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.loadImage("images/bullet/player/mb69bullet1.png");
    }

    public void run() {
        this.y -= 2;
    }

    public void render(Graphics g) {
        g.drawImage(this.image,this.x,this.y, null);
    }
}

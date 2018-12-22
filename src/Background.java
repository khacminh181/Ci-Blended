import java.awt.*;

public class Background {
    int x;
    int y;
    Image image;

    public Background(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.loadImage("images/background/background.png");
    }

    public void render(Graphics g) {
        g.drawImage(this.image,this.x,this.y,null);
    }
}

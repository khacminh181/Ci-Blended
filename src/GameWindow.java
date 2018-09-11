import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;

    public GameWindow() {

        //Setup Window

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setSize(600, 800);
        this.setResizable(false);
        this.setTitle("Title");


        //Setup Canvas

        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);
        this.setVisible(true);

    }
}

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow() {

        //Setup Window

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                canvas.keyPresses(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                canvas.keyReleased(e);
            }
        });

        this.setSize(600, 800);
        this.setResizable(false);
        this.setTitle("Title");


        //Setup Canvas

        canvas = new GameCanvas();
        this.setContentPane(canvas);
        this.setVisible(true);

    }
}

import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class BouncingBallsApp extends JFrame implements Runnable {
    boolean positiveXDirection = true;
    boolean positiveYDirection = true;
    Thread th;
    ImageIcon ballImage = new ImageIcon("64.png");
    JLabel marqueeLabel = new JLabel();
    int xAxis = 0;
    int yAxis = 0;

    public BouncingBallsApp() {
        this.setTitle("Boucing Ball Application");
        marqueeLabel.setIcon(ballImage);
        marqueeLabel.setHorizontalAlignment(JLabel.LEFT);
        marqueeLabel.setVerticalAlignment(JLabel.TOP);
        this.add(marqueeLabel);
        th = new Thread(this);
        th.start();
    }

    public void changePlaceX() {
        marqueeLabel.setLocation(this.xAxis, this.yAxis);

        if (this.positiveXDirection == true) {
            this.xAxis ++;
        } else {
            this.xAxis --;
        }
        if (this.positiveYDirection == true) {
            this.yAxis ++;
        } else {
            this.yAxis --;
        }

        if (this.xAxis >= (this.getWidth() - 64)) {
            this.positiveXDirection = false;
        }
        if (this.xAxis == 0) {
            this.positiveXDirection = true;
        }

        if (this.yAxis >= (this.getHeight() - 64)) {
            this.positiveYDirection = false;
        }
        if (this.yAxis == 0) {
            this.positiveYDirection = true;
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(25);
                this.changePlaceX();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    } // End of run

    public static void main(String[] args) {
        BouncingBallsApp app = new BouncingBallsApp();
        app.setBounds(50, 50, 640, 640);
        app.setVisible(true);
    }
}

import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class MarqueeApp extends JFrame implements Runnable {
    Thread th;
    JLabel marqueeLabel = new JLabel();
    int xAxis = 0;

    public MarqueeApp() {
        this.setTitle("Marquee Application");
        marqueeLabel.setText("Hello Java");
        // marqueeLabel.setHorizontalAlignment(JLabel.CENTER);
        marqueeLabel.setLocation(this.xAxis, 20);
        this.add(marqueeLabel);
        th = new Thread(this);
        th.start();
    }

    public void changePlaceX() {
        this.xAxis += 1;
        marqueeLabel.setLocation(this.xAxis, 20);
        if (this.xAxis > this.getWidth()) {
            this.xAxis = 0;
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
                this.changePlaceX();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    } // End of run

    public static void main(String[] args) {
        MarqueeApp app = new MarqueeApp();
        app.setBounds(50, 50, 600, 400);
        app.setVisible(true);
    }
} // End of class

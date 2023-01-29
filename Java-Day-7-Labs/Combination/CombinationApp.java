import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

class CombinationApp extends JFrame {
    public CombinationApp() {
        this.setTitle("Combination Application");
        MarqueeThread marq = new MarqueeThread();
        DateTimeThread dateApp = new DateTimeThread();
        BouncingBallThread ball = new BouncingBallThread();
        this.setBounds(50, 50, 640, 640);
        this.setLayout(null);
        this.add(dateApp);
        // TODO Change it to Not be a label , Just a Thread
        // But First Change And Refactor Code For Ball Position
        this.add(marq);
        this.add(ball);
        this.setVisible(true);
        Thread marqThread = new Thread(marq);
        marqThread.start();
        Thread datThread = new Thread(dateApp);
        datThread.start();
        Thread ballThread = new Thread(ball);
        ballThread.start();
    }

    public static void main(String[] args) {
        new CombinationApp();
    }

    class MarqueeThread extends JLabel implements Runnable {
        Thread th;
        int xAxis = 0;

        public MarqueeThread() {
            setText("Hello Java");
            setLocation(this.xAxis, 20);
            this.setBounds(20, 20, 50, 40);
        }

        public void changePlaceX() {
            this.xAxis += 30;
            setLocation(this.xAxis, 20);
            if (this.xAxis > 640) {
                this.xAxis = -10;
            }
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                    this.changePlaceX();
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }
        } // End of run
    } // End of class

    class DateTimeThread extends JLabel implements Runnable {
        Date d = new Date();

        public DateTimeThread() {
            setHorizontalAlignment(JLabel.CENTER);
            setText(d.toString());
            this.setBounds(60, 60, 150, 90);
        }

        public void run() {
            while (true) {
                try {
                    d = new Date();
                    setText(d.toString());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }
        } // End of run
    } // End of class

    class BouncingBallThread extends JLabel implements Runnable {
        boolean positiveXDirection = true;
        boolean positiveYDirection = true;
        ImageIcon ballImage = new ImageIcon("64.png");
        int xAxis = 0;
        int yAxis = 0;

        public BouncingBallThread() {
            setIcon(ballImage);
            setLocation(0, 0);
            setBounds(60, 60, 150, 90);
        }

        // This is where you Should Really Do the Re-Factor
        //
        public void changePlaceX() {
            setLocation(this.xAxis, this.yAxis);
            checkDirectionFlags();
            checkWallCollision();
        }

        public void checkWallCollision() {
            if (this.xAxis >= (640)) {
                this.positiveXDirection = false;
            }
            if (this.xAxis <= 0) {
                this.positiveXDirection = true;
            }

            if (this.yAxis >= (640 - 68)) {
                this.positiveYDirection = false;
            }
            if (this.yAxis <= 0) {
                this.positiveYDirection = true;
            }
        }

        public void checkDirectionFlags() {
            if (this.positiveXDirection == true) {
                this.xAxis += 16;
            } else {
                this.xAxis -= 24;
            }
            if (this.positiveYDirection == true) {
                this.yAxis += 32;
            } else {
                this.yAxis -= 16;
            }
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(150);
                    this.changePlaceX();
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }
        } // End of run
    }
}

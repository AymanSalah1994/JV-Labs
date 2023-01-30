
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.net.*;

public class SmallDNS extends JFrame implements ActionListener {
    JLabel promptLabel = new JLabel("Enter the URL To search:");
    JTextField textField = new JTextField();
    JButton enterBTN = new JButton("Find IP Address");

    SmallDNS() {
        setSize(600, 600);
        setLayout(null);
        this.setTitle("Little DNS");
        // super("Little DNS")
        promptLabel.setFont(new Font("MonoSpaced", Font.BOLD, 20));
        promptLabel.setBounds(150, 100, 200, 30);
        textField.setBounds(150, 200, 200, 30);
        enterBTN.setBounds(150, 300, 100, 30);
        enterBTN.addActionListener(this);
        // addMouseListener ? && implements MouseListener
        add(promptLabel);
        add(textField);
        add(enterBTN);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String userInput = textField.getText();

        if (userInput.matches("(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)")) {
            try {
                InetAddress address = InetAddress.getByName(userInput);
                String ipAddress = address.getHostAddress();
                JOptionPane.showMessageDialog(this, ipAddress);
                // This refer to source object ??
            } catch (UnknownHostException exp) {
                JOptionPane.showMessageDialog(this, exp.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid URL");
        }

    }

    public static void main(String[] args) {
        new SmallDNS();
    }
}

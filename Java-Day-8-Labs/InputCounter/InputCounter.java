
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.net.*;

public class InputCounter extends JFrame implements ActionListener {
    JTextArea textArea = new JTextArea();
    JButton wordBTN = new JButton("Words");
    JButton characterBTN = new JButton("Characters");

    InputCounter() {
        setSize(600, 600);
        setLayout(null);
        this.setTitle("Words & Character Counter ");
        textArea.setBounds(20, 20, 560, 300);
        wordBTN.setBounds(150, 400, 100, 30);
        wordBTN.addActionListener(this);
        characterBTN.setBounds(300, 400, 120, 30);
        characterBTN.addActionListener(this);

        add(textArea);
        add(wordBTN);
        add(characterBTN);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String userInput = textArea.getText();
        if (e.getSource() == characterBTN) {
            char[] allCharacters = userInput.toCharArray();
            JOptionPane.showMessageDialog(this, allCharacters.length);
        } else {
            String[] allWords = userInput.split(" ");
            JOptionPane.showMessageDialog(this, allWords.length);
        }
    }

    public static void main(String[] args) {
        new InputCounter();
    }
}

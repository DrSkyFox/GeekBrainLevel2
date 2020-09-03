package lessonFour.chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListner implements ActionListener {
    private JTextField jTextField;
    private JTextArea jTextArea;

    public ButtonListner(JTextField jTextField, JTextArea jTextArea) {
        this.jTextField = jTextField;
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!jTextField.getText().trim().isEmpty()) {
            jTextArea.append(jTextField.getText());
            jTextArea.append("\n");
            jTextField.setText("");
        }
    }
}

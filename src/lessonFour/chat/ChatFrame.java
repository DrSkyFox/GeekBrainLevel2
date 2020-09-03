package lessonFour.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatFrame extends JFrame {
    public ChatFrame() {
        setTitle("TelegramKiller XD");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(0, 0, 800, 600));
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        JPanel top = new JPanel();
        JPanel middle = new JPanel();
        JPanel bottom = new JPanel();


        top.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        top.add(jScrollPane);


        middle.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        textArea.setEditable(true);
        middle.add(textField);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().trim().isEmpty()) {
                    textArea.append(textField.getText());
                    textArea.append("\n");
                    textField.setText("");
                }
            }
        });


        bottom.setLayout(new BorderLayout());

        JButton button = new JButton("Enter");
        bottom.add(button);
        button.addActionListener(new ButtonListner(textField,textArea));

        add(top);
        add(middle);
        add(bottom);


        setVisible(true);
    }
}

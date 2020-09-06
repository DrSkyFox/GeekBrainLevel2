package lessonFour.calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ModeListener implements ActionListener {
    private final JButton hexButton = new JButton("HEX");
    private final JButton sqrtButton = new JButton("sqrt");
    private final List<JButton> currentButtons;
    private final JPanel currentPanel;

    public ModeListener(List<JButton> currentButtons, JPanel currentPanel) {
        this.currentButtons = currentButtons;
        this.currentPanel = currentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonMode mode = (ButtonMode) ((JComboBox<String>) e.getSource()).getModel().getSelectedItem();
        switch (mode) {
            case BASIC: {

                currentPanel.remove(hexButton);
                currentPanel.remove(sqrtButton);
                System.out.println("Basic: ");
                break;
            }
            case ENGINEER: {
                currentPanel.remove(hexButton);
                currentPanel.add(sqrtButton);
                System.out.println("Engineer: ");
                break;
            }
            case PROGRAMMING: {
                currentPanel.remove(sqrtButton);
                currentPanel.add(hexButton);
                System.out.println("Programming: ");
                break;
            }
        }


        currentPanel.revalidate();
        currentPanel.repaint();
        currentPanel.setVisible(true);
    }
}

package example_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 01.05.15.
 */
public class FrameDisplay extends JFrame {
    private HandlerController handlerController = new HandlerController();
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_8;
    private JButton button_9;
    private JButton button_0;
    private JButton button_clear;
    private JButton button_p;
    private JButton button_v;
    private JButton button_d;
    private JButton button_m;
    private JTextField textField;

    public FrameDisplay(String str) {
        super(str);

        setLayout(new FlowLayout());
        textField = new JTextField(16);
        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_7 = new JButton("7");
        button_8 = new JButton("8");
        button_9 = new JButton("9");
        button_0 = new JButton("0");
        button_clear = new JButton("C");
        button_p = new JButton("+");
        button_v = new JButton("-");
        button_m = new JButton("*");
        button_d = new JButton("/");

        add(textField);

        add(button_1);
        add(button_2);
        add(button_3);

        add(button_p);

        add(button_4);
        add(button_5);
        add(button_6);
        add(button_v);

        add(button_7);
        add(button_8);
        add(button_9);
        add(button_m);

        add(button_0);
        add(button_d);
        add(button_clear);

        button_clear.addActionListener(handlerController);
        button_1.addActionListener(handlerController);
        button_2.addActionListener(handlerController);
        button_3.addActionListener(handlerController);

    }

    class HandlerController implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button_1) {
                textField.setText(button_1.getText());
            }

            if (e.getSource() == button_clear) {
                textField.setText("");
            }
            if (e.getSource() == button_2) {
                textField.setText(button_2.getText());
            }
            if (e.getSource() == button_3) {
                textField.setText(button_3.getText());
            }

        }
    }
}

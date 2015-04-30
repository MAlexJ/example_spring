package example_01;


import javax.swing.*;
import java.awt.*;

public class FrameDisplay extends JFrame {
    private JButton button_01;
    private JButton button_02;
    private JLabel label_01;
    private JLabel label_02;
    private JLabel label_03;
    private JTextField textField_01;
    private JTextField textField_02;

    public FrameDisplay(String str) {
        //Creates a new, initially invisible Frame with the specified title.
        super(str);

        setLayout(new FlowLayout());
        //
        button_01 = new JButton();
        button_01.setText("1");
        //
        button_02 = new JButton("2");

        label_01 = new JLabel("Label  1 ");
        label_02 = new JLabel("Label  2 ");
        label_03 = new JLabel("");
        textField_01 = new JTextField(10);
        textField_02 = new JTextField(10);

        add(label_01);
        add(textField_01);
        add(label_02);
        add(textField_02);
        add(button_01);
        add(button_02);

    }

}

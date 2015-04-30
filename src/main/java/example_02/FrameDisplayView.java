package example_02;

import javax.swing.*;
import java.awt.*;

public class FrameDisplayView extends JFrame {
    private EvHandlerController evHandlerController = new EvHandlerController();
    private JButton button_01;
    private JButton button_02;

    public FrameDisplayView(String str) {
        //Creates a new, initially invisible Frame with the specified title.
        super(str);

        setLayout(new FlowLayout());

        button_01 = new JButton("1");
        button_02 = new JButton("2");

        add(button_01);
        add(button_02);

        button_01.addActionListener(evHandlerController);
        button_02.addActionListener(evHandlerController);


    }

}

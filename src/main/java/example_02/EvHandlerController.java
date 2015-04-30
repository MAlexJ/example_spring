package example_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EvHandlerController implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1"))
            System.out.println("111111111111111");

        if (e.getActionCommand().equals("2"))
            System.out.println("222222222222");
    }
}

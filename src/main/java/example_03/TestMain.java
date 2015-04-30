package example_03;

import javax.swing.*;

/**
 * Created by alex on 01.05.15.
 */
public class TestMain {
    public static void main(String[] args) {
        FrameDisplay frameDisplay = new FrameDisplay("MyCalc");
        frameDisplay.setVisible(true);
        frameDisplay.setSize(200, 200);
        frameDisplay.setLocationRelativeTo(null);
        frameDisplay.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

package example_01;

import javax.swing.*;
import java.awt.*;

public class TestMain {
    public static void main(String[] args) {
        FrameDisplay frameDisplay = new FrameDisplay("MyProgram");
        frameDisplay.setVisible(true);
        frameDisplay.setSize(200, 150);
        frameDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDisplay.setBackground(Color.lightGray);
        frameDisplay.setLocationRelativeTo(null);
    }
}

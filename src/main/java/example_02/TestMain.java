package example_02;


import javax.swing.*;

public class TestMain {
    public static void main(String[] args) {
        FrameDisplayView frameDisplayView = new FrameDisplayView("MyProgramm_01");
        frameDisplayView.setVisible(true);
        frameDisplayView.setSize(200, 150);
        frameDisplayView.setLocationRelativeTo(null);
        frameDisplayView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

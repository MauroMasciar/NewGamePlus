package test;

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class test extends JFrame {
    public test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        pack();
        setVisible(true);
    }
}
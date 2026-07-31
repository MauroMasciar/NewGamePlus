package com.masciar.ui.gameinfo;

import com.masciar.util.Utils;

import javax.swing.JPanel;
import java.awt.Color;

public class Image extends JPanel {
    public Image() {
        setBackground(Color.decode(Utils.COLOR_BACKGROUND));
        JPanel pnlImage = new JPanel();
        pnlImage.setBackground(Color.RED);
        add(pnlImage);
    }
}

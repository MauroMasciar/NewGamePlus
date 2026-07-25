package com.masciar.util;

import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

public class RoundedBorder extends AbstractBorder {
    private final int radius;
    private final Color color;
    private int insets1, insets2, insets3, insets4;

    public RoundedBorder(int radius, Color color, int insets1, int insets2, int insets3, int insets4) {
        this.radius = radius;
        this.color = color;
        this.insets1 = insets1;
        this.insets2 = insets2;
        this.insets3 = insets3;
        this.insets4 = insets4;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(insets1, insets2, insets3, insets4);
    }
}
package io.github.lightrailpassenger.mousebot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JToggleButton;

class Switch extends JToggleButton {
    private static final int TOGGLE_MARGIN = 2;
    private static final int SWITCH_WIDTH = 55;
    private static final int SWITCH_HEIGHT = 30;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SWITCH_WIDTH, SWITCH_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        boolean isSelected = this.isSelected();

        if (isSelected) {
            g2d.setColor(new Color(140, 200, 140));
        } else {
            g2d.setColor(Color.WHITE);
        }

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D.Double left = new Ellipse2D.Double(0, 0, SWITCH_HEIGHT, SWITCH_HEIGHT);
        Ellipse2D.Double right = new Ellipse2D.Double(SWITCH_WIDTH - SWITCH_HEIGHT, 0, SWITCH_HEIGHT, SWITCH_HEIGHT);
        Rectangle2D.Double center = new Rectangle2D.Double(SWITCH_HEIGHT / 2d, 0, SWITCH_WIDTH - SWITCH_HEIGHT, SWITCH_HEIGHT);
        Area area = new Area();
        area.add(new Area(left));
        area.add(new Area(right));
        area.add(new Area(center));

        g2d.fill(area);

        g2d.setColor(new Color(200, 200, 200));
        g2d.fill(new Ellipse2D.Double(isSelected ? SWITCH_WIDTH - SWITCH_HEIGHT : TOGGLE_MARGIN, TOGGLE_MARGIN, SWITCH_HEIGHT - 2 * TOGGLE_MARGIN, SWITCH_HEIGHT - 2 * TOGGLE_MARGIN));
    }

    void addActionListenerToSwitch(ActionListener listener) {
        this.addActionListener(listener);
    }
}

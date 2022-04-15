package io.github.lightrailpassenger.mousebot;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

class MouseBotPanel extends JPanel {
    static int MOVEMENT_DEFAULT = 5;
    static int MOVEMENT_MIN = 0;
    static int MOVEMENT_MAX = 20;
    static int MOVEMENT_STEP = 1;
    static int INTERVAL_DEFAULT = 5;
    static int INTERVAL_MIN = 0;
    static int INTERVAL_MAX = 60;
    static int INTERVAL_STEP = 1;

    MouseBotPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.initialize();
    }

    private static Border createPanelComponentBorder(String title) {
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border titledBorder = BorderFactory.createTitledBorder(lineBorder, title);

        return titledBorder;
    }

    private void initialize() {
        JSpinner movementSpinner = new JSpinner(
            new SpinnerNumberModel(MOVEMENT_DEFAULT, MOVEMENT_MIN, MOVEMENT_MAX, MOVEMENT_STEP)
        );
        JSpinner intervalSpinner = new JSpinner(
            new SpinnerNumberModel(INTERVAL_DEFAULT, INTERVAL_MIN, INTERVAL_MAX, INTERVAL_STEP)
        );

        JPanel movementPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel intervalPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        movementPanel.setBorder(MouseBotPanel.createPanelComponentBorder("Movement"));
        intervalPanel.setBorder(MouseBotPanel.createPanelComponentBorder("Interval"));

        movementPanel.add(movementSpinner);
        intervalPanel.add(intervalSpinner);

        this.add(movementPanel);
        this.add(intervalPanel);
        this.add(new Switch());
    }
}

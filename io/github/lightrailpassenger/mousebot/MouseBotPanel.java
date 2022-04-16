package io.github.lightrailpassenger.mousebot;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

class MouseBotPanel extends JPanel implements ActionListener {
    static int MOVEMENT_DEFAULT = 5;
    static int MOVEMENT_MIN = 0;
    static int MOVEMENT_MAX = 20;
    static int MOVEMENT_STEP = 1;
    static int INTERVAL_DEFAULT = 5;
    static int INTERVAL_MIN = 0;
    static int INTERVAL_MAX = 60;
    static int INTERVAL_STEP = 1;

    private JSpinner movementSpinner, intervalSpinner;
    private CursorManager cursorManager;

    MouseBotPanel(CursorManager cursorManager) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.cursorManager = cursorManager;
        this.initialize();
    }

    private static Border createPanelComponentBorder(String title) {
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border titledBorder = BorderFactory.createTitledBorder(lineBorder, title);

        return titledBorder;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        JCheckBox checkbox = (JCheckBox)(ev.getSource());
        boolean isEnabled = checkbox.isSelected();

        if (isEnabled) {
            this.cursorManager.setMovement(
                new CursorManager.CursorMovementOptions(
                    (int)(this.intervalSpinner.getValue()),
                    (int)(this.movementSpinner.getValue())
                )
            );
        } else {
            this.cursorManager.setMovement(null);
        }
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

        this.movementSpinner = movementSpinner;
        this.intervalSpinner = intervalSpinner;

        this.add(movementPanel);
        this.add(intervalPanel);

        Switch switchButton = new Switch();
        this.add(switchButton);

        switchButton.addActionListenerToSwitch(this);
    }
}

package io.github.lightrailpassenger.mousebot;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

class Switch extends JPanel {
    private JCheckBox checkbox;

    Switch() {
        super(new FlowLayout());
        this.checkbox = new JCheckBox("Enabled", false);
        this.add(this.checkbox);
    }

    void addActionListenerToSwitch(ActionListener listener) {
        this.checkbox.addActionListener(listener);
    }
}

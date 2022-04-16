package io.github.lightrailpassenger.mousebot;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MouseBot {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        CursorManager cursorManager = new CursorManager(robot);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MouseBot");
            frame.setLayout(new BorderLayout());
            frame.add(new MouseBotPanel(cursorManager), BorderLayout.CENTER);

            frame.setMinimumSize(new Dimension(200, 0));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

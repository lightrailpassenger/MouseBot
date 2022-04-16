package io.github.lightrailpassenger.mousebot;

import java.awt.DisplayMode;
import java.awt.PointerInfo;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.TimerTask;

class DefaultMovementTimerTask extends TimerTask {
    private final Robot robot;
    private final int movement;

    DefaultMovementTimerTask(Robot robot, int movement) {
        this.robot = robot;
        this.movement = movement;
    }

    @Override
    public void run() {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point cursorLocation = pointerInfo.getLocation();
        DisplayMode displayMode = pointerInfo.getDevice().getDisplayMode();
        int displayWidth = displayMode.getWidth();
        int displayHeight = displayMode.getHeight();
        int cursorX = cursorLocation.x;
        int cursorY = cursorLocation.y;

        this.robot.mouseMove(cursorX + movement, cursorY);
    }
}

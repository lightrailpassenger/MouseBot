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

    private boolean isLeft = false;

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
        int cursorX = cursorLocation.x;
        int cursorY = cursorLocation.y;

        if (!this.isLeft && cursorX + this.movement >= displayWidth) {
            this.isLeft = true;
        } else if (this.isLeft && cursorX - this.movement <= 0) {
            this.isLeft = false;
        }

        this.robot.mouseMove(cursorX + this.movement * (this.isLeft ? -1 : 1), cursorY);
    }
}

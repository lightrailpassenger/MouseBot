package io.github.lightrailpassenger.mousebot;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;

class CursorManager {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private final Robot robot;
    private Timer timer;

    CursorManager(Robot robot) {
        this.robot = robot;
    }

    static class CursorMovementOptions {
        private int interval;
        private int movement;

        CursorMovementOptions(int interval, int movement) {
            this.interval = interval;
            this.movement = movement;
        }

        int getInterval() {
            return this.interval;
        }

        int getMovement() {
            return this.movement;
        }
    }

    void setMovement(CursorMovementOptions options) {
        if (
            (options != null) != (this.timer != null)
        ) {
            if (options == null) {
                this.timer.cancel();
                this.timer = null;
            } else {
                TimerTask movementTask = new DefaultMovementTimerTask(this.robot, options.getMovement());

                this.timer = new Timer();
                this.timer.scheduleAtFixedRate(movementTask, options.getInterval() * MILLISECONDS_PER_SECOND, options.getInterval() * MILLISECONDS_PER_SECOND);
            }
        }
    }
}

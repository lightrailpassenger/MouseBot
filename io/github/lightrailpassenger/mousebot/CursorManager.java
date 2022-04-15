package io.github.lightrailpassenger.mousebot;

import java.util.Timer;
import java.util.TimerTask;

class CursorManager {
    private MovementTimerTask movementTask;
    private Timer timer;

    CursorManager(MovementTimerTask movementTask) {
        this.movementTask = movementTask;
    }

    static abstract class MovementTimerTask extends TimerTask {
        public abstract void setMovement(int movement);
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
            (options == null) != (this.timer != null)
        ) {
            if (options == null) {
                this.timer.cancel();
                this.timer = null;
            } else {
                this.timer = new Timer();
                this.movementTask.setMovement(options.getMovement());

                this.timer.scheduleAtFixedRate(this.movementTask, options.getInterval(), options.getInterval());
            }
        }
    }
}

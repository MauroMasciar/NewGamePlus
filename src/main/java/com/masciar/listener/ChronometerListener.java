package com.masciar.listener;

public interface ChronometerListener {
    void timeUpdate(int secondsPlayed, int secondsPaused);
    void notifyMinuteElapsed(int seconds);
}

package com.masciar.service;

import javax.swing.Timer;

import com.masciar.listener.ChronometerListener;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ChronometerService {
    private ChronometerListener listener;
    private int totalSecondsPlaying;
    private int totalSecondsPaused;
    private int pauseCount;
    private boolean isRunning = true;
    private boolean isPaused = false;
    private Timer t;
    private LocalDateTime playStart;
    private LocalDateTime pauseStart;

    public void start() {
        playStart = LocalDateTime.now();
        t = new Timer(1000, e -> run());
    	t.start();
    }

    private void run() {
        if(isRunning) {
            if(!isPaused) {
                int currentPlaying = (int) ChronoUnit.SECONDS.between(playStart, LocalDateTime.now());
                int totalPlaying = totalSecondsPlaying + currentPlaying;

                notifyTime(totalPlaying, totalSecondsPaused);
            } else {
                int currentPaused = (int) ChronoUnit.SECONDS.between(pauseStart, LocalDateTime.now());
                int totalPaused = totalSecondsPaused + currentPaused;

                notifyTime(totalSecondsPlaying, totalPaused);
            }
        }
    }

    private void notifyTime(int playing_time, int pause_time) {
        if(listener != null) {
            listener.timeUpdate(playing_time, pause_time);
            if(playing_time % 60 == 0 && playing_time != 0 && !isPaused) listener.notifyMinuteElapsed(playing_time);
        }
    }

    public void setListener(ChronometerListener listener) {
        this.listener = listener;
    }

    public void stop() {
        isRunning = false;
        if(t != null) t.stop();
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean p) {
        isPaused = p;
        if(isPaused) {
            pauseStart = LocalDateTime.now();
            totalSecondsPlaying += ChronoUnit.SECONDS.between(playStart, LocalDateTime.now());
            pauseCount++;
        } else {
            playStart = LocalDateTime.now();
            totalSecondsPaused += ChronoUnit.SECONDS.between(pauseStart, LocalDateTime.now());
        }
    }

    public int getTotalSecondsPlaying() {
        return totalSecondsPlaying;
    }

    public int getTotalSecondsPaused() {
        return totalSecondsPaused;
    }

    public int getPauseCount() {
        return pauseCount;
    }
}

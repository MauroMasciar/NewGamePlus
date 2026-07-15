package service;

import javax.swing.Timer;

public class ChronometerService {
    private ChronometerListener listener;
    private int playedSeconds;
    private int pauseSeconds;
    private int pauseCount;
    private boolean pause;

    public void start() {
        Timer t = new Timer(1000, e -> runTime());
    	t.start();
    }

    public void runTime() {
        if(!pause) {
            notifyTime(String.valueOf(pauseSeconds));
            playedSeconds++;
        }
    }

    public void runPause() {
        if(pause) {
            notifyTime(String.valueOf(pauseSeconds));
            pauseSeconds++;
        }
        
    }

    public void pause() {
        if(pause) {
            pause = false;
        } else {
            pause = true;
            pauseCount++;
        }
    }

    public void stop() {
        
    }

    public void notifyTime(String time) {
        if(listener != null) {
            listener.timeUpdate(playedSeconds);
        }
    }

    public void setListener(ChronometerListener listener) {
        this.listener = listener;
    }
}

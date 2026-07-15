package service;

public interface ChronometerListener {
    void timeUpdate(int time);
    void notifyPause();
    void notifyResume();
    void pause();
    void resume();
}

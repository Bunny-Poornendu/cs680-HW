package edu.umb.cs680.hw05;

public interface State {
    public void startButtonPushed();
    public void stopButtonPushed();
    public void motionDetected();
    public void motionNotDetected();
}

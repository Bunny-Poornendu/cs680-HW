package edu.umb.cs680.hw05;

public class Stopped implements State{

    private static Stopped stopped;
    private static Escalator escalator;

    private Stopped(){
        escalator = Escalator.getInstance();
    }

    public static Stopped getInstance() {
        if(stopped == null){
            stopped = new Stopped();
        }
        return stopped;
    }

    @Override
    public void startButtonPushed() {
        escalator.enableSensor();
        escalator.changeState(StandBy.getInstance());
        escalator.enableSensor();
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("No change");
    }

    @Override
    public void motionDetected() {
        System.out.println("No change");
    }

    @Override
    public void motionNotDetected() {
        System.out.println("No change");
    }

    public static void main(String[] args) {

    }
}

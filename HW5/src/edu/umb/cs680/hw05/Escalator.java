package edu.umb.cs680.hw05;

public class Escalator {
    private static State state;
    private static Escalator escalator;

    private Escalator(){}

    public static Escalator getInstance() {
        if(escalator == null){
            escalator = new Escalator();
            state = Stopped.getInstance();
        }
        return escalator;
    }

    public State getState(){
        return state;
    }

    public void changeState(State newState){
        Escalator.state = newState;
    }

    public void startButtonPushed(){
        state.startButtonPushed();
    }

    public void stopButtonPushed(){
        state.stopButtonPushed();
    }

    public void motionDetected(){
        state.motionDetected();
    }
    public void motionNotDetected(){
        state.motionNotDetected();
    }

    public void moveSteps(){
        System.out.println("Start the motion of steps");
    }

    public void stopSteps(){
        System.out.println("Stop the motion of steps");
    }

    public void enableSensor(){
        System.out.println("Steps motion sensor enabled");
    }

    public void disableSensor(){
        System.out.println("Steps motion sensor disabled");
    }

    public static void main(String[] args) {

    }
}

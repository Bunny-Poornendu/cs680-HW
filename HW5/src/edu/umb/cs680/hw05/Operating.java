package edu.umb.cs680.hw05;

public class Operating implements State{

    private static Escalator escalator;
    private static Operating operating;

    private Operating(){
        escalator = Escalator.getInstance();
    }

    public static Operating getInstance() {
        if(operating == null){
            operating = new Operating();
        }
        return operating;
    }

    @Override
    public void startButtonPushed() {
        System.out.println("No change");
    }

    @Override
    public void stopButtonPushed() {
        escalator.stopSteps();
        escalator.disableSensor();
        escalator.changeState(Stopped.getInstance());
    }

    @Override
    public void motionDetected() {
        System.out.printf("Do change");
    }

    @Override
    public void motionNotDetected() {
        escalator.stopSteps();
        escalator.changeState(StandBy.getInstance());
    }

    public static void main(String[] args) {

    }
}

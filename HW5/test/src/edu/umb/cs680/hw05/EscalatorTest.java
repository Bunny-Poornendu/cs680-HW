package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EscalatorTest {
    Escalator escalator = Escalator.getInstance();
    @Test
    public void operatingTest(){
        escalator.motionNotDetected();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.stopButtonPushed();
        actual = escalator.getState();
        expected = Stopped.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.startButtonPushed();
        actual = escalator.getState();
        expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.motionDetected();
        actual = escalator.getState();
        expected = Operating.getInstance();
        Assertions.assertSame(expected, actual);
    }

    @Test
    public void standBy(){
        escalator.changeState(Stopped.getInstance());
        escalator.stopButtonPushed();
        State actual = escalator.getState();
        State expected = Stopped.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.startButtonPushed();
        actual = escalator.getState();
        expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.motionDetected();
        actual = escalator.getState();
        expected = Operating.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.motionNotDetected();
        actual = escalator.getState();
        expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);
    }

    @Test
    public void stoppedTest(){
        escalator.changeState(Stopped.getInstance());
        escalator.startButtonPushed();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.motionDetected();
        actual = escalator.getState();
        expected = Operating.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.motionNotDetected();
        actual = escalator.getState();
        expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);

        escalator.stopButtonPushed();
        actual = escalator.getState();
        expected = Stopped.getInstance();
        Assertions.assertSame(expected, actual);
    }

}

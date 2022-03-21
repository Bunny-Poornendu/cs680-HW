package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SingletonTest {

    @Test
    public void getinstanceforNonNullValue()
    {
        Singleton sin = Singleton.getInstance();
        Assertions.assertNotNull(sin);
    }

    @Test
    public void getinstanceforidenticalinstancesmultipletimes()
    {
        Singleton sin1 = Singleton.getInstance();
        Singleton sin2 = Singleton.getInstance();
        Assertions.assertSame(sin1,sin2);
    }

}

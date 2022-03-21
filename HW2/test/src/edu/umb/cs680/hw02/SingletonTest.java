package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SingletonTest {

    @Test
    public void getinstanceforNonNull()
    {
        Singleton single = Singleton.getInstance();
        Assertions.assertNotNull(single);
    }

    @Test
    public void getidenticalinstancesmultipletimes()
    {
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();
        Assertions.assertSame(single1,single2);
    }

}

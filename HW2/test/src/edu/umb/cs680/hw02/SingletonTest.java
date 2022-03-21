package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw02.Singleton;



public class SingletonTest {

	@Test
	public void getInstanceReturnNonNullValue() {
		assertNotNull(Singleton.getInstance());
	}
	
	@Test
	public void getInstanceReturnIdenticalInstance() {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		assertSame(s1, s2);
	}

}

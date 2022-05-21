package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Chebyshev;

public class ChebyshevTest {

	@Test
	public void verifyChebyshevdistanceWithP1P2() {
		List<Double> p1 = Arrays.asList(1500.0, 30.0, 9.0);
		List<Double> p2 = Arrays.asList(1499.0, 5.0, 6.0);
		double expected = 25;
		double actual = new Chebyshev().distance(p1, p2);
		assertEquals(expected, actual);
	}
}

package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Chebyshev;
import edu.umb.cs680.hw10.Distance;
import edu.umb.cs680.hw10.Euclidean;
import edu.umb.cs680.hw10.Manhattan;

public class DistanceTest {
	private static List<Double> p1, p2, p3, p4, p5;
	private static List<List<Double>> pointsList = new LinkedList<>();

	@BeforeAll
	static void setUp() throws Exception {
		p1 = Arrays.asList(1.0, 3.0, 5.0);
		p2 = Arrays.asList(2.0, 4.0, 6.0);
		p3 = Arrays.asList(8.0, 7.0, 1.0);
		p4 = Arrays.asList(3.0, 1.0, 0.0);
		p5 = Arrays.asList(9.0, 2.0, 7.0);
		pointsList.add(p1);
		pointsList.add(p2);
		pointsList.add(p3);
		pointsList.add(p4);
		pointsList.add(p5);
	}


	@Test
	public void verifyEuclideanDistanceP1P2() {
		double expected = Math.sqrt(3.0);
		double actual = Distance.get(p1, p2, new Euclidean());
		assertEquals(expected, actual);
	}

	@Test
	public void verifyManhattanDistanceP2P3() {
		double expected = 14.0;
		double actual = Distance.get(p2, p3, new Manhattan());
		assertEquals(expected, actual);
	}

	@Test
	public void verifyChebyshevDistanceP1P2() {
		double expected = 1.0;
		double actual = Distance.get(p1, p2, new Chebyshev());
		assertEquals(expected, actual);
	}

	@Test
	public void verifyDistanceMatrix5x5WithEuclidean() {
		Double[][] expected = {
				{ 0.0, Math.sqrt(3.0), 9.0, Math.sqrt(33.0), Math.sqrt(69.0) },
				{ Math.sqrt(3.0), 0.0, Math.sqrt(70.0), Math.sqrt(46.0), Math.sqrt(54.0) },
				{ 9.0, Math.sqrt(70.0), 0.0, Math.sqrt(62.0), Math.sqrt(62.0) },
				{ Math.sqrt(33.0), Math.sqrt(46.0), Math.sqrt(62.0), 0.0, Math.sqrt(86.0) },
				{ Math.sqrt(69.0), Math.sqrt(54.0), Math.sqrt(62.0), Math.sqrt(86.0), 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Euclidean());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
	
	@Test
	public void verifyDistanceMatrix5x5WithManhattan() {
		Double[][] expected = { { 0.0, 3.0, 15.0, 9.0, 11.0 },
								{ 3.0, 0.0, 14.0, 10.0, 10.0 },
								{ 15.0, 14.0, 0.0, 12.0, 12.0 },
								{ 9.0, 10.0, 12.0, 0.0, 14.0 },
								{ 11.0, 10.0, 12.0, 14.0, 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Manhattan());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
	


}

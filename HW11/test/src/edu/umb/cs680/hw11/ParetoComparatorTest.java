package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.ParetoComparator;

public class ParetoComparatorTest {
	private static Car car1;
	private static Car car2;
	private static Car car3;
	private static LinkedList<Car> usedCars;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		usedCars = new LinkedList<>();
		car1 = new Car("Toyota", "Supra", 80, 2015, 50000.0f);
		car2 = new Car("Audi", "A6", 90, 2014, 60000.0f);
		car3 = new Car("Kia", "Seltos", 70, 2016, 40000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
	}
	
	@Test
	public void verifyCar1dominationCount() {
		int expected = 1;
		car1.setDominationCount(usedCars);
		int actual = car1.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyCar2dominationCount() {
		int expected = 2;
		car2.setDominationCount(usedCars);
		int actual = car2.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyCar3dominationCount() {
		int expected = 0;
		car3.setDominationCount(usedCars);
		int actual = car3.getDominationCount();
		assertEquals(expected, actual);
	}

	@Test
	public void verifyAscendingSortFordominationCount() {
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car1);
		expected.add(car2);
		car1.setDominationCount(usedCars);
		car2.setDominationCount(usedCars);
		car3.setDominationCount(usedCars);
		Collections.sort(usedCars, new ParetoComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

}

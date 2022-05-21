package edu.umb.cs680.hw11;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.PriceComparator;

public class PriceComparatorTest {

	@Test
	public void priceAscendingSortTest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car car1 = new Car("Toyota", "Supra", 80, 2015, 50000.0f);
		Car car2 = new Car("Audi", "A6", 90, 2014, 60000.0f);
		Car car3 = new Car("Kia", "Seltos", 70, 2016, 40000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car1);
		expected.add(car2);
		Collections.sort(usedCars, new PriceComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}
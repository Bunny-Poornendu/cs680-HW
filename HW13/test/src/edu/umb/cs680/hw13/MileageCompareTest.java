package edu.umb.cs680.hw13;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Car;

public class MileageCompareTest {
	static LinkedList<Car> usedCars = new LinkedList<Car>();
	static Car car1;
	static Car car2;
	static Car car3;

	@Test
	public void verifymileageAscendingSort() {

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
		Collections.sort(usedCars, Comparator.comparing(car -> car.getMileage()));
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}

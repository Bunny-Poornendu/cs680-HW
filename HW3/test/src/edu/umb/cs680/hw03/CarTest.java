package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    private String[] carToStringArray(Car car) {
        String[] carInfo = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
        return carInfo;
    }
    
    @Test
    void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Audi", "RS", 2021};
        Car actual = new Car("Audi", "RS", 2021, 10, 70000);
        assertArrayEquals(expected, carToStringArray(actual) );
    }

    @Test
    public void VerificationOfTwoCarInstancesWithMakeModelYear()
    {
        Car s1 = new Car("Audi","RS",2021,10,70000);
        Car s2 = new Car("Audi","RS",2021,10,70000);

        assertArrayEquals(carToStringArray(s1),carToStringArray(s2));
    }


}

package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void Primegeneratorfrom1to10()
    {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void Primegeneratorfrom10to1runtimeexception()
    {
        try {
            PrimeGenerator PG = new PrimeGenerator(10,1);
        }
        catch (RuntimeException exception) {
            assertEquals("Wrong input values: from=10 to=1", exception.getMessage());
        }

    }
    @Test
    public void primeGenerator40to50() {
        PrimeGenerator gen = new PrimeGenerator(40, 50);
        gen.generatePrimes();
        Long[] expectedPrimes = {41L, 43L, 47L};
        assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
    }
    @Test
    public void Primegeneratorfrom20to30()
    {
        PrimeGenerator gen = new PrimeGenerator(20, 30);
        gen.generatePrimes();
        Long[] expectedPrimes = {23L, 29L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void Primegeneratorfrom100to1runtimeexception()
    {
        try {
            PrimeGenerator PG = new PrimeGenerator(100,1);
        }
        catch (RuntimeException exception) {
            assertEquals("Wrong input values: from=100 to=1", exception.getMessage());
        }

    }


}

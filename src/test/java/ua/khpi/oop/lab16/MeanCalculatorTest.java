package ua.khpi.oop.lab16;

import ua.khpi.oop.lab16.main.MeanCalculator;
import ua.khpi.oop.lab16.main.NativeMeanCalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeanCalculatorTest {

    private final MeanCalculator javaCalc = new MeanCalculator();
    private static NativeMeanCalculator nativeCalc;

    @BeforeAll
    static void setUp() {
        nativeCalc = new NativeMeanCalculator();
    }

    @Test
    void javaImplementationCalculatesMean() {
        int[] data = {10, 20, 30, 40};
        assertEquals(25.0, javaCalc.calculateMean(data), 0.001);
    }

    @Test
    void nativeImplementationCalculatesMean() {
        int[] data = {10, 20, 30, 40};
        assertEquals(25.0, nativeCalc.calculateMean(data), 0.001);
    }

    @Test
    void javaAndNativeResultsAreEqual() {
        int[][] cases = {
                {1, 2, 3, 4, 5},
                {0, 0, 0},
                {-10, 50, -20, 100},
                {42}
        };

        for (int[] testCase : cases) {
            double javaResult = javaCalc.calculateMean(testCase);
            double nativeResult = nativeCalc.calculateMean(testCase);
            assertEquals(javaResult, nativeResult, 0.001, "Результати розбігаються!");
        }
    }

    @Test
    void testBoundaryCases() {
        int[] emptyArray = {};
        assertEquals(0.0, javaCalc.calculateMean(emptyArray));
        assertEquals(0.0, nativeCalc.calculateMean(emptyArray));

        assertEquals(0.0, javaCalc.calculateMean(null));
        assertEquals(0.0, nativeCalc.calculateMean(null));
    }
}
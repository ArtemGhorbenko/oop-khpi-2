package ua.khpi.oop.lab16.main;

public class MeanCalculator {
    public double calculateMean(int[] array) {
        if (array == null || array.length == 0) {
            return 0.0;
        }
        long sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
}
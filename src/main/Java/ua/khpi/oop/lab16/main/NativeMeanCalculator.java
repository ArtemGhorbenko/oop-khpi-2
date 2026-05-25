package ua.khpi.oop.lab16.main;

public class NativeMeanCalculator {
    static {
        System.loadLibrary("nativecalc");
    }

    public native double calculateMean(int[] array);
}
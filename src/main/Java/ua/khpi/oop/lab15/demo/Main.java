package ua.khpi.oop.lab15.demo;

import ua.khpi.oop.lab15.model.HotelRoom;
import ua.khpi.oop.lab15.threads.BookingTask;

public class Main {
    private static final int THREADS = 4;
    private static final int ITERATIONS_PER_THREAD = 100_000;
    private static final int TOTAL_CAPACITY = 1_000_000;

    public static void main(String[] args) {
        System.out.println(" Lab 15: Синхронізація потоків (Бронювання номерів) \n");

        System.out.println("Очікувана кількість бронювань: " + (THREADS * ITERATIONS_PER_THREAD));

        HotelRoom unsafeRoom = new HotelRoom("UNSAFE-101", TOTAL_CAPACITY);
        long unsafeTime = runScenario(unsafeRoom, false);

        System.out.println("\n Результат БЕЗ синхронізації ");
        System.out.println(unsafeRoom);
        System.out.println("Втрачено бронювань: " + ((THREADS * ITERATIONS_PER_THREAD) - unsafeRoom.getBookedSeats()));
        System.out.println("Час виконання: " + unsafeTime + " мс");

        HotelRoom safeRoom = new HotelRoom("SAFE-202", TOTAL_CAPACITY);
        long safeTime = runScenario(safeRoom, true);

        System.out.println("\n Результат ІЗ синхронізацією ");
        System.out.println(safeRoom);
        System.out.println("Втрачено бронювань: " + ((THREADS * ITERATIONS_PER_THREAD) - safeRoom.getBookedSeats()));
        System.out.println("Час виконання: " + safeTime + " мс");

        System.out.println("\nВисновок: Синхронізований варіант гарантує цілісність даних, але має додаткові накладні витрати часу на блокування монітора.");
    }

    private static long runScenario(HotelRoom room, boolean useSafeMethod) {
        Thread[] threads = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(new BookingTask(room, ITERATIONS_PER_THREAD, useSafeMethod));
        }

        long startTime = System.nanoTime();

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
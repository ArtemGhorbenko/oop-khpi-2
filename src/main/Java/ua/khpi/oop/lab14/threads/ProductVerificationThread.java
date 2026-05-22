package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.model.Product;
import java.util.List;

public class ProductVerificationThread extends Thread {
    private final List<Product> products;

    public ProductVerificationThread(List<Product> products) {
        this.products = products;
        setName("Product-Verifier-Thread");
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Початок перевірки описів товарів...");
        for (Product product : products) {
            try {
                Thread.sleep(500);
                product.setVerified(true);
                System.out.println("[" + getName() + "] Перевірено: " + product.getName());
            } catch (InterruptedException e) {
                System.out.println("[" + getName() + "] Роботу потоку перервано");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("[" + getName() + "] Перевірку товарів завершено.");
    }
}
package pl.skrzypekjan.springbootshop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class Basket {

    private List<Product> productList;

    public Basket() {
        Product product1 = new Product("Kurs Java", new BigDecimal(Math.floor(Math.random() * 300 + 50)));
        Product product2 = new Product("Kurs Spring", new BigDecimal(Math.floor(Math.random() * 300 + 50)));
        Product product3 = new Product("Kurs SQL", new BigDecimal(Math.floor(Math.random() * 300 + 50)));
        Product product4 = new Product("Kurs Hibernate", new BigDecimal(Math.floor(Math.random() * 300 + 50)));
        Product product5 = new Product("Kurs Security", new BigDecimal(Math.floor(Math.random() * 300 + 50)));
        Product product6 = new Product("Kurs Angular", new BigDecimal(Math.floor(Math.random() * 300 + 50)));

        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void showProducts(){
        System.out.println(productList);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getAllPrices() {
        BigDecimal result = productList.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Suma " + result);
    }

    public List<Product> getProduct() {
        return productList;
    }
}

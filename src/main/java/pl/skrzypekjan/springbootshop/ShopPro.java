package pl.skrzypekjan.springbootshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Profile("Pro")
public class ShopPro {
    Basket basket;

    @Autowired
    public ShopPro(Basket basket) {
        this.basket = basket;
    }

    @Value("${shop-info.vat}")
    private BigDecimal vat;

    @Value("${shop-info.discount}")
    private BigDecimal discount;

    @EventListener(ApplicationReadyEvent.class)
    public void addVat() {
        System.out.println("ShopPro");
        basket.getProduct().forEach(Products -> Products.setPrice(Products.getPrice().multiply(vat).multiply(discount)));
    }
}

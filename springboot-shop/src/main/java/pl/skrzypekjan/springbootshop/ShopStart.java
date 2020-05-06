package pl.skrzypekjan.springbootshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Start")
public class ShopStart {
    Basket basket;

    @Autowired
    public ShopStart(Basket basket) {
        this.basket = basket;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void showProducts(){
        System.out.println("ShopStart");
    }
}

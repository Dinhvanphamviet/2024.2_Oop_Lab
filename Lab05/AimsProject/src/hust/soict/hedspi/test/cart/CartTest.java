package hust.soict.hedspi.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.exception.PlayerException; // Thêm import

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dv1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
        } catch (LimitExceededException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return; 
        }

        cart.printCart();
        cart.sortMediaByTitle();
        cart.printCart();
        cart.sortMediaByCost();
        cart.printCart();

        cart.searchByID(1);
        cart.searchByTitle("The Lion King");
    }
}
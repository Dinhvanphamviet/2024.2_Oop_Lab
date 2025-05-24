package hust.soict.hedspi.test.screen.customer.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.LimitExceededException;

public class TestViewCartScreen extends Application {
    public static Cart cart;
    private Store store;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
        CartController viewCartController = new CartController(cart,store);
        fxmlLoader.setController(viewCartController);
        Parent root = fxmlLoader.load();

        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
        stage.show();

    }
    public static void main(String[] args) throws LimitExceededException {
        cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 22.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon-ho", 132, 17.8f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 20.0f);

        hust.soict.hedspi.aims.media.CompactDisc cd1 = new hust.soict.hedspi.aims.media.CompactDisc("Thriller", "Pop", "Michael Jackson", 42, 13.0f, "Eric");
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Thriller", 6));
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Beat It", 4));
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Billie Jean", 5));

        hust.soict.hedspi.aims.media.Book book1 =new hust.soict.hedspi.aims.media.Book("The Pragmatic Programmer", "Programming", 30.0f);


        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(cd1);
        cart.addMedia(book1);

        launch(args);
    }

}
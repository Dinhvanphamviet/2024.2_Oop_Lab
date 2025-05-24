package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        stage.setTitle("Store");
        stage.setScene(new Scene(root));
        stage.show();

    }
    
    
    public static void main(String[] args) {
        store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 20.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon-ho", 132, 17.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony & Joe Russo", 181, 22.0f);

        hust.soict.hedspi.aims.media.CompactDisc cd1 = new hust.soict.hedspi.aims.media.CompactDisc("Thriller", "Pop", "Michael Jackson", 42, 13.0f, "Eric");
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Thriller", 6));
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Beat It", 4));
        cd1.addTrack(new hust.soict.hedspi.aims.media.Track("Billie Jean", 5));
        
        hust.soict.hedspi.aims.media.CompactDisc cd2 = new hust.soict.hedspi.aims.media.CompactDisc("Back in Black", "Rock", "AC/DC", 42, 15.0f, "Brian");
        cd2.addTrack(new hust.soict.hedspi.aims.media.Track("Hells Bells", 5));
        cd2.addTrack(new hust.soict.hedspi.aims.media.Track("Shoot to Thrill", 5));
        cd2.addTrack(new hust.soict.hedspi.aims.media.Track("Back in Black", 4));

        hust.soict.hedspi.aims.media.CompactDisc cd3 = new hust.soict.hedspi.aims.media.CompactDisc("21", "Pop", "Adele", 48, 14.0f, "Paul");
        cd3.addTrack(new hust.soict.hedspi.aims.media.Track("Rolling in the Deep", 4));
        cd3.addTrack(new hust.soict.hedspi.aims.media.Track("Someone Like You", 5));
        cd3.addTrack(new hust.soict.hedspi.aims.media.Track("Set Fire to the Rain", 4));

        hust.soict.hedspi.aims.media.CompactDisc cd4 = new hust.soict.hedspi.aims.media.CompactDisc("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 43, 20.0f, "David");
        cd4.addTrack(new hust.soict.hedspi.aims.media.Track("Speak to Me", 1));
        cd4.addTrack(new hust.soict.hedspi.aims.media.Track("Time", 7));
        cd4.addTrack(new hust.soict.hedspi.aims.media.Track("Money", 6));


        Book book1 = new Book("Harry Potter", "Fantasy", 25.88f);
        Book book2 = new Book("The Hobbit", "Fantasy", 20.50f);
        Book book3 = new Book("To Kill a Mockingbird", "Classic", 18.75f);


        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);


        launch(args);
    }


    
}

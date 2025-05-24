package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import javax.naming.LimitExceededException;

public class ItemController {

    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnPlay;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddtoCartClicked(ActionEvent event) throws LimitExceededException {
        cart.addMedia(media);
    }
    
    private void showPlayingDialog(String title, int length, String director, String category) {
        Dialog<ButtonType> dialog = new Dialog<>();
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setHeaderText("Playing: " + title);
        dialogPane.setContentText("Media is now playing...");

        Label details = new Label(
            "Length: " + length + " minutes\n" +
            "Director: " + director + "\n" +
            "Category: " + category
        );
        dialogPane.setExpandableContent(details);

        dialogPane.getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }
   
    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            if (media instanceof DigitalVideoDisc dvd) {
                dvd.play();
                showPlayingDialog(dvd.getTitle(), dvd.getLength(), dvd.getDirector(), dvd.getCategory());

            } else if (media instanceof CompactDisc cd) {
                cd.play();
                showPlayingDialog(cd.getTitle(), cd.getLength(), cd.getDirector(), cd.getCategory());
            }
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Playback Error");
            alert.setHeaderText("Cannot play media");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    public void setData(Media media){
        this.media = media;

        if (lblTitle != null) {
            lblTitle.setText(media.getTitle());
        }

        if (lblCost != null) {
            lblCost.setText(media.getCost() + " $");
        }

        if (btnPlay != null) {
            btnPlay.setVisible(media instanceof Playable);

            if (!(media instanceof Playable) && btnAddToCart != null) {
                HBox.setMargin(btnAddToCart, new Insets(0,0,0,100));
            }
        }
    }
}
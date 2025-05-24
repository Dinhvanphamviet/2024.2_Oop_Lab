package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    private final Store store;
    private final Cart cart;
    private FilteredList<Media> filteredMediaList;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private TextField tfFilter;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private Label costLabel;
    @FXML private ToggleGroup filterGroup;
    @FXML private TableView<Media> tblMedia;

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredMediaList = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()));
        tblMedia.setItems(filteredMediaList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty()
            .addListener((observable, oldValue, newValue) -> updateButtonBar(newValue));

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));

        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) showFilteredMedia(tfFilter.getText());
        });

        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) showFilteredMedia(tfFilter.getText());
        });

        updateCostLabel();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable playableMedia) {
            if (media instanceof DigitalVideoDisc dvd) {
                dvd.play();
                showPlayDialog(dvd.getTitle(), dvd.getLength(), dvd.getDirector(), dvd.getCategory());
            } else if (media instanceof CompactDisc cd) {
                cd.play();
                showPlayDialog(cd.getTitle(), cd.getLength(), cd.getDirector(), cd.getCategory());
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateCostLabel();

            filteredMediaList = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()));
            tblMedia.setItems(filteredMediaList);

            showFilteredMedia(tfFilter.getText());
        }
    }

    @FXML
    void viewStorebtnPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.FXML"));
            loader.setController(new ViewStoreController(store, cart));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void placeOrderbtnPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Empty Cart", "Your cart is empty. Please add items before placing an order.");
        } else {
            cart.empty();
            updateCostLabel();

            filteredMediaList = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()));
            tblMedia.setItems(filteredMediaList);

            showFilteredMedia(tfFilter.getText());

            showAlert(Alert.AlertType.INFORMATION, "Order Placed", "Your order has been successfully placed!");
        }
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    void updateCostLabel() {
        float totalCost = 0;
        for (Media media : cart.getItemsOrdered()) {
            totalCost += media.getCost();
        }
        costLabel.setText(totalCost + "$");
    }

    void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredMediaList.setPredicate(media -> true);
            return;
        }

        if (radioBtnFilterId.isSelected()) {
            filteredMediaList.setPredicate(media -> String.valueOf(media.getId()).contains(filter));
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredMediaList.setPredicate(media -> media.getTitle().toLowerCase().contains(filter.toLowerCase()));
        } else {
            filteredMediaList.setPredicate(media -> true);
        }
    }

    private void showPlayDialog(String title, int length, String director, String category) {
        Dialog<ButtonType> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();

        dialogPane.setHeaderText("Playing: " + title);
        dialogPane.setContentText("Media is now playing...");

        Label details = new Label(
            "Length: " + length + " minutes\n"
            + "Director: " + director + "\n"
            + "Category: " + category
        );

        dialogPane.setExpandableContent(details);
        dialogPane.getButtonTypes().add(new ButtonType("Close", ButtonBar.ButtonData.OK_DONE));

        dialog.setDialogPane(dialogPane);
        dialog.showAndWait();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }

    @Override
    protected JPanel createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        panel.add(new JLabel("Title:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Category:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Cost:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Authors :"));
        panel.add(new JTextField());

        panel.add(new JLabel());
        panel.add(new JButton("Add Book"));

        return panel;
    }
    
    public static void main(String[] args) {
        Store store = new Store(); 
        new AddBookToStoreScreen(store);
    }

}

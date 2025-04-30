package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }

    @Override
    protected JPanel createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JLabel authorsLabel = new JLabel("Authors:");
        JTextField authorsField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String[] authorsArray = authorsField.getText().split(",");
            ArrayList<String> authors = new ArrayList<>();
            for (String author : authorsArray) {
                authors.add(author.trim());
            }

            Book book = new Book(title, category, cost);
            for (String author : authors) {
                book.addAuthor(author);
            }

            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
        });

        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(costLabel);
        panel.add(costField);

        panel.add(authorsLabel);
        panel.add(authorsField);

        panel.add(new JLabel()); // empty cell
        panel.add(addButton);

        return panel;
    }

    public static void main(String[] args) {
        Store store = new Store(); 
        new AddBookToStoreScreen(store);
    }
}

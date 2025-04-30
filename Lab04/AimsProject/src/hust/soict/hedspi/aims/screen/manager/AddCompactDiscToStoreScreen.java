package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc; // Đảm bảo bạn có lớp CompactDisc
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
    }

    @Override
    protected JPanel createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                String artist = artistField.getText();
                float cost = Float.parseFloat(costField.getText()); 
                CompactDisc cd = new CompactDisc(title, category, artist, cost);

                store.addMedia(cd);

                JOptionPane.showMessageDialog(this, "CD added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format for cost.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(titleLabel); panel.add(titleField);
        panel.add(categoryLabel); panel.add(categoryField);
        panel.add(artistLabel); panel.add(artistField);
        panel.add(costLabel); panel.add(costField);
        panel.add(new JLabel()); panel.add(addButton);

        return panel;
    }

    public static void main(String[] args) {
        Store store = new Store();
        new AddCompactDiscToStoreScreen(store);
    }
}

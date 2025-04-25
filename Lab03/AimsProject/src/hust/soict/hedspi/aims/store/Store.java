package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS = 100;

    private ArrayList<Media> itemsInStore = new ArrayList<Media>(); // Sử dụng ArrayList<Media> thay cho mảng

    // Phương thức thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more items.");
        }
    }

    // Phương thức xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Item not found in store.");
        }
    }

    // Phương thức in ra các mặt hàng trong cửa hàng
    public void printStore() {
        System.out.println("************* STORE *************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
        System.out.println("*********************************");
    }
    
    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

}

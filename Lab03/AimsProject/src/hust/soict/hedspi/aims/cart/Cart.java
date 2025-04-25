package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;  

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();  // Sử dụng ArrayList<Media>

    // Thêm Media vào giỏ hàng
    public int addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been added!");
            return 1;
        } else {
            System.out.println("The cart is full. Can't add more items.");
            return 0;
        }
    }

    // Thêm danh sách Media vào giỏ hàng
    public int addMedia(ArrayList<Media> mediaList) {
        int added = 0;
        for (Media media : mediaList) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println("The item \"" + media.getTitle() + "\" has been added!");
                added++;
            } else {
                System.out.println("The cart is full. Can't add more items.");
                break;
            }
        }
        return added;
    }

    // Xóa Media khỏi giỏ hàng
    public int removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed item \"" + media.getTitle() + "\" successfully!");
            return 1;
        } else {
            System.out.println("No matching item found!");
            return 0;
        }
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float sum = 0.0f;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    // In danh sách giỏ hàng
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }

    // Tìm kiếm theo ID
    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found item: " + media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID = " + id);
        }
    }

    // Tìm kiếm theo tên
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Matched item: " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found matching title: \"" + title + "\"");
        }
    }
    
    public void empty() {
        if (itemsOrdered.size() == 0) {
            System.out.println("Nothing to remove!");
        } else {
            itemsOrdered.clear();  // Xóa tất cả các item trong giỏ
            System.out.println("Order created.");
            System.out.println("Now your current cart will be empty!");
        }
    }

    // Sắp xếp theo tiêu đề rồi đến giá
    public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("== Danh sách sau khi sắp xếp theo tiêu đề -> giá ==");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
    }

    // Sắp xếp theo giá rồi đến tiêu đề
    public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("== Danh sách sau khi sắp xếp theo giá -> tiêu đề ==");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
    }
    
    // Search to remove
    public Media searchToRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
    
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}

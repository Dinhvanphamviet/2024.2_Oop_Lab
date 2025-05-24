package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

 // Constructor 
    public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    // Phương thức thêm tác giả
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    // Phương thức xóa tác giả
    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    // Getter cho danh sách tác giả
    public ArrayList<String> getAuthors() {
        return authors;
    }

    // Hiển thị thông tin của sách
    @Override
    public String toString() {
        return this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }
    
    @Override
    public int compareTo(Media other) {
        if (other instanceof Book) {
            Book otherBook = (Book) other;
            return this.getTitle().compareTo(otherBook.getTitle());  
        }
        return 0;  
    }

    // Phương thức main để chạy thử chương trình
    public static void main(String[] args) {
        // Tạo một đối tượng Book để kiểm tra
        Book book1 = new Book("Java Programming", "Education", 29.99f);
        
        // Thêm tác giả
        book1.addAuthor("Hello1");
        book1.addAuthor("Hello2");
        
        // Hiển thị thông tin sách
        System.out.println(book1);
        
        // Xóa tác giả và hiển thị lại thông tin
        book1.removeAuthor("Hello1");
        System.out.println(book1);
    }

}

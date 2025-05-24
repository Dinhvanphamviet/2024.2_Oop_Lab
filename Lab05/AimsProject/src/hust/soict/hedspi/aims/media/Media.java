package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.exception.PlayerException;

public abstract class Media implements Comparable<Media> {

    // Comparators để sort theo yêu cầu đề bài
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor 
    public Media(String title) {
        this.title = title;
        this.id = ++nbMedia;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }
    
    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    // Phương thức kiểm tra sự khớp với tiêu đề
    public boolean isMatch(String title) {
        return this.title != null && this.title.equalsIgnoreCase(title);
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;

        Media other = (Media) obj;

        if (this.title == null) {
            if (other.title != null) return false;
        } else if (!this.title.equals(other.title)) {
            return false;
        }

        return Float.compare(this.cost, other.cost) == 0;
    }

    // Override toString() method
    @Override
    public String toString() {
        return String.format("ID: %d - Title: %s - Category: %s - Cost: %.2f $", 
            id, title, category, cost);
    }
    
    // Implement compareTo() method
    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Compared media is null");

        if (this.title == null && other.title == null) {
            return Float.compare(this.cost, other.cost);
        }
        if (this.title == null) return -1;
        if (other.title == null) return 1;

        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }

        return Float.compare(this.cost, other.cost);
    }

    public void play() throws PlayerException {
    }
}

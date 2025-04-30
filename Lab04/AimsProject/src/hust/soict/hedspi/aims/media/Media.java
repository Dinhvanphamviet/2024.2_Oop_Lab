package hust.soict.hedspi.aims.media;
import java.util.Comparator;

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
    
    public void play() {
        System.out.println("Playing media");
    }

    // Phương thức kiểm tra sự khớp với tiêu đề
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return title != null && title.equals(media.title);
    }

    // Override toString() method
    @Override
    public String toString() {
        return String.format("ID: %d - Title: %s - Category: %s - Cost: %.2f $", 
            id, title, category, cost);
    }
    
 // Answer for the second question
    @Override
    public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Double.compare(this.getCost(), other.getCost());
        }
    }
}

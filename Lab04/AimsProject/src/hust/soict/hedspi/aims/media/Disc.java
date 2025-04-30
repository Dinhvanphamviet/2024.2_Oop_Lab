package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

 // Constructor 
    public Disc(String title) {
        super(title);
    }
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("%s - Director: %s - Length: %d min",
            super.toString(),
            director != null ? director : "Unknown",
            length
        );
    }
    
    @Override
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            
            // Compare by title
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison != 0) {
                return titleComparison;  
            } else {
                // If titles are the same, compare by length (decreasing order)
                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
                if (lengthComparison != 0) {
                    return lengthComparison;  
                } else {
                    // If titles and lengths are the same, compare by cost
                    return Double.compare(this.getCost(), otherDVD.getCost());
                }
            }
        } else {
            // If the other object is not a Disc, use the default method from Media
            return super.compareTo(other);
        }
    }


}

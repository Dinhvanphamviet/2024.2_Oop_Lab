package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // So sánh 2 track
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Nếu là cùng một đối tượng
        if (!(obj instanceof Track)) return false; // Kiểm tra loại đối tượng
        Track other = (Track) obj; // Ép kiểu đối tượng sang Track
        // Kiểm tra title và length có giống nhau không
        return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
    }

    // Hiển thị thông tin track
    @Override
    public String toString() {
        return String.format("Track: %s - %d sec", title, length);
    }

    // Phát track
    @Override
    public void play() {
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
}

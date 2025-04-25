package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor 
    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Thêm Track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" đã tồn tại.");
        } else {
            tracks.add(track);
            System.out.println("Đã thêm track \"" + track.getTitle() + "\".");
        }
    }

    // Xoá Track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xoá track \"" + track.getTitle() + "\".");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" không tồn tại.");
        }
    }

    // Tính tổng độ dài CD
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Play method 
    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total Length: " + getLength() + " seconds.");
        for (Track track : tracks) {
            track.play();
        }
    }
    
    @Override
    public String toString() {
        return String.format("CD - %s - %s - %s: %.2f $", 
            getTitle(), getCategory(), getDirector(), getCost());
    }
}

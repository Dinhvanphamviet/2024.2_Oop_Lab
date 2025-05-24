package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import hust.soict.hedspi.aims.exception.PlayerException;
import javax.swing.JOptionPane;

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
    
    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost); 
        this.artist = artist;
        this.tracks = new ArrayList<>();
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

    // Play method với try-catch bắt PlayerException khi chơi từng track
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }

    
    @Override
    public String toString() {
        return String.format("CD - %s - %s - %s: %.2f $", 
            getTitle(), getCategory(), getDirector(), getCost());
    }
}

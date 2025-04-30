package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);

            // Thêm sự kiện cho nút Play
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showPlayDialog((Playable) media);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void showPlayDialog(Playable playableMedia) {
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing Media");

        Media m = (Media) playableMedia;
        String message = "Playing: " + m.getTitle();

        // Nếu media có độ dài
        if (m instanceof hust.soict.hedspi.aims.media.DigitalVideoDisc) {
            int length = ((hust.soict.hedspi.aims.media.DigitalVideoDisc) m).getLength();
            message += " (" + length + " minutes)";
        }

        JLabel playLabel = new JLabel(message);
        playLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playLabel.setHorizontalAlignment(SwingConstants.CENTER);

        playDialog.add(playLabel);
        playDialog.setSize(350, 150);
        playDialog.setLocationRelativeTo(null);
        playDialog.setVisible(true);

        playableMedia.play();
    }

}

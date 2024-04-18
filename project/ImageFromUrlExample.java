import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageFromUrlExample extends Frame {

    private BufferedImage image;

    public ImageFromUrlExample() {
        super("Image from URL Example");

        try {
            // Specify the URL of the image
            @SuppressWarnings("deprecation")
            URL url = new URL("https://img.freepik.com/free-photo/copy-space-cinema-equipment_23-2148470220.jpg?t=st=1713460343~exp=1713463943~hmac=c154bce857cb0beee51d853ce72ca5096c744eb994fc53852a273ca87b56d410&w=900");

            // Read the image from the URL
            image = ImageIO.read(url);

            // Create a panel to display the image
            ImagePanel imagePanel = new ImagePanel(image);
            add(imagePanel);

            // Set a fixed smaller size for the frame
            setSize(400, 300); // Adjust width and height as needed
            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ImageFromUrlExample();
    }
}

class ImagePanel extends Panel {
    private BufferedImage image;
    private static final int DISPLAY_WIDTH = 200; // Desired width for displaying the image
    private static final int DISPLAY_HEIGHT = 150; // Desired height for displaying the image

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (image != null) {
            // Draw the image at a scaled size
            g.drawImage(image, 30, 40, DISPLAY_WIDTH, DISPLAY_HEIGHT, null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Override getPreferredSize to specify the preferred size of this panel
        return new Dimension(DISPLAY_WIDTH + 60, DISPLAY_HEIGHT + 80); // Add margins for better visibility
    }
}



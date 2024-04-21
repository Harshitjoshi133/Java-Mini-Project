import java.awt.*;
import java.awt.event.*;

// Custom button class that extends Canvas
class ImageButton extends Canvas {
    private Image image;

    public ImageButton(Image image) {
        this.image = image;
        // Set preferred size of the button based on the image dimensions
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));

        // Add mouse listener to handle button clicks (optional)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle button click action here (e.g., show a message)
                System.out.println("Button Clicked!");
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // Draw the image on the button's surface
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}

public class AWTImageButtonExample {

    public static void main(String[] args) {
        // Create a frame
        Frame frame = new Frame("AWT Image Button Example");

        // Load an image from file
        Image image = Toolkit.getDefaultToolkit().getImage("project\\images\\pnd.png");

        // Create an image button with the loaded image
        ImageButton imageButton = new ImageButton(image);

        // Add the image button to the frame
        frame.add(imageButton, BorderLayout.CENTER);

        // Set frame size and make it visible
        frame.setSize(200, 200); // Set size as needed
        frame.setVisible(true);

        // Handle window close event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

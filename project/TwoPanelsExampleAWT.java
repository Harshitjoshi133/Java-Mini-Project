
import java.awt.*;

public class TwoPanelsExampleAWT {
    public static void main(String[] args) {
        Frame frame = new Frame("Two Panels Example");
        frame.setSize(400, 300);

        // Create a panel to hold two sub-panels
        Panel containerPanel = new Panel(new GridLayout(1, 2)); // 1 row, 2 columns

        // Create the left panel
        Panel leftPanel = new Panel();
        leftPanel.setBackground(Color.BLUE);
        Label leftLabel = new Label("Left Panel");
        leftLabel.setForeground(Color.WHITE);
        leftPanel.add(leftLabel);

        // Create the right panel
        Panel rightPanel = new Panel();
        rightPanel.setBackground(Color.ORANGE);
        Label rightLabel = new Label("Right Panel");
        rightLabel.setForeground(Color.WHITE);
        rightPanel.add(rightLabel);

        // Add left and right panels to the container panel
        containerPanel.add(leftPanel);
        containerPanel.add(rightPanel);

        // Add the container panel to the frame
        frame.add(containerPanel);

        // Set frame visible
        frame.setVisible(true);

        // Handle window closing event
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}

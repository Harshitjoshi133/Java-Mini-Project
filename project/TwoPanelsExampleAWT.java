
import java.awt.*;

import javax.swing.BoxLayout;

public class TwoPanelsExampleAWT {
    public static void main(String[] args) {
        Frame frame = new Frame("Two Panels Example");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        // Create a panel to hold two sub-panels
        Panel containerPanel = new Panel(new GridLayout(1, 2)); // 1 row, 2 columns
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label confirmPasswordLabel = new Label("Confirm Password:");
        TextField usernameField = new TextField(20);
        TextField passwordField = new TextField(20);
        passwordField.setEchoChar('*');
        TextField confirmPasswordField = new TextField(20);
        confirmPasswordField.setEchoChar('*');

        Button registerButton = new Button("Register");
        //registerButton.addActionListener(this);

        // usernameLabel.setBounds(50, 100, 80, 20);
        // passwordLabel.setBounds(50, 120, 80, 20);
        // confirmPasswordLabel.setBounds(50, 140, 80, 20);
        // usernameField.setBounds(140, 100, 80, 20);
        // passwordField.setBounds(140, 120, 80, 20);
        // confirmPasswordField.setBounds(140, 140, 80, 20);
        System.out.println(usernameField.getBounds());
        System.out.println(passwordField.getBounds());
        System.out.println(confirmPasswordField.getBounds());
        System.out.println(usernameLabel.getBounds());
        System.out.println(passwordLabel.getBounds());
        System.out.println(confirmPasswordLabel.getBounds());
        //System.out.println(usernameField.getBounds());
       
        // Create the left panel
        Panel leftPanel = new Panel();
        leftPanel.setBackground(Color.BLUE);
        Label leftLabel = new Label("Left Panel");

        // Create the right panel
        Panel rightPanel = new Panel(new FlowLayout(0, 50, 10));
        rightPanel.setBackground(Color.ORANGE);
        Label rightLabel = new Label("Right Panel");
        rightLabel.setForeground(Color.WHITE);
        //rightPanel.add(rightLabel);
        leftLabel.setForeground(Color.WHITE);
        //leftPanel.add(leftLabel);
        rightPanel.add(usernameLabel);
        rightPanel.add(usernameField);
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordField);
        rightPanel.add(confirmPasswordLabel);
        rightPanel.add(confirmPasswordField);
        rightPanel.add(registerButton);
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

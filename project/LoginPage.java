import java.awt.*;
import java.awt.event.*;

public class LoginPage extends Frame implements ActionListener {
    private TextField usernameField;
    private TextField passwordField;
    private Button loginButton;
    private Button registerButton;

    public LoginPage() {
        setTitle("Login Page");
        setSize(300, 200); // Fixed size for the frame
        setLayout(null); // Use null layout to set absolute positions

        // Create components
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        usernameField = new TextField();
        passwordField = new TextField();
        passwordField.setEchoChar('*'); // Mask password characters

        loginButton = new Button("Login");
        loginButton.addActionListener(this);

        registerButton = new Button("Register");
        registerButton.addActionListener(this);

        // Set absolute positions and sizes for each component
        usernameLabel.setBounds(50, 50, 80, 20); // x, y, width, height
        usernameField.setBounds(140, 50, 120, 20);
        passwordLabel.setBounds(50, 80, 80, 20);
        passwordField.setBounds(140, 80, 120, 20);
        loginButton.setBounds(100, 120, 80, 30);
        registerButton.setBounds(190, 120, 80, 30);

        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        setVisible(true);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Handle login logic here (e.g., validate username/password)
            setVisible(false); // Hide the login window

            // Example: Open a new window (MovieSelection)
            new MovieSelection();
        } else if (e.getSource() == registerButton) {
            // Handle registration button click
            setVisible(false); // Hide the login window

            // Example: Open a new registration window
            new RegistrationPage();
        }
    }
}

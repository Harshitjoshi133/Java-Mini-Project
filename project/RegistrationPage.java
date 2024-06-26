import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

import javax.imageio.ImageIO;

import Apology.apology;


public class RegistrationPage extends Frame implements ActionListener {
    private TextField usernameField;
    private TextField passwordField;
    private TextField confirmPasswordField;
    private Button registerButton;
    private BufferedImage backgroundImage;
    public RegistrationPage() {
        setTitle("Login Page");
        setSize(1295, 687); // Fixed size for the frame
        setLayout(null); // Use null layout to set absolute positions
        
        try {
            // Load the background image from a URL
            @SuppressWarnings("deprecation")
            URL imageUrl = new URL("https://img.freepik.com/free-photo/copy-space-cinema-equipment_23-2148470220.jpg?t=st=1713460343~exp=1713463943~hmac=c154bce857cb0beee51d853ce72ca5096c744eb994fc53852a273ca87b56d410&w=900");
            //@SuppressWarnings("deprecation")
            //URL imageurl = new URL("");
            backgroundImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        // Create components
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label confirmPasswordLabel=new Label("Confirm Password");
        
        usernameField = new TextField();
        passwordField = new TextField();
        confirmPasswordField = new TextField();
        
        passwordField.setEchoChar('*');
        confirmPasswordField = new TextField();
        confirmPasswordField.setEchoChar('*'); // Mask password characters

        registerButton = new Button("Register");
        registerButton.addActionListener(this);
        
        Label loginLabel=new Label("Registration");
        loginLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        

       
        //Setting the Backgrounds and Foregrounds of the Fields
        usernameLabel.setBackground(new Color(153,143,193));
        passwordLabel.setBackground(new Color(153,143,193));
        confirmPasswordLabel.setBackground(new Color(153,143,193));
        loginLabel.setBackground(new Color(153,143,193));
        registerButton.setForeground(new Color(153,143,193));
        // Set absolute positions and sizes for each component
        
        loginLabel.setBounds(800,150,140,40);
        usernameLabel.setBounds(700, 250, 80, 20); // x, y, width, height
        usernameField.setBounds(820, 250, 120, 20);
        passwordLabel.setBounds(700, 280, 80, 20);
        passwordField.setBounds(820, 280, 120, 20);
        confirmPasswordLabel.setBounds(700,310,120,20);
        confirmPasswordField.setBounds(820,310,120,20);
        registerButton.setBounds(840, 340, 80, 30);

        // Add components to the frame
        add(loginLabel);
        add(usernameLabel);
        add(confirmPasswordLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordField);
        
        
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
        if (e.getSource() instanceof Button) {
            if (e.getActionCommand().equals("Register")) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    new apology("Please fill in all fields.");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    new apology("Passwords do not match!");
                    return;
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaminiproject", "root", "Harshit@99");
                    
                    // Check if username already exists
                    PreparedStatement checkStatement = connection.prepareStatement("SELECT name FROM users WHERE name = ?");
                    checkStatement.setString(1, username);
                    ResultSet resultSet = checkStatement.executeQuery();
                    
                    if (resultSet.next()) {
                        new apology("User already exists!");
                        resultSet.close();
                        checkStatement.close();
                        connection.close();
                        return;
                    }

                    // Insert new user
                    PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (name, password) VALUES (?, ?)");
                    insertStatement.setString(1, username);
                    insertStatement.setString(2, password);
                    int rowsInserted = insertStatement.executeUpdate();

                    if (rowsInserted > 0) {
                        new RegistrationSuccess("User registered successfully!");
                        setVisible(false);
                        
                        //new LoginPage(); // Open a login page or handle accordingly
                    } else {
                       new apology("Failed to register user!");
                    }

                    insertStatement.close();
                    connection.close();
                } catch (SQLException ex) {
                    new apology("Error: " + ex.getMessage());
                }
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the background image
        if (backgroundImage != null) {
            // Scale the image to fill the frame
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

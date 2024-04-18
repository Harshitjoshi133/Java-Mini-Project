import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import Apology.apology;

public class RegistrationPage extends Frame implements ActionListener {
    private TextField usernameField;
    private TextField passwordField;
    private TextField confirmPasswordField;

    public RegistrationPage() {
        setTitle("Registration Page");
        setSize(300, 300);
        setResizable(false);
        setLayout(new GridLayout(4, 1));

        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label confirmPasswordLabel = new Label("Confirm Password:");
        usernameField = new TextField(20);
        passwordField = new TextField(20);
        passwordField.setEchoChar('*');
        confirmPasswordField = new TextField(20);
        confirmPasswordField.setEchoChar('*');

        Button registerButton = new Button("Register");
        registerButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(registerButton);

        setLocationRelativeTo(null);
        setVisible(true);

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
}

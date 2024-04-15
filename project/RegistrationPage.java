
import java.awt.*;
import java.awt.event.*;


public class RegistrationPage extends Frame implements ActionListener {
    private TextField usernameField;
    private TextField passwordField;
    private TextField confirmPasswordField;
   // private Button loginButton;
    private Button RegisterButton;
    RegistrationPage(){
        setTitle("Registration Page");
        setSize(300, 300);
        setResizable(false);
        setLayout(new GridLayout(4, 1)); // Using GridLayout for simplicity

        // Create components
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label confirmPasswordLabel = new Label(" Confirm Password:");
        usernameField = new TextField(20);
        passwordField = new TextField(20);
        passwordField.setEchoChar('*'); // Set password field to show '*'
        confirmPasswordField = new TextField(20);
        confirmPasswordField.setEchoChar('*');
        RegisterButton=new Button("register");
        RegisterButton.addActionListener(this);
        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(RegisterButton);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); 
            }
        });
    }
    
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==RegisterButton){
                setVisible(false);
                new LoginPage();
            }
        }
    public static void main(String[] args){
        new LoginPage();
    }
}

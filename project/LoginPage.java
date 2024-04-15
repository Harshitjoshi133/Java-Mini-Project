
import java.awt.*;
import java.awt.event.*;


public class LoginPage extends Frame implements ActionListener {
    private TextField usernameField;
    private TextField passwordField;
    private Button loginButton;
    private Button RegisterButton;
    LoginPage(){
        setTitle("Login Page");
        setSize(300, 300);
        setResizable(false);
        setLayout(new GridLayout(3, 2)); // Using GridLayout for simplicity

        // Create components
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        usernameField = new TextField(20);
        passwordField = new TextField(20);
        passwordField.setEchoChar('*'); // Set password field to show '*'
        setLocationRelativeTo(null);
        loginButton = new Button("Login");
        loginButton.addActionListener(this);
        RegisterButton=new Button("register");
        RegisterButton.addActionListener(this);
        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(RegisterButton);

        setVisible(true);
        
        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); 
            }
        });
    }
    
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==loginButton){
                setVisible(false);
                new MovieSelection();
                System.out.println(e.getSource());
            }
            if(e.getSource()==RegisterButton){
                setVisible(false);
                new RegistrationPage();
            }
        }
    public static void main(String[] args){
        new LoginPage();
    }
}

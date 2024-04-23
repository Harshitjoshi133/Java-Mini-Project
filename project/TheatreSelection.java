import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class TheatreSelection extends Frame implements ActionListener {

    private String user;
    private String movie;
    private LocalTime[] bookingTimes;
    private Button[] timebutton;

    public TheatreSelection(String movieName, String userName) {
        user = userName;
        movie=movieName;
        setTitle(movieName + "  " + userName);
        setSize(1295, 687);
        setBackground(Color.GRAY);
        setLocationRelativeTo(null);
        setLayout(null);

        // Header for the App
        Button logoutButton = new Button("Logout");
        logoutButton.setBounds(1150, 10, 120, 60);
        logoutButton.setBackground(Color.GRAY);
        // Add ActionListener for LogoutButton here

        Label titleLabel = new Label("Theatre Selection");
        titleLabel.setBounds(550, 10, 200, 100);

        Panel panel = new Panel(new FlowLayout());
        panel.setBounds(50, 120, 1200, 500);

        LocalTime currentTime = LocalTime.now();
        bookingTimes = new LocalTime[3]; 
        bookingTimes[0]=LocalTime.of(22, 50);
        bookingTimes[1]=LocalTime.of(22, 40);
        bookingTimes[2]=LocalTime.of(22, 30);
        timebutton=new Button[3];
        for (int i=0;i<3;i++) {
            if (currentTime.isBefore(bookingTimes[i])) {
                timebutton[i] = new Button(bookingTimes[i].toString());
                timebutton[i].addActionListener(this);
                panel.add(timebutton[i]);
            }
        }

        add(logoutButton);
        add(titleLabel);
        add(panel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //LocalDateTime book;
        for(Button btn:timebutton){
            if(e.getSource()==btn){
                new SeatSelectionFrame(user,movie,btn);
            }
        }
    }
    public static void main(String[] args) {
        new TheatreSelection("noob","chup");
    }
}



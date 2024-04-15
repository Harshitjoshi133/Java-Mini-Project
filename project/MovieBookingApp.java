import java.awt.*;

public class MovieBookingApp extends Frame {
    public MovieBookingApp() {
        setTitle("Movie Booking App");
        setSize(800, 600); 
        setLayout(new BorderLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        new MovieBookingApp();
    }
}

import java.awt.*;
import java.awt.event.*;
//import ConfirmationPage.*;
//import ConfirmationPage.ConfirmationPage;

public class SeatSelectionFrame extends Frame implements ActionListener {
    private Button[][] seatButtons;
    private Button selectedButton;
    private Button bookButton;

    public SeatSelectionFrame(String s,String t,Button b) {
        setTitle(s+" "+t+" "+" "+b.getLabel());
        setSize(400, 400);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(5, 5, 5, 5));
        setLocationRelativeTo(null);
        seatButtons = new Button[5][5];
        selectedButton = null;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seatButtons[i][j] = new Button("Seat " + (i * 5 + j + 1));
                seatButtons[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                seatButtons[i][j].addActionListener(this);
                add(seatButtons[i][j]);
            }
        }
        bookButton = new Button("Book");
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        bookButton.addActionListener(this);
        add(bookButton);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        if(e.getSource()==bookButton){
            setVisible(false);
            new ConfirmationPage();
            System.out.println(e.getSource());
        }
        if (selectedButton != null && selectedButton != clickedButton) {
            // Reset background color of previously selected button
            selectedButton.setBackground(null);
        }

        // Toggle selection (change background color)
        if (clickedButton == selectedButton) {
            // Deselect the currently selected button
            clickedButton.setBackground(null);
            selectedButton = null;
            System.out.println("Seat deselected.");
        } else {
            // Select the clicked button
            clickedButton.setBackground(Color.GREEN); // Highlight selected seat
            selectedButton = clickedButton;
            String seatNumber = clickedButton.getLabel();
            System.out.println("Selected Seat: " + seatNumber);
        }
    }
}

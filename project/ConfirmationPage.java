import java.awt.*;
import java.awt.event.*;

public class ConfirmationPage extends Frame implements ActionListener{
    private Button btn;
    public ConfirmationPage(){
        setSize(300,100);
        setLayout(new GridLayout(3, 1)); 
        TextField t=new TextField();
        
        t.setText("Seat is Confirmed");
        add(t);
        btn=new Button("Hello");
        btn.addActionListener(this);
        add(btn);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); // Close the window
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==btn){
            new SeatSelectionFrame(getName(), getTitle(), getWarningString(), getName());
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

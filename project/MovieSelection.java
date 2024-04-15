import java.awt.*;
import java.awt.event.*;

public class MovieSelection extends Frame implements ActionListener{
    private Choice movieChoice;
    private Button selectButton;
    private Label selectedMovieLabel;

    public MovieSelection() {
        setTitle("Movie Selection");
        setSize(300, 150);
        setLayout(new FlowLayout());
        //setResizable(false); 
        setLocationRelativeTo(null);
        Label label = new Label("Select Movie:");
        add(label);

        movieChoice = new Choice();
        movieChoice.add("Avengers");
        movieChoice.add("Star Wars");
        movieChoice.add("Titanic");
        add(movieChoice);

        selectButton = new Button("Select");
        
        add(selectButton);
        selectButton.addActionListener(this);
        selectedMovieLabel = new Label();
        add(selectedMovieLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); 
            }
        });

        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==selectButton){
            setVisible(false);
            new SeatSelectionFrame();
            System.out.println(e.getSource());
        }
    }

    public static void main(String[] args) {
        new MovieSelection();
    }
}

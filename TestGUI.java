import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description of class TestGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestGUI implements ActionListener
{
    // instance variables - replace the example below with your own
    private int x;
    private JFrame frame;
    private JPanel panel;
    private JButton b1, b2, b3;
    private JTextField text;

    /**
     * Constructor for objects of class TestGUI
     */
    public TestGUI()
    {
        // initialise instance variables
        frame = new JFrame ("CHATBOT- ");
        frame.setSize (500, 500);
        frame.setResizable (false);
        panel = new JPanel ();
        
        // create new jbutton and and listener
        b1 = new JButton ("This is my first Button");
        b1.addActionListener (this);
        
        text = new JTextField ("Please enter questions here");
        
        panel.add (text);
        panel.add (b1);
        
        frame.add (panel);
        
        frame.setVisible (true);
    
    }
    
    public void createAndAssignButtons ()
    {
        b1 = new JButton ("This is my first Button");
        b1.addActionListener (this);
        
        b2 = new JButton ("This is my first Button");
        b2.addActionListener (this);
        
        b3 = new JButton ("This is my first Button");
        b3.addActionListener (this);

    }
    
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == b1)
        {
            text.setText ("Button was created");
        }
        System.out.println ("the event is " + e);
    }

}

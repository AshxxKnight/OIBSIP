import java.awt.*;
import java.awt.event.*;

public class GuessGame implements ActionListener 
{
    static int testVal;
    static int k = 5; 

    Frame frame = new Frame();
    Label l1 = new Label("Enter your guess ");
    Label l2 = new Label("Guess Remaining : " + String.valueOf(k));

    TextField t1 = new TextField();
    Label result = new Label();
    
    Button b1 = new Button("Evaluate Guess");
    Button b2 = new Button("Exit");
    Button b3 = new Button("Play Again");

    GuessGame()
    {
        l1.setBounds(50,140,100,20); 
        l2.setBounds(50, 100, 200, 20);

        t1.setBounds(200,140,100,20);

        result.setBounds(50, 200,300,20);

        b1.setBounds(50,250, 100,20);
        b2.setBounds(200,250,50,20);
        b3.setBounds(50,250,100,20);

        frame.add(l1); 
        frame.add(l2); 
        frame.add(result);
        frame.add(t1); 

        frame.add(b1); frame.add(b2); 
        frame.add(b3); 

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        frame.setLayout(null);
        frame.setVisible(true);

        b3.setVisible(false);
        frame.setSize(350,350);
        generateRandom();
    }
    
    private void generateRandom()
    {
        testVal = 1 + (int)(100 * Math.random());
    }   

    private void evalFunction(int guessVal)
    {
       
        if(guessVal < 0 || guessVal > 100)
        {
            result.setText("Please enter a number between 1 to 100");
            return;
        }
        
        
        if(k > 1)
        {
            k--;
            l2.setText("Guess Remaining : " + String.valueOf(k));
            if(guessVal > testVal)
                result.setText("Your Guess is greater !!");
                
            else if(guessVal < testVal)
                result.setText("Your Guess is smaller !! ");
            
            else
            {
                result.setText("Correct Guess !! ");
                b3.setVisible(true);
                b1.setVisible(false);
                return;
            }
        }
        else
        {
            b1.setVisible(false);
            b3.setLabel("Try Again");
            b3.setVisible(true);
            l2.setText("Out of guesses !!");
            result.setText("Correct guess : " + String.valueOf(testVal));
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b2) { System.exit(0); }

        int guessVal = Integer.parseInt(t1.getText());

        if(e.getSource() == b1) { evalFunction(guessVal); } 

        if(e.getSource() == b3) 
        {
            k = 5;
            new GuessGame();
            evalFunction(guessVal);
        }
    }
    public static void main(String args[])
    { 
        new GuessGame(); 
    }
}
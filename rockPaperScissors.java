import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class rockPaperScissors extends JFrame
{
  private JButton rock;
  private JButton paper;
  private JButton scissors;
  private JLabel comp;
  private JTextField choice;
  private JTextField results;
  private Random compPick;
  
  public rockPaperScissors()
  {
    super("Rock Paper Scissors");
    setSize(250,125);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    rock = new JButton("Rock");
    rock.addActionListener(new ButtonListener());
    paper = new JButton("Paper");
    paper.addActionListener(new ButtonListener());
    scissors = new JButton("Scissors");
    scissors.addActionListener(new ButtonListener());
    comp = new JLabel("Computer picks: ");
    choice = new JTextField(10);
    choice.setEditable(false);
    results = new JTextField(10);
    results.setEditable(false);
    
    add(rock);
    add(paper);
    add(scissors);
    add(comp);
    add(choice);
    add(results);
    setVisible(true);
  }
  
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String player = e.getActionCommand();
      compPick = new Random();
      int computer = compPick.nextInt(3)+1;
      int playerNum =0;
      if(player =="Rock")
        playerNum = 1;
      else if(player =="Paper")
        playerNum =2;
      else if(player =="Scissors")
        playerNum=3;
      
      if(computer ==1)
        choice.setText("Rock");
      else if(computer==2)
        choice.setText("Paper");
      else if(computer==3)
        choice.setText("Scissors");
      
      if(playerNum == computer)
        results.setText("Tie!");
      else if((computer==1 && playerNum==3)||(computer==2 && playerNum==1)||(computer==3 && playerNum==2))
        results.setText("You lose!");
      else if((computer==3 && playerNum==1)||(computer==1 && playerNum==2)||(computer==2 && playerNum==3))
        results.setText("You win!");
      
    }
  }
  
  public static void main(String[] args)
  {
    new rockPaperScissors();
  }
}
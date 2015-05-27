import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class joeTow extends JFrame
{
  private JButton total;
  private JCheckBox oil;
  private JCheckBox lube;
  private JCheckBox flush;
  private JCheckBox trans;
  private JCheckBox inspect;
  private JCheckBox muffler;
  private JCheckBox tire;
  private double cost = 0.00;
  private JLabel parts;
  private JLabel labor;
  private JTextField partsUsed;
  private JTextField laborSpent;
  
  public joeTow()
  {
    super("Total Work");
    
    setSize(400,300);
    setLayout(new GridLayout(12,2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    oil = new JCheckBox("Oil Change");
    oil.addItemListener(new CheckItemListener());
    lube = new JCheckBox("Lube job");
    lube.addItemListener(new CheckItemListener());
    flush = new JCheckBox("Radiator Flush");
    flush.addItemListener(new CheckItemListener());
    trans = new JCheckBox("Transmission Flush");
    trans.addItemListener(new CheckItemListener());
    inspect = new JCheckBox("Inspection");
    inspect.addItemListener(new CheckItemListener());
    muffler = new JCheckBox("Muffler Replacement");
    muffler.addItemListener(new CheckItemListener());
    tire = new JCheckBox("Tire Rotation");
    tire.addItemListener(new CheckItemListener());
    
    parts = new JLabel("# parts used:");
    partsUsed = new JTextField(5);
    partsUsed.setText("0");
    labor = new JLabel("Hours of labor:");
    laborSpent = new JTextField(5);
    laborSpent.setText("0");
    
    total = new JButton("Total");
    total.addActionListener(new findTotal());
    add(oil);
    add(lube);
    add(flush);
    add(trans);
    add(inspect);
    add(muffler);
    add(tire);
    add(parts);
    add(partsUsed);
    add(labor);
    add(laborSpent);
    add(total);
    
    setVisible(true);
  }
  
  private class CheckItemListener implements ItemListener
  {
    public  void itemStateChanged(ItemEvent e)
    {
      if(oil.isSelected())
        cost = cost + 26.00;

      if(lube.isSelected())
        cost = cost + 18.00;
      
      if(flush.isSelected())
        cost = cost + 30.00;
     
      if(trans.isSelected())
        cost = cost + 80.00;

      if(inspect.isSelected())
        cost = cost + 15.00;

      if(muffler.isSelected())
        cost = cost + 100.00;
       
      if(tire.isSelected())
        cost = cost + 20.00;
      
    }
  }
  private class findTotal implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String parts2 = "0";
      String labor2 = "0";
      double p2 = 0.00;
      double l2 = 0.00;
      
      if(partsUsed.getText()!=null)
      {
        parts2 = partsUsed.getText();
        p2 = Double.parseDouble(parts2);
        cost = cost + p2;
      }
      
      if(laborSpent.getText()!=null)
      {
      labor2= laborSpent.getText();
      l2 = Double.parseDouble(labor2);
      cost = cost + (l2*20.00);
      }
      
      JOptionPane.showMessageDialog(null,"Total is "+cost);
      cost = 0.00;
    }
  }
  public static void main(String[] args)
  {
    new joeTow();
  }
}
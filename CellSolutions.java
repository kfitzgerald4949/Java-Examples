import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.NumberFormat;

public class CellSolutions extends JFrame
{
  private JMenuBar menuBar;
  private JMenu packOptions;
  private JMenu cellOptions;
  private JMenu addOns;
  private JRadioButtonMenuItem pack1;
  private JRadioButtonMenuItem pack2;
  private JRadioButtonMenuItem pack3;
  private JRadioButtonMenuItem cell1;
  private JRadioButtonMenuItem cell2;
  private JRadioButtonMenuItem cell3;
  private JCheckBoxMenuItem voiceOption;
  private JCheckBoxMenuItem textOption;
  
  private JTextField total;
  private double cost = 0.00;
  
  public CellSolutions()
  {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3,2));
   
    menuBar = new JMenuBar();
    
    packOptions = new JMenu("Package Options");
    pack1 = new JRadioButtonMenuItem("300 Minutes per month...$45.00");
    pack1.addActionListener(new ChoiceListener());
    pack2 = new JRadioButtonMenuItem("800 Minutes per month...$65.00");
    pack2.addActionListener(new ChoiceListener());
    pack3 = new JRadioButtonMenuItem("1500 Minutes per month...$99.00");
    pack3.addActionListener(new ChoiceListener());
    packOptions.add(pack1);
    packOptions.add(pack2);
    packOptions.add(pack3);
    ButtonGroup packG = new ButtonGroup();
    packG.add(pack1);
    packG.add(pack2);
    packG.add(pack3);
    
    cellOptions = new JMenu("Cell Options");
    cell1 = new JRadioButtonMenuItem("Model 100...$29.95");
    cell1.addActionListener(new ChoiceListener());
    cell2 = new JRadioButtonMenuItem("Model 110...$49.95");
    cell2.addActionListener(new ChoiceListener());
    cell3 = new JRadioButtonMenuItem("Model 200...$99.95");
    cell3.addActionListener(new ChoiceListener());
    cellOptions.add(cell1);
    cellOptions.add(cell2);
    cellOptions.add(cell3);
    ButtonGroup cellG = new ButtonGroup();
    cellG.add(cell1);
    cellG.add(cell2);
    cellG.add(cell3);
    
    addOns = new JMenu("Additions");
    voiceOption = new JCheckBoxMenuItem("Voice Mail...$5.00");
    voiceOption.addActionListener(new ChoiceListener());
    textOption = new JCheckBoxMenuItem("TextMessaging...$10.00");
    textOption.addActionListener(new ChoiceListener());
    addOns.add(voiceOption);
    addOns.add(textOption);
    
    menuBar.add(packOptions);
    menuBar.add(cellOptions);
    menuBar.add(addOns);
    setJMenuBar(menuBar);
    
    total = new JTextField(10);
    total.setEditable(false);
    total.setText("0.00");
    
    add(total);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  public class ChoiceListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if(cell1.isSelected())
        cost += 29.95 + (29.95*0.06);
      else if(cell2.isSelected())
        cost += 49.95 + (49.95*0.06);
      else if(cell3.isSelected())
        cost += 99.95 +(99.95*0.06);
      
      if(pack1.isSelected())
        cost += 45.00;
      else if(pack2.isSelected())
        cost += 65.00;
      else if(pack3.isSelected())
        cost += 99.99;
      
      if(voiceOption.isSelected())
        cost += 5.00;
      if(textOption.isSelected())
        cost += 10.00;
      
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      total.setText(currency.format(cost)+" per month");
      cost = 0.00;
    }
  }
  
  
  public static void main(String[] args)
 {
  new CellSolutions();
 }
}
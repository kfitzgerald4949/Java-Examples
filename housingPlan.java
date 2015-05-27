import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class housingPlan extends JFrame
{
  private JPanel housingPanel;
  private JPanel mealPanel;
  private JPanel selectedPanel;
  private JComboBox mealPlan;
  private JComboBox building;
  private JLabel label;
  private JLabel cost;
  private JTextField selectedPlan;
  private JTextField total;
  
  private String[] housing = {"Allen Hall","Pike Hall","Farthing Hall","University Suites"};
  private String[] meals = {"7 meals per week","14 meals per week","Unlimited meals"};
  
  public housingPlan()
  {
    super("Housing options");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3,1));
    buildHousingPanel();
    buildMealPanel();
    buildSelectedPanel();
    
    add(housingPanel);
    add(mealPanel);
    add(selectedPanel);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  public void buildHousingPanel()
  {
    housingPanel = new JPanel();
    building = new JComboBox(housing);
    building.addActionListener(new ComboBoxListener());
    housingPanel.add(building);
  }
  
  public void buildMealPanel()
  {
    mealPanel = new JPanel();
    mealPlan = new JComboBox(meals);
    mealPlan.addActionListener(new ComboBoxListener());
    mealPanel.add(mealPlan);
  }
  
  public void buildSelectedPanel()
  {
   selectedPanel = new JPanel();
   label = new JLabel("You Selected: ");
   selectedPlan = new JTextField(25);
   selectedPlan.setEditable(false);
   cost = new JLabel("Total for semester: ");
   total = new JTextField(10);
   total.setEditable(false);
   selectedPanel.add(label);
   selectedPanel.add(selectedPlan);
   selectedPanel.add(cost);
   selectedPanel.add(total);
  }
  
  private class ComboBoxListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String house = (String)building.getSelectedItem();
      String food = (String)mealPlan.getSelectedItem();
      selectedPlan.setText(house+" with "+food);
      
      double price = 0.00;
      if(house == "Allen Hall")
        price += 1500.00;
      else if(house == "Pike Hall")
        price += 1600.00;
      else if(house == "Farthing Hall")
        price += 1200.00;
      else if(house =="University Suites")
        price +=1800.00;
      else
        price +=0.00;
      
      if(food == "7 meals per week")
        price += 560.00;
      else if(food == "14 meals per week")
        price += 1095.00;
      else if(food == "Unlimited meals")
        price += 1500.00;
      else
        price += 0.00;
      
      String priceS = String.valueOf(price);
      total.setText(priceS);
    }
  }
  public static void main(String[] args)
  {
    new housingPlan();
  }
}
  